package org.openmrs.module.datamigration.util;

import org.openmrs.Encounter;
import org.openmrs.Location;
import org.openmrs.Obs;
import org.openmrs.Patient;
import org.openmrs.api.context.Context;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.openmrs.module.datamigration.util.Operations.isNullOrEmpty;

public abstract class ObsUtil {
	
	public static Obs InsertObs(org.openmrs.module.datamigration.util.Model.Obs _o, Encounter encounter, Location location,
	        Patient patient) {
		try {
			Obs obs = new Obs();
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
			String obsValueType = _o.getValueTypeId();
			String obsValue = isNullOrEmpty(_o.getValue()) ? _o.getValue() : null;
			
			switch (obsValueType) {
				case "value_numeric":
					
					obs.setValueNumeric(Double.parseDouble(obsValue));
					break;
				case "value_coded":
					obs.setValueCoded(Context.getConceptService().getConcept(obsValue));
					break;
				case "value_datetime":
					Date dateVlue = dateFormat.parse(obsValue);
					obs.setValueDatetime(dateVlue);
					break;
				case "value_text":
					obs.setValueText(obsValue);
					break;
				default:
					obs.setValueText("");
					break;
			}
			obs.setConcept(Context.getConceptService().getConcept(_o.getConceptId()));
			obs.setComment("");
			obs.setEncounter(encounter);
			obs.setObsDatetime(encounter.getEncounterDatetime());
			obs.setLocation(location);
			obs.setPerson(patient);
			return obs;
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
