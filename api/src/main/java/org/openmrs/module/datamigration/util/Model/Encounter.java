package org.openmrs.module.datamigration.util.Model;

import org.openmrs.BaseOpenmrsMetadata;

import java.util.*;

public class Encounter extends BaseOpenmrsMetadata {
	
	Integer encounterId;
	
	Integer encounterLocationId;
	
	Date encounterDate;
	
	Integer formTypeId;
	
	Set<Obs> obs;
	
	public Integer getEncounterId() {
		return encounterId;
	}
	
	public void setEncounterId(Integer encounterId) {
		this.encounterId = encounterId;
	}
	
	public Set<Obs> getObs() {
		return obs;
	}
	
	public void setObs(Set<Obs> obs) {
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
