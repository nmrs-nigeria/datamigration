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
		/*Dummy for Identifier type in Memory database*/
		
		PatientIdentifierType type = new PatientIdentifierType(3);
		type.setName("OpenMRS ID");
		//type.setRequired(true);
		Context.getPatientService().savePatientIdentifierType(type);
		
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(FACILITY_SELECT_QUERY);
			Location location = null;
			if (result.next()) {
				location = new Location();
				location.setAddress1(result.getString(result.findColumn("lga")));
				location.setName(result.getString(result.findColumn("facilityname")));
				
				Context.getLocationService().saveLocation(location);
			}
			if (location != null) {
				statement = connection.createStatement();
				result = statement.executeQuery(PATIENT_QUERY);
				ArrayList<Patient> patients = new ArrayList<Patient>();
				
				if (result.next()) {
					
					do {
						/*Person person = new Person();
						person.addName(new PersonName(result.getString(result.findColumn("surname")), result
						        .getString(result.findColumn("othernames")), result.getString(result.findColumn("surname"))));
						person.getPersonName().setPreferred(true);
						person.setGender("M");
						person.setBirthdate(new Date());
						person.setDead(false);
						//person.setPersonVoided(false);
						
						Context.getPersonService().savePerson(person);*/
						
						Patient patient = new Patient();
						
						//handle patient identifiers
						Set<PatientIdentifier> patientIdentifiers = new HashSet<PatientIdentifier>();
						
						PatientIdentifier patientIdentifier = new PatientIdentifier();
						//patientIdentifier.setIdentifier(result.getString(result.findColumn("pepid")));
						patientIdentifier.setIdentifier("1002C4");
						patientIdentifier.setLocation(location);
						//patientIdentifier.setIdentifierType(new PatientIdentifierType(3));
						patientIdentifier.setIdentifierType(Context.getPatientService().getPatientIdentifierType(3));
						patientIdentifier.setPreferred(true);
						patientIdentifiers.add(patientIdentifier);
						
						patientIdentifiers.add(patientIdentifier);
						
						//handle patient
						patient.setIdentifiers(patientIdentifiers);

						//patient.setPersonId(person.getId());
						patient.addName(new PersonName(result.getString(result.findColumn("surname")), result
						        .getString(result.findColumn("othernames")), result.getString(result.findColumn("surname"))));
						patient.setBirthdate(new Date());
						patient.setGender("M");
						
						//handle patient save to openmrs
						Context.getPatientService().savePatient(patient);
						
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
