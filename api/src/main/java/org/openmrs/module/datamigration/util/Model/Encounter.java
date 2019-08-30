package org.openmrs.module.datamigration.util.Model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.annotate.*;

@JsonPropertyOrder({ "encounterTypeId", "encounterLocatiionId", "encounterDate", "form" })
public class Encounter {
	
	@JsonProperty("encounterTypeId")
	private String encounterTypeId;
	
	@JsonProperty("encounterLocatiionId")
	private String encounterLocatiionId;
	
	@JsonProperty("encounterDate")
	private String encounterDate;
	
	@JsonProperty("form")
	private List<Form> form = null;
	
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	
	/**
	 * No args constructor for use in serialization
	 */
	public Encounter() {
	}
	
	/**
	 * @param encounterLocatiionId
	 * @param form
	 * @param encounterTypeId
	 * @param encounterDate
	 */
	public Encounter(String encounterTypeId, String encounterLocatiionId, String encounterDate, List<Form> form) {
		super();
		this.encounterTypeId = encounterTypeId;
		this.encounterLocatiionId = encounterLocatiionId;
		this.encounterDate = encounterDate;
		this.form = form;
	}
	
	@JsonProperty("encounterTypeId")
	public String getEncounterTypeId() {
		return encounterTypeId;
	}
	
	@JsonProperty("encounterTypeId")
	public void setEncounterTypeId(String encounterTypeId) {
		this.encounterTypeId = encounterTypeId;
	}
	
	@JsonProperty("encounterLocatiionId")
	public String getEncounterLocatiionId() {
		return encounterLocatiionId;
	}
	
	@JsonProperty("encounterLocatiionId")
	public void setEncounterLocatiionId(String encounterLocatiionId) {
		this.encounterLocatiionId = encounterLocatiionId;
	}
	
	@JsonProperty("encounterDate")
	public String getEncounterDate() {
		return encounterDate;
	}
	
	@JsonProperty("encounterDate")
	public void setEncounterDate(String encounterDate) {
		this.encounterDate = encounterDate;
	}
	
	@JsonProperty("form")
	public List<Form> getForm() {
		return form;
	}
	
	@JsonProperty("form")
	public void setForm(List<Form> form) {
		this.form = form;
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
