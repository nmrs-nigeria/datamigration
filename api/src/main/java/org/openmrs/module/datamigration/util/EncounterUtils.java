package org.openmrs.module.datamigration.util;

import org.openmrs.*;
import org.openmrs.api.context.Context;
import org.openmrs.module.datamigration.util.Model.Migration;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

public abstract class EncounterUtils {
	
	public static Encounter InsertEncounter(Migration delegate, Location location, Patient patient) {
		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			ArrayList<Encounter> encounters = new ArrayList<Encounter>();

			//check for the visit id before inserting a new one
			Date encounterDate = dateFormat.parse(delegate.getEncounters().getEncounterDate());
			Visit visit = Context.getVisitService().getVisitsByPatient(patient).stream()
					.filter(m -> m.getStartDatetime() != null && m.getStartDatetime()
							.equals(encounterDate))
					.findFirst().orElse(null);

			if(visit == null)
			{
				//create the visit
				visit = new Visit(patient, Context.getVisitService().getVisitType(1), encounterDate);
				visit.setStopDatetime(encounterDate);
				visit.setLocation(location);
				visit.setPatient(patient);
			}
			visit = Context.getVisitService().saveVisit(visit);
			Encounter encounter;
			//false is to exclude voided encounters.
			encounter = Context.getEncounterService().getEncountersByVisit(visit, false).stream()
					.filter(m -> m.getVisit().getStartDatetime().equals(encounterDate)).findFirst().orElse(null);
			if(encounter == null){
				encounter = new Encounter();
				encounter.setVisit(visit);
				encounter.setForm(Context.getFormService().getForm(delegate.getEncounters().getFormTypeId()));
				encounter.setEncounterType(Context.getEncounterService().getEncounterType(
						delegate.getEncounters().getEncounterId()));
				encounter.setLocation(location);
				encounter.setPatient(patient);
				encounter.setEncounterDatetime(encounterDate);

				String familyName, givenName, middleName;
				givenName = delegate.getEncounters().getProvider().getGivenName();
				middleName = delegate.getEncounters().getProvider().getMiddleName();
				familyName = delegate.getEncounters().getProvider().getSurname();
				Provider provider;
				//check if the provider is already in the db;
				provider = Context.getProviderService().getAllProviders().stream().filter(m -> m.getPerson().getFamilyName().equals(familyName)
						&& m.getPerson().getGivenName().equals(givenName)).findFirst().orElse(null);
				if(provider == null){
					Person person = new Person();
					Set<PersonName> personNames = new TreeSet<>();
					personNames.add(new PersonName(givenName, middleName, familyName));
					person.setNames(personNames);

					Context.getPersonService().savePerson(person);
					provider = new Provider();
					provider.setPerson(person);

					Context.getProviderService().saveProvider(provider);
				}

				encounter.setProvider(Context.getEncounterService().getEncounterRole(2), provider);

				encounter = Context.getEncounterService().saveEncounter(encounter);
			}

			/*for (org.openmrs.module.datamigration.util.Model.Obs _o: delegate.getEncounters().getObs()) {
				Obs obs = new Obs();

				String obsValueType = _o.getValueTypeId();
				String obsValue = _o.getValue();

				switch (obsValueType){
					case "value_numeric" :
						obs.setValueNumeric(Double.parseDouble(obsValue));
						break;
					case "value_coded" :
						obs.setValueCoded(Context.getConceptService().getConcept(obsValue));
						break;
					case "value_datetime" :
						Date dateVlue = dateFormat.parse(obsValue);
						obs.setValueDatetime(dateVlue);
						break;
					case "value_text" :
						obs.setValueText(obsValue);
						break;
					default:
						obs.setValueText("");
						break;
				}
				obs.setConcept(Context.getConceptService().getConcept(_o.getConceptId()));
				obs.setComment("");
				obs.setEncounter(encounter);
				obs.setObsDatetime(encounterDate);
				obs.setLocation(location);
				obs.setPerson(patient);
				Context.getObsService().saveObs(obs, "");
			}*/

			return encounter;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
