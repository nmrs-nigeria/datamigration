package org.openmrs.module.datamigration.util.Model;

public class SummaryDashboard {
	
	Integer totalPatientsInFac;
	
	Integer totalPharmacyEncounter;
	
	Integer tottalLaboratoryEncounter;
	
	Integer totalCareCardEncounter;
	
	public Integer getTotalPatientsInFac() {
		return totalPatientsInFac;
	}
	
	public void setTotalPatientsInFac(Integer totalPatientsInFac) {
		this.totalPatientsInFac = totalPatientsInFac;
	}
	
	public Integer getTotalPharmacyEncounter() {
		return totalPharmacyEncounter;
	}
	
	public void setTotalPharmacyEncounter(Integer totalPharmacyEncounter) {
		this.totalPharmacyEncounter = totalPharmacyEncounter;
	}
	
	public Integer getTottalLaboratoryEncounter() {
		return tottalLaboratoryEncounter;
	}
	
	public void setTottalLaboratoryEncounter(Integer tottalLaboratoryEncounter) {
		this.tottalLaboratoryEncounter = tottalLaboratoryEncounter;
	}
	
	public Integer getTotalCareCardEncounter() {
		return totalCareCardEncounter;
	}
	
	public void setTotalCareCardEncounter(Integer totalCareCardEncounter) {
		this.totalCareCardEncounter = totalCareCardEncounter;
	}
}
