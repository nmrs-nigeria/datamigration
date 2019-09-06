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
import org.openmrs.module.datamigration.util.FactoryUtils;
import org.openmrs.module.datamigration.util.Model.SummaryDashboard;
import org.openmrs.ui.framework.annotation.SpringBean;
import org.openmrs.ui.framework.fragment.FragmentModel;

import java.util.HashMap;
import java.util.Map;

/**
 *  * Controller for a fragment that shows all users  
 */
public class UsersFragmentController {

	public void controller(FragmentModel model, @SpringBean("userService") UserService service) {

		FactoryUtils factoryUtils = new FactoryUtils();

		SummaryDashboard dashboard = new SummaryDashboard();

		dashboard.setTotalPatientsInFac(factoryUtils.getPatients().size());
		dashboard.setTotalPharmacyEncounter(factoryUtils.getEncounterByEncounterTypeId(12).size());
		dashboard.setTotalCareCardEncounter(factoryUtils.getEncounterByEncounterTypeId(11).size());
		dashboard.setTottalLaboratoryEncounter(factoryUtils.getEncounterByEncounterTypeId(13).size());


		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("totalPatients", dashboard.getTotalPatientsInFac());
		map.put("totalPharmacyEncounter", dashboard.getTotalPharmacyEncounter());
		map.put("totallLaboratoryEncounter", dashboard.getTotalCareCardEncounter());
		map.put("totalCareCardEncounter", dashboard.getTotalCareCardEncounter());
		model.mergeAttributes(map);

	}
	
}
