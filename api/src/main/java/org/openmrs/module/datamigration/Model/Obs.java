package org.openmrs.module.datamigration.Model;

import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.annotate.*;

@JsonPropertyOrder({ "conceptId", "valueTypeId", "value" })
public class Obs {
	
	@JsonProperty("conceptId")
	private String conceptId;
	
	@JsonProperty("valueTypeId")
	private String valueTypeId;
	
	@JsonProperty("value")
	private String value;
	
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	
	/**
	 * No args constructor for use in serialization
	 */
	public Obs() {
	}
	
	/**
	 * @param valueTypeId
	 * @param conceptId
	 * @param value
	 */
	public Obs(String conceptId, String valueTypeId, String value) {
		super();
		this.conceptId = conceptId;
		this.valueTypeId = valueTypeId;
		this.value = value;
	}
	
	@JsonProperty("conceptId")
	public String getConceptId() {
		return conceptId;
	}
	
	@JsonProperty("conceptId")
	public void setConceptId(String conceptId) {
		this.conceptId = conceptId;
	}
	
	@JsonProperty("valueTypeId")
	public String getValueTypeId() {
		return valueTypeId;
	}
	
	@JsonProperty("valueTypeId")
	public void setValueTypeId(String valueTypeId) {
		this.valueTypeId = valueTypeId;
	}
	
	@JsonProperty("value")
	public String getValue() {
		return value;
	}
	
	@JsonProperty("value")
	public void setValue(String value) {
		this.value = value;
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
