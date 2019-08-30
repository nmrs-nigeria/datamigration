package org.openmrs.module.datamigration.util;

import org.openmrs.Location;
import org.openmrs.Patient;
import org.openmrs.PatientIdentifier;
import org.openmrs.PersonName;
import org.openmrs.api.context.Context;
import org.openmrs.module.datamigration.util.Model.Migration;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

public abstract class PatientUtil {
	
	public static Patient InsertPatient(Migration delegate, Location location) {
		try {
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
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
			patient.setBirthdate(dateFormat.parse(delegate.getBirthDate()));
			patient.setGender(delegate.getGender());
			patient.setDead(Boolean.parseBoolean(delegate.getDead()));
			patient.setDeathDate(dateFormat.parse(delegate.getDeathDate()));
			//patient.setCauseOfDeath(delegate.getCauseOfDeath());

			//check if the patient exists
			/*Patient p = Context.getPatientService().getAllPatients().stream().;*/
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
