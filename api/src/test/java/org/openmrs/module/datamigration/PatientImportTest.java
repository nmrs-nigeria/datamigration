/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.datamigration;

import java.util.Properties;

import org.junit.Test;
import org.openmrs.module.datamigration.api.dao.DbConnection;
import org.openmrs.module.datamigration.util.FactoryUtils;
import org.openmrs.test.BaseModuleContextSensitiveTest;

public class PatientImportTest extends BaseModuleContextSensitiveTest {
	
	@Test
	public void shouldImportPatients() {
		
		Properties runtimeProperties = new Properties();
		runtimeProperties.setProperty("connection.username", "sa");
		runtimeProperties.setProperty("connection.password", "");
		runtimeProperties.setProperty("connection.url", "");
		
		DbConnection connection = new DbConnection();
		
		FactoryUtils factoryUtils = new FactoryUtils();
		factoryUtils.PatientUtils(connection.Connection(runtimeProperties));
	}
}
