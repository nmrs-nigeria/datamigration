package org.openmrs.module.datamigration.util;

import org.openmrs.*;
import org.openmrs.module.datamigration.util.Model.Migration;

public class FactoryUtils {
	
	/*This method does the utility connection for the patient*/
	public void PatientUtils(Migration delegate) {
		
		try {
			Location location = LocationUtil.InsertLocation(delegate.getFacility());
			if (location != null) {
				//handle patient
				Patient patient = PatientUtil.InsertPatient(delegate, location);
				
				//handle encounters and obs
				
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			try {
				throw e.getCause();
			}
			catch (Throwable throwable) {
				throwable.printStackTrace();
			}
		}
		
	}
}
