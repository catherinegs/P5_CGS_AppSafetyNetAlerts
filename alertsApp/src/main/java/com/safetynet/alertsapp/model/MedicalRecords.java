package com.safetynet.alertsapp.model;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class MedicalRecords {
	
	private Date birthdate;
	private List<String> medications;
	private List<String> allergies;
	
	
	

}