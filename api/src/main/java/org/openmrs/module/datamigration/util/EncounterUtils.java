package org.openmrs.module.datamigration.util;

import org.openmrs.*;
import org.openmrs.api.context.Context;
import org.openmrs.module.datamigration.util.Model.Migration;
import org.openmrs.module.datamigration.util.Model.ObsChildren;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

public abstract class EncounterUtils {
	
	public static void InsertEncounter(Migration delegate, Location location, Patient patient) {

        for (org.openmrs.module.datamigration.util.Model.Encounter e : delegate.getEncounters()) {
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                ArrayList<Encounter> encounters = new ArrayList<Encounter>();

                //check for the visit id before inserting a new one
                Date encounterDate = dateFormat.parse(e.getEncounterDate());
                Visit visit = Context.getVisitService().getVisitsByPatient(patient).stream()
                        .filter(m -> m.getStartDatetime() != null && m.getStartDatetime()
                                .equals(encounterDate))
                        .findFirst().orElse(null);

                if (visit == null) {
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
                if (encounter == null) {
                    encounter = new Encounter();
                    encounter.setVisit(visit);
                    encounter.setForm(Context.getFormService().getForm(e.getFormTypeId()));
                    encounter.setEncounterType(Context.getEncounterService().getEncounterType(
                            e.getEncounterTypeId()));
                    encounter.setLocation(location);
                    encounter.setPatient(patient);
                    encounter.setEncounterDatetime(encounterDate);

                    String familyName, givenName, middleName;
                    givenName = e.getProvider().getGivenName();
                    middleName = e.getProvider().getMiddleName();
                    familyName = e.getProvider().getSurname();
                    Provider provider;
                    //check if the provider is already in the db;
                    provider = Context.getProviderService().getAllProviders().stream().filter(m -> m.getPerson().getFamilyName().equals(familyName)
                            && m.getPerson().getGivenName().equals(givenName)).findFirst().orElse(null);
                    if (provider == null) {
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
                //inserting obs
                for (org.openmrs.module.datamigration.util.Model.Obs _o : e.getObs()) {
                    if (_o.getaGroup()) {
                        Obs obs = ObsUtil.InsertObs(_o, encounter, location, patient);
                        Obs groupObs = Context.getObsService().saveObs(obs, "");
                        //inserting obs children
                        for (ObsChildren obsChild : _o.getObsChildren()) {
                            Obs obschild = ObsChildrenUtil.InsertObsChild(obsChild, groupObs, encounter, location, patient);
                            Context.getObsService().saveObs(obschild, "");
                        }
                    } else {
                        Obs obs = ObsUtil.InsertObs(_o, encounter, location, patient);
                        Context.getObsService().saveObs(obs, "");
                    }
                }
                //return encounter;
            } catch (Exception ex) {
                ex.printStackTrace();
                //return null;
            }
        }
    }
}
