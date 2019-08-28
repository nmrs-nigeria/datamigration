package org.openmrs.module.datamigration;

import org.openmrs.BaseOpenmrsMetadata;

public abstract class AnyThing extends BaseOpenmrsMetadata {
	
	private String jsonm;
	
	public String getJsonm() {
		return jsonm;
	}
	
	public void setJsonm(String jsonm) {
		this.jsonm = jsonm;
	}
}
