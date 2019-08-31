package org.openmrs.module.datamigration.util;

import org.openmrs.Location;
import org.openmrs.module.datamigration.util.Model.mEncounter;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

public abstract class EncounterUtils {
	
	public static void InsertEncounter(Connection connection, ResultSet result, Location location) {
		try {
			ArrayList<mEncounter> patientIdentifiers = new ArrayList<mEncounter>();
			
			//return null;
		}
		catch (Exception e) {
			e.printStackTrace();
			//return null;
		}
	}
}
