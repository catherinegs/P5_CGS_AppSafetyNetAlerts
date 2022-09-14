package com.safetynet.alertsapp.model;

import lombok.Data;

@Data
public class Persons {
	
	
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
    private Address address;
    private MedicalRecords medicalRecords;
    
	

}
