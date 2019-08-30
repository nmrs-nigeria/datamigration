package org.openmrs.module.datamigration.util;

import org.openmrs.Location;
import org.openmrs.api.context.Context;
import org.openmrs.module.datamigration.Migration;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public abstract class LocationUtil {
	
	public static Location InsertLocation(Migration delegate) {
		try {
			Location location = null;
			location = new Location();
			location.setAddress1(delegate.getFamily_name2());
			location.setName(delegate.getName());
			
			//check if location exists
			Location l = Context.getLocationService().getLocation(location.getName());
			if (l != null) {
				return l;
			}
			Context.getLocationService().saveLocation(location);
			return location;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
