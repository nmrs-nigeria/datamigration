package org.openmrs.module.datamigration.Utility;

import org.openmrs.module.datamigration.Model.NmrsConnection;
import org.openmrs.util.OpenmrsUtil;

import java.util.Properties;

public class OptionsUtils {
	
	public static NmrsConnection getNmrsConnectionDetails() {
		
		NmrsConnection result = new NmrsConnection();
		
		try {
			
			Properties props = new Properties();
			props = OpenmrsUtil.getRuntimeProperties("openmrs");
			if (props == null) {
				props = OpenmrsUtil.getRuntimeProperties("openmrs-standalone");
				
			}
			
			result.setUsername(props.getProperty("connection.username"));
			result.setPassword(props.getProperty("connection.password"));
			result.setUrl(props.getProperty("connection.url"));
			
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return result;
		
	}
}
