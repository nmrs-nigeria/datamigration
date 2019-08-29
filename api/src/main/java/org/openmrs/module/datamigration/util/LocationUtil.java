package org.openmrs.module.datamigration.util;

import org.openmrs.Location;
import org.openmrs.api.context.Context;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public abstract class LocationUtil {
	
	public static Location InsertLocation(Connection connection, String sql) {
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery(sql);
			Location location = null;
			if (result.next()) {
				location = new Location();
				location.setAddress1(result.getString(result.findColumn("lga")));
				location.setName(result.getString(result.findColumn("facilityname")));
				
				//check if location exists
				Location l = Context.getLocationService().getLocation(location.getName());
				if (l != null) {
					return l;
				}
				Context.getLocationService().saveLocation(location);
			}
			return location;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
