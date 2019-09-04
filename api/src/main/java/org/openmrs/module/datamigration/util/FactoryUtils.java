package org.openmrs.module.datamigration.util;

import org.openmrs.*;
import org.openmrs.module.datamigration.util.Model.Migration;

import java.text.ParseException;

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
}
