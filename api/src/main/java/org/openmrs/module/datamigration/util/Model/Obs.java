package org.openmrs.module.datamigration.util.Model;

import org.openmrs.BaseOpenmrsMetadata;

public class Obs extends BaseOpenmrsMetadata {
	
	Integer conceptId;
	
	String valueTypeId;
	
	String value;
	
	public Integer getConceptId() {
		return conceptId;
	}
	
	public void setConceptId(Integer conceptId) {
		this.conceptId = conceptId;
	}
	
	public String getValueTypeId() {
		return valueTypeId;
	}
	
	public void setValueTypeId(String valueTypeId) {
		this.valueTypeId = valueTypeId;
	}
	
	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	}
	
	@Override
	public Integer getId() {
		return null;
	}
	
	@Override
	public void setId(Integer integer) {
		
	}
}
