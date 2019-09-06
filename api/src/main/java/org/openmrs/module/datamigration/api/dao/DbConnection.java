package org.openmrs.module.datamigration.api.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import org.openmrs.module.datamigration.NmrsConnection;
import org.openmrs.module.datamigration.util.OptionsUtils;

public class DbConnection {
	
	public Connection Connection(Properties props) {
		Connection connection;
		
		try {
			NmrsConnection nmrsConnection = OptionsUtils.getNmrsConnectionDetails(props);
			connection = DriverManager.getConnection(nmrsConnection.getUrl(), nmrsConnection.getUsername(),
			    nmrsConnection.getPassword());
			return connection;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Connection staticConnection() {
		Connection connection;
		
		try {
			connection = (Connection) DriverManager.getConnection(
			    "jdbc:mysql://127.0.0.1:3306/openmrs?zeroDateTimeBehavior=convertToNull", "root", "Nu66et");
			return connection;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
