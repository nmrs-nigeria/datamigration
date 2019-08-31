package org.openmrs.module.datamigration.util.Model;

import org.codehaus.jackson.annotate.*;
import org.openmrs.BaseOpenmrsMetadata;

import java.util.HashMap;
import java.util.Map;

@JsonPropertyOrder({ "identifier", "identifierType", "locationId", "preferred" })
public class Identifier extends BaseOpenmrsMetadata {
	
	@JsonProperty("identifier")
	private String identifier;
	
	@JsonProperty("identifierType")
	private String identifierType;
	
	@JsonProperty("locationId")
	private String locationId;
	
	@JsonProperty("preferred")
	private String preferred;
	
	@JsonProperty("identifier")
	public String getIdentifier() {
		return identifier;
	}
	
	@JsonProperty("identifier")
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	
	@JsonProperty("identifierType")
	public String getIdentifierType() {
		return identifierType;
	}
	
	@JsonProperty("identifierType")
	public void setIdentifierType(String identifierType) {
		this.identifierType = identifierType;
	}
	
	@JsonProperty("locationId")
	public String getLocationId() {
		return locationId;
	}
	
	@JsonProperty("locationId")
	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}
	
	@JsonProperty("preferred")
	public String getPreferred() {
		return preferred;
	}
	
	@JsonProperty("preferred")
	public void setPreferred(String preferred) {
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
