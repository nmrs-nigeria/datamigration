package org.openmrs.module.datamigration.util.Model;

import org.codehaus.jackson.annotate.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonPropertyOrder({ "demographics", "encounters" })
public class Example {
	
	@JsonProperty("demographics")
	private Demographics demographics;
	
	@JsonProperty("encounters")
	private List<Encounter> encounters = null;
	
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	
	/**
	 * No args constructor for use in serialization
	 */
	public Example() {
	}
	
	/**
	 * @param demographics
	 * @param encounters
	 */
	public Example(Demographics demographics, List<Encounter> encounters) {
		super();
		this.demographics = demographics;
		this.encounters = encounters;
	}
	
	@JsonProperty("demographics")
	public Demographics getDemographics() {
		return demographics;
	}
	
	@JsonProperty("demographics")
	public void setDemographics(Demographics demographics) {
		this.demographics = demographics;
	}
	
	@JsonProperty("encounters")
	public List<Encounter> getEncounters() {
		return encounters;
	}
	
	@JsonProperty("encounters")
	public void setEncounters(List<Encounter> encounters) {
		this.encounters = encounters;
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
