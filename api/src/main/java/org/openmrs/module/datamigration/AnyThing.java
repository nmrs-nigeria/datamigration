package org.openmrs.module.datamigration;

import org.codehaus.jackson.annotate.JsonAnyGetter;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonProperty;
import org.openmrs.BaseOpenmrsMetadata;
import org.openmrs.Encounter;
import org.openmrs.module.datamigration.Model.Demographics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnyThing extends BaseOpenmrsMetadata {
	
	//@JsonProperty("demographics")
	private Demographics demographics;
	
	//@JsonProperty("encounters")
	private List<Encounter> encounters = null;
	
	public Demographics getDemographics() {
		return demographics;
	}
	
	public void setDemographics(Demographics demographics) {
		this.demographics = demographics;
	}
	
	public List<Encounter> getEncounters() {
		return encounters;
	}
	
	public void setEncounters(List<Encounter> encounters) {
		this.encounters = encounters;
	}
	
	@Override
	public Integer getId() {
		return null;
	}
	
	@Override
	public void setId(Integer integer) {
		
	}
}
