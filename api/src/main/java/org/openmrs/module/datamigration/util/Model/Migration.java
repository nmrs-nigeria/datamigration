package org.openmrs.module.datamigration.util.Model;

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
	
	private String lastName;
	
	private String creator;
	
	private String dateCreated;
	
	private String birthDate;
	
	private String birthdateEstimated;
	
	private String dead;
	
	private String deathDate;
	
	private String causeOfDeath;
	
	private String gender;
	
	private String familyName;
	
	private Facility facility;
	
	private Address address;
	
	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public String getFamilyName() {
		return familyName;
	}
	
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	
	public String getGender() {
		return gender;
	}
	
	public void setGender(String gender) {
		this.gender = gender;
	}
	
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
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getBirthDate() {
		return birthDate;
	}
	
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	
	public String getBirthdateEstimated() {
		return birthdateEstimated;
	}
	
	public void setBirthdateEstimated(String birthdateEstimated) {
		this.birthdateEstimated = birthdateEstimated;
	}
	
	public String getDead() {
		return dead;
	}
	
	public void setDead(String dead) {
		this.dead = dead;
	}
	
	public String getDeathDate() {
		return deathDate;
	}
	
	public void setDeathDate(String deathDate) {
		this.deathDate = deathDate;
	}
	
	public String getCauseOfDeath() {
		return causeOfDeath;
	}
	
	public void setCauseOfDeath(String causeOfDeath) {
		this.causeOfDeath = causeOfDeath;
	}
	
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
