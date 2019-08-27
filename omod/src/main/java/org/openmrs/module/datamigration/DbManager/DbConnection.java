package org.openmrs.module.datamigration.DbManager;

import com.mysql.jdbc.Connection;

import java.sql.DriverManager;

public class DbConnection {
	
	public Connection Connection() {
		Connection connection;
		
		try {
			connection = (Connection) DriverManager
			        .getConnection(
			            "jdbc\\:mysql\\://localhost\\:3306/apindb?autoReconnect\\=true&sessionVariables\\=default_storage_engine%3DInnoDB&useUnicode\\=true&characterEncoding\\=UTF-8",
			            "root", "P@ssw0rd");
			return connection;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
