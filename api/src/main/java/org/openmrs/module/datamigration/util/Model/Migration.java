package org.openmrs.module.datamigration.util.Model;

import org.codehaus.jackson.annotate.JsonProperty;
import org.openmrs.BaseOpenmrsMetadata;

import java.util.Date;

public class Migration extends BaseOpenmrsMetadata {
	
	private String preferred;
	
	private String prefix;
	
	private String hospitalNo;
	
	public String getHospitalNo() {
		return hospitalNo;
	}
	
	public void setHospitalNo(String hospitalNo) {
		this.hospitalNo = hospitalNo;
	}
	
	private String givenName;
	
	private String middleName;
	
	private String familyNamePrefix;
	
	private Facility facility;
	
	public String getFamily_name2() {
		return family_name2;
	}
	
	public void setFamily_name2(String family_name2) {
		this.family_name2 = family_name2;
	}
	
	private String familyName;
	
	private String family_name2;
	
	public String getPreferred() {
		return preferred;
	}
	
	public void setPreferred(String preferred) {
		this.preferred = preferred;
	}
	
	public String getPrefix() {
		return prefix;
	}
	
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	
	public String getGivenName() {
		return givenName;
	}
	
	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}
	
	public String getMiddleName() {
		return middleName;
	}
	
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	
	public String getFamilyNamePrefix() {
		return familyNamePrefix;
	}
	
	public void setFamilyNamePrefix(String familyNamePrefix) {
		this.familyNamePrefix = familyNamePrefix;
	}
	
	public String getFamilyName() {
		return familyName;
	}
	
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	
	public String getFamilyName2() {
		return familyName2;
	}
	
	public void setFamilyName2(String familyName2) {
		this.familyName2 = familyName2;
	}
	
	public String getFamilyNameSuffix() {
		return familyNameSuffix;
	}
	
	public void setFamilyNameSuffix(String familyNameSuffix) {
		this.familyNameSuffix = familyNameSuffix;
	}
	
	private String familyName2;
	
	private String familyNameSuffix;
	
	public Facility getFacility() {
		return facility;
	}
	
	public void setFacility(Facility facility) {
		this.facility = facility;
	}
	
	@Override
	public Integer getId() {
		return null;
	}
	
	@Override
	public void setId(Integer integer) {
		
	}
}
