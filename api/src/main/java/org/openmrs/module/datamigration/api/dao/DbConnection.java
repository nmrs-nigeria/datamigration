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
			connection = (Connection) DriverManager.getConnection(nmrsConnection.getUrl().replace("twopointtow", "apindb"),
			    "root", "P@ssw0rd");
			return connection;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
