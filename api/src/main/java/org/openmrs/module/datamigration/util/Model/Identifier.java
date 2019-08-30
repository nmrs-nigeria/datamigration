package org.openmrs.module.datamigration.util.Model;

import org.codehaus.jackson.annotate.*;

import java.util.HashMap;
import java.util.Map;

@JsonPropertyOrder({ "identifier", "identifierType", "locationId", "preferred" })
public class Identifier {
	
	@JsonProperty("identifier")
	private String identifier;
	
	@JsonProperty("identifierType")
	private String identifierType;
	
	@JsonProperty("locationId")
	private String locationId;
	
	@JsonProperty("preferred")
	private String preferred;
	
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	
	/**
	 * No args constructor for use in serialization
	 */
	public Identifier() {
	}
	
	/**
	 * @param locationId
	 * @param preferred
	 * @param identifierType
	 * @param identifier
	 */
	public Identifier(String identifier, String identifierType, String locationId, String preferred) {
		super();
		this.identifier = identifier;
		this.identifierType = identifierType;
		this.locationId = locationId;
		this.preferred = preferred;
	}
	
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
	
	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}
	
	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}
	
}
