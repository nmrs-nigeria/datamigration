package org.openmrs.module.datamigration.util.Model;

import org.openmrs.BaseOpenmrsMetadata;

import java.util.Set;

public class Obs extends BaseOpenmrsMetadata {
	
	Integer conceptId;
	
	String valueTypeId;
	
	String value;
	
	Boolean isGroup;
	
	Set<ObsChildren> ObsChildren;
	
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
	
	public Boolean getGroup() {
		return isGroup;
	}
	
	public void setGroup(Boolean group) {
		isGroup = group;
	}
	
	public Set<org.openmrs.module.datamigration.util.Model.ObsChildren> getObsChildren() {
		return ObsChildren;
	}
	
	public void setObsChildren(Set<org.openmrs.module.datamigration.util.Model.ObsChildren> obsChildren) {
		ObsChildren = obsChildren;
	}
	
	@Override
	public Integer getId() {
		return null;
	}
	
	@Override
	public void setId(Integer integer) {
		
	}
}
