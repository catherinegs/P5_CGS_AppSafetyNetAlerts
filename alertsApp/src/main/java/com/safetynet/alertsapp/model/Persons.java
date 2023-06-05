package com.safetynet.alertsapp.model;

import java.util.Date;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.safetynet.alertsapp.model.Json.ReadMedRecordsFromJson;




public class Persons {
	
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	
    private Address address;

	private MedicalRecords medicalRecords;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public MedicalRecords getMedicalRecords() {
		return medicalRecords;
	}

	public void setMedicalRecords(MedicalRecords medicalRecords) {
		this.medicalRecords = medicalRecords;
	}

	public Persons(String firstName, String lastName, String email, String phone, Address address,
			MedicalRecords medicalRecords) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.medicalRecords = medicalRecords;
	}

	public Persons() {
		super();
	}

	public Persons toPerson() {
		return new Persons();
	}

	
  

}
