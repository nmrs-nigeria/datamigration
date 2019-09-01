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
			Set<Obs> obsSet = new TreeSet<>();
			for (org.openmrs.module.datamigration.util.Model.Obs _o: delegate.getEncounters().getObs()) {
				Obs obs = new Obs();
				obs.setConcept(Context.getConceptService().getConcept(_o.getConceptId()));
				obs.setComment("");
			}
			encounter.setEncounterType(Context.getEncounterService().getEncounterType(delegate.getEncounters().getFormTypeId()));
			encounter.setObs(obsSet);
			encounter.setLocation(location);
			encounter.setPatient(patient);
			encounter.setEncounterDatetime(new Date());

			//TODO: check if encounter is not existing
			Context.getEncounterService().saveEncounter(encounter);
			return encounter;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
