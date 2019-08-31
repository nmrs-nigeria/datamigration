package org.openmrs.module.datamigration;

import org.openmrs.BaseOpenmrsMetadata;

public class Obs extends BaseOpenmrsMetadata {
	
	Integer conceptId;
	
	String valueTypeId;
	
	Integer value;
	
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
	
	public Integer getValue() {
		return value;
	}
	
	public void setValue(Integer value) {
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
