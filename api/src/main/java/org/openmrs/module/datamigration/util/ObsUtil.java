package org.openmrs.module.datamigration.util;

import org.openmrs.*;
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
			Concept concept = Context.getConceptService().getConcept(_o.getConceptId());
			String obsValue = isNullOrEmpty(_o.getValue()) ? _o.getValue() : null;
			
			switch (concept.getDatatype().getConceptDatatypeId()) {
				case 1: //Numeric
					obs.setValueNumeric(Double.parseDouble(obsValue));
					break;
				case 2: //Coded
					obs.setValueCoded(Context.getConceptService().getConcept(obsValue));
					break;
				case 3: //Text
					Date dateVlue = dateFormat.parse(obsValue);
					obs.setValueDatetime(dateVlue);
					break;
				case 4: //N/A
					obs.setValueText(obsValue);
					break;
				case 8: //Datetime
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
