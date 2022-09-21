package com.safetynet.alertsapp.model;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class MedicalRecords {
	
	private Date birthdate;
	private List<String> medications;
	private List<String> allergies;
	
	@Override
	public String toString() {
		return "MedicalRecords [birthdate=" + birthdate + ", medications=" + medications + ", allergies=" + allergies
				+ "]";
	}
	
	

}
