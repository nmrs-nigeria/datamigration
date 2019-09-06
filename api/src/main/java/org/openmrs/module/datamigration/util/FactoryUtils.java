package org.openmrs.module.datamigration.util;

import org.openmrs.*;
import org.openmrs.api.context.Context;
import org.openmrs.module.datamigration.util.Model.Migration;

import java.text.ParseException;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class FactoryUtils {
	
	/*This method does the utility connection for the patient*/
	public void PatientUtils(Migration delegate) throws ParseException {
		
		try {
			Location location = LocationUtil.InsertLocation(delegate.getFacility());
			if (location != null) {
				//handle patient
				Patient patient = PatientUtil.InsertPatient(delegate, location);
				
				//handle encounters and obs
				EncounterUtils.InsertEncounter(delegate, location, patient);
			}
		}
		catch (Exception e) {
			throw e;
		}
	}
	
	public static List<EncounterType> getEncounterByEncounterTypeId(int HIV_Enrollment_Encounter_Type_Id) {
       return Context.getEncounterService().getAllEncounterTypes()
               .stream().filter(x->x.getEncounterTypeId() ==HIV_Enrollment_Encounter_Type_Id ).collect(Collectors.toList());
    }
	
	public static List<Patient> getPatients() {
		return Context.getPatientService().getAllPatients();
	}
}
