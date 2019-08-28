/**
 * This Source Code Form is subject to the terms of the Mozilla Public License,
 * v. 2.0. If a copy of the MPL was not distributed with this file, You can
 * obtain one at http://mozilla.org/MPL/2.0/. OpenMRS is also distributed under
 * the terms of the Healthcare Disclaimer located at http://openmrs.org/license.
 *
 * Copyright (C) OpenMRS Inc. OpenMRS is a registered trademark and the OpenMRS
 * graphic logo is a trademark of OpenMRS Inc.
 */
package org.openmrs.module.datamigration.fragment.controller;

import org.openmrs.api.UserService;
import org.openmrs.ui.framework.annotation.SpringBean;
import org.openmrs.ui.framework.fragment.FragmentModel;

/**
 *  * Controller for a fragment that shows all users  
 */
public class UsersFragmentController {
	
	public void controller(FragmentModel model, @SpringBean("userService") UserService service) {
		
		/*DbConnection connection = new DbConnection();
		
		FactoryUtils factoryUtils = new FactoryUtils();
		
		Properties props = new Properties();
		props = OpenmrsUtil.getRuntimeProperties("openmrs");
		if (props == null) {
			props = OpenmrsUtil.getRuntimeProperties("openmrs-standalone");
			
		}
		
		factoryUtils.PatientUtils(connection.Connection(props));
		*/
		model.addAttribute("users", service.getAllUsers());
	}
	
}
