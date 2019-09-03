package org.openmrs.module.datamigration.util.Model;

import org.openmrs.BaseOpenmrsMetadata;

import java.util.*;

public class Encounter extends BaseOpenmrsMetadata {
	
	Integer encounterId;
	
	Integer encounterLocationId;
	
	String encounterDate;
	
	Integer formTypeId;
	
	Set<ObsChildren> obs = new LinkedHashSet<>();

	private Provider provider;

	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}
	
	public Integer getEncounterId() {
		return encounterId;
	}
	
	public void setEncounterId(Integer encounterId) {
		this.encounterId = encounterId;
	}

	public Set<ObsChildren> getObs() {
		return obs;
	}

	public void setObs(Set<ObsChildren> obs) {
		this.obs = obs;
	}

	public Integer getEncounterLocationId() {
		
		return encounterLocationId;
	}
	
	public void setEncounterLocationId(Integer encounterLocationId) {
		this.encounterLocationId = encounterLocationId;
	}

	public String getEncounterDate() {
		return encounterDate;
	}

	public void setEncounterDate(String encounterDate) {
		this.encounterDate = encounterDate;
	}

	public Integer getFormTypeId() {
		return formTypeId;
	}
	
	public void setFormTypeId(Integer formTypeId) {
		this.formTypeId = formTypeId;
	}
	
	@Override
	public Integer getId() {
		return null;
	}
	
	@Override
	public void setId(Integer integer) {
		
	}
}
