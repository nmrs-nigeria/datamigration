package org.openmrs.module.datamigration.util;

import org.openmrs.Location;
import org.openmrs.Patient;
import org.openmrs.PatientIdentifier;
import org.openmrs.PersonName;
import org.openmrs.api.context.Context;
import org.openmrs.module.datamigration.Model.Encounter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

public abstract class EncounterUtils {
	
	public static void InsertEncounter(Connection connection, ResultSet result, Location location) {
		try {
			ArrayList<Encounter> patientIdentifiers = new ArrayList<Encounter>();




			//return null;
		}
		catch (Exception e) {
			e.printStackTrace();
			//return null;
		}
	}
}
