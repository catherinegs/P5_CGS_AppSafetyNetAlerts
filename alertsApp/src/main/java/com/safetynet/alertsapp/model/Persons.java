package com.safetynet.alertsapp.model;

import java.util.Date;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Persons {
	
	public String firstName;
	private String lastName;
	private String email;
	private String phone;
	
    private Address address;
    private MedicalRecords medicalRecords;
    
    		

}
