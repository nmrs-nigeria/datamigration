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
			Encounter encounter = new Encounter();
			encounter.setVisit(new Visit(patient, Context.getVisitService().getVisitType(1), new Date()));
			encounter.setForm(Context.getFormService().getForm(delegate.getEncounters().getFormTypeId()));
			encounter.setEncounterType(Context.getEncounterService().getEncounterType(
			    delegate.getEncounters().getEncounterId()));
			//encounter.setObs(obsSet);
			encounter.setLocation(location);
			encounter.setPatient(patient);
			encounter.setEncounterDatetime(new Date());
			
			//TODO: check if encounter is not existing
			Encounter encounterObj = Context.getEncounterService().saveEncounter(encounter);

			Set<Obs> obsSet = new TreeSet<>();
			for (org.openmrs.module.datamigration.util.Model.Obs _o: delegate.getEncounters().getObs()) {
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
				obs.setEncounter(encounterObj);
				obs.setObsDatetime( new Date());
				obs.setLocation(location);
				obs.setPerson(patient);
				Context.getObsService().saveObs(obs, "");
			}

			return encounter;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
