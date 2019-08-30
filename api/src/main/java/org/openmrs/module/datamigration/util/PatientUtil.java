package org.openmrs.module.datamigration.util;

import org.openmrs.Location;
import org.openmrs.Patient;
import org.openmrs.PatientIdentifier;
import org.openmrs.PersonName;
import org.openmrs.api.context.Context;
import org.openmrs.module.datamigration.Migration;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public abstract class PatientUtil {
	
	public static Patient InsertPatient(Migration delegate, Location location) {
		try {
			Patient patient = new Patient();
			//handle patient identifiers
			Set<PatientIdentifier> patientIdentifiers = new TreeSet<PatientIdentifier>();
			
			PatientIdentifier patientIdentifier = new PatientIdentifier();
			patientIdentifier.setIdentifier(delegate.getHospitalNo());
			patientIdentifier.setLocation(location);
			patientIdentifier.setIdentifierType(Context.getPatientService().getPatientIdentifierType(4));
			patientIdentifier.setPreferred(true);
			patientIdentifiers.add(patientIdentifier);
			
			//handle patient
			patient.setIdentifiers(patientIdentifiers);
			
			patient.addName(new PersonName(delegate.getGivenName(), delegate.getMiddleName(), delegate.getFamilyName()));
			patient.setBirthdate(new Date());
			patient.setGender("M");
			
			//check if the patient exists
			Patient p = Context.getPatientService().getPatientByExample(patient);
			//handle patient save to openmrs
			Context.getPatientService().savePatient(patient);
			return patient;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
