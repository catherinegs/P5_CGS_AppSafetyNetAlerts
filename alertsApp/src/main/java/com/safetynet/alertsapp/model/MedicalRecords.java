package com.safetynet.alertsapp.model;

import java.util.List;

import lombok.Data;

@Data
public class MedicalRecords {
	
	private String birthdate;
	private List<String> medications;
	private List<String> allergies;
	
	

}
