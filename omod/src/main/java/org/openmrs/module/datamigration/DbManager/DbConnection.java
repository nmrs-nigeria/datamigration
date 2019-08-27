package org.openmrs.module.datamigration.DbManager;

import com.mysql.jdbc.Connection;
import org.openmrs.module.datamigration.Model.NmrsConnection;
import org.openmrs.module.datamigration.Utility.OptionsUtils;

import java.sql.DriverManager;

public class DbConnection {
	
	public Connection Connection() {
		Connection connection;
		
		try {
			NmrsConnection nmrsConnection = OptionsUtils.getNmrsConnectionDetails();
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
