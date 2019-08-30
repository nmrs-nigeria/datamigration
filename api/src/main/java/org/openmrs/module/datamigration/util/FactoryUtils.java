package org.openmrs.module.datamigration.util;

import org.openmrs.*;
import org.openmrs.api.context.Context;
import org.openmrs.module.datamigration.Migration;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class FactoryUtils {
	
	/*This method does the utility connection for the patient*/
	public void PatientUtils(Migration delegate) {
		
		try {
			Location location = LocationUtil.InsertLocation(delegate);
			if (location != null) {
				//handle patient
				Patient patient = PatientUtil.InsertPatient(delegate, location);
				
				//handle encounters and obs

			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
