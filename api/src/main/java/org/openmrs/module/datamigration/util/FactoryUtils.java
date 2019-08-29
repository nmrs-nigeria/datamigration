package org.openmrs.module.datamigration.util;

import org.openmrs.*;
import org.openmrs.api.context.Context;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class FactoryUtils {
	
	private static String PATIENT_QUERY = "SELECT * FROM patient";
	
	private static String FACILITY_SELECT_QUERY = "SELECT * FROM facility LIMIT 1";
	
	//private static String FACILTY_CREATE_QUERY = "SELECT * FROM facility";
	
	/*This method does the utility connection for the patient*/
	public void PatientUtils(Connection connection) {
		
		try {
			Location location = LocationUtil.InsertLocation(connection, FACILITY_SELECT_QUERY);
			if (location != null) {
				Statement statement = connection.createStatement();
				ResultSet result = statement.executeQuery(PATIENT_QUERY);
				ArrayList<Patient> patients = new ArrayList<Patient>();
				
				if (result.next()) {
					
					do {
						//handle patient
						Patient patient = PatientUtil.InsertPatient(connection, result, location);
						
						//handle encounters and obs
						
					} while (result.next());
					
				} else {
					connection.close();
				}
				
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
