package org.openmrs.module.datamigration;

import org.openmrs.BaseOpenmrsMetadata;

public class Identifiers extends BaseOpenmrsMetadata {
	
	String identifier;
	
	Integer identifierType;
	
	Integer locationId;
	
	Boolean preferred;
	
	public Integer getIdentifierType() {
		return identifierType;
	}
	
	public void setIdentifierType(Integer identifierType) {
		this.identifierType = identifierType;
	}
	
	public String getIdentifier() {
		return identifier;
		
	}
	
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	
	public Integer getLocationId() {
		return locationId;
	}
	
	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}
	
	public Boolean getPreferred() {
		return preferred;
	}
	
	public void setPreferred(Boolean preferred) {
		this.preferred = preferred;
	}
	
	@Override
	public Integer getId() {
		return null;
	}
	
	@Override
	public void setId(Integer integer) {
		
	}
}
