package org.openmrs.module.datamigration.util.Model;

import org.openmrs.BaseOpenmrsMetadata;

import java.util.LinkedHashSet;
import java.util.Set;

public class Obs extends BaseOpenmrsMetadata {
	
	Integer conceptId;
	
	String valueTypeId;
	
	String value;

	Boolean isGroup;

	public Boolean getisGroup() {
		return isGroup;
	}

	public void setisGroup(Boolean isGroup) {
		isGroup = isGroup;
	}

	Set<ObsChildren> obsChildren = new LinkedHashSet<>();
	
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

	public Set<ObsChildren> getObsChildren() {
		return obsChildren;
	}

	public void setObsChildren(Set<ObsChildren> obsChildren) {
		this.obsChildren = obsChildren;
	}

	@Override
	public Integer getId() {
		return null;
	}
	
	@Override
	public void setId(Integer integer) {
		
	}
}
