package org.openmrs.module.datamigration.util.Model;

import org.openmrs.BaseOpenmrsMetadata;

import java.util.*;

public class mEncounter extends BaseOpenmrsMetadata {
	
	Integer encounterId;
	
	Integer encounterLocationId;
	
	Date encounterDate;
	
	Integer formTypeId;
	
	Set<mObs> obs;
	
	public Integer getEncounterId() {
		return encounterId;
	}
	
	public void setEncounterId(Integer encounterId) {
		this.encounterId = encounterId;
	}
	
	public Set<mObs> getObs() {
		return obs;
	}
	
	public void setObs(Set<mObs> obs) {
		this.obs = obs;
	}
	
	public Integer getEncounterLocationId() {
		
		return encounterLocationId;
	}
	
	public void setEncounterLocationId(Integer encounterLocationId) {
		this.encounterLocationId = encounterLocationId;
	}
	
	public Date getEncounterDate() {
		return encounterDate;
	}
	
	public void setEncounterDate(Date encounterDate) {
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
