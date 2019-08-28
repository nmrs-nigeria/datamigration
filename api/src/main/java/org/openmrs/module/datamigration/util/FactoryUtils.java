package org.openmrs.module.datamigration.util;

import org.openmrs.*;
import org.openmrs.api.context.Context;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class FactoryUtils {
	
	private static String PATIENT_QUERY = "SELECT * FROM patient";
	
	private static String FACILITY_SELECT_QUERY = "SELECT * FROM facility LIMIT 1";
	
	//private static String FACILTY_CREATE_QUERY = "SELECT * FROM facility";
	
	/*This method does the utility connection for the patient*/
	public void PatientUtils(Connection connection) {
		
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(FACILITY_SELECT_QUERY);
			Location location;
			Location dbLocation = null;
			if (result.next()) {
				location = new Location();
				location.setAddress1(result.getString(result.findColumn("lga")));
				location.setName(result.getString(result.findColumn("facilityname")));
				
				dbLocation = Context.getLocationService().saveLocation(location);
			}
			
			if (dbLocation.getId() != null) {
				statement = connection.createStatement();
				result = statement.executeQuery(PATIENT_QUERY);
				ArrayList<Patient> patients = new ArrayList<Patient>();
				
				if (result.next()) {
					
					do {
						Patient patient = new Patient();
						
						//handle patient identifiers
						Set<PatientIdentifier> patientIdentifiers = new HashSet<PatientIdentifier>();
						
						PatientIdentifier patientIdentifier = new PatientIdentifier();
						//patientIdentifier.setIdentifier(result.getString(result.findColumn("pepid")));
						patientIdentifier.setIdentifier("1002C4");
						patientIdentifier.setLocation(dbLocation);
						patientIdentifier.setIdentifierType(new PatientIdentifierType(3));
						patientIdentifier.setPreferred(true);
						patientIdentifiers.add(patientIdentifier);
						
						patientIdentifier = new PatientIdentifier();
						//patientIdentifier.setIdentifier(result.getString(result.findColumn("pepid")));
						patientIdentifier.setIdentifier("GVUMLE");
						patientIdentifier.setLocation(dbLocation);
						patientIdentifier.setIdentifierType(new PatientIdentifierType(2));
						
						patientIdentifiers.add(patientIdentifier);
						
						patientIdentifier = new PatientIdentifier();
						//patientIdentifier.setIdentifier(result.getString(result.findColumn("pepid")));
						patientIdentifier.setIdentifier("GVUMLE");
						patientIdentifier.setLocation(dbLocation);
						patientIdentifier.setIdentifierType(new PatientIdentifierType(1));
						
						patientIdentifiers.add(patientIdentifier);
						
						//handle patient
						patient.setIdentifiers(patientIdentifiers);
						patient.addName(new PersonName(result.getString(result.findColumn("surname")), result
						        .getString(result.findColumn("othernames")), result.getString(result.findColumn("surname"))));
						patient.setBirthdate(result.getDate(result.findColumn("DOB")));
						patient.setGender(result.getString(result.findColumn("sex")));
						
						//patients.add(patient);
						
						//handle patient save to openmrs
						Patient dbPatient = Context.getPatientService().savePatient(patient);
						
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
