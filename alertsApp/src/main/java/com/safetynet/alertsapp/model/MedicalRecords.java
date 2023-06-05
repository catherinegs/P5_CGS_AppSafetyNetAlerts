package com.safetynet.alertsapp.model;

import java.util.Date;
import java.util.List;
import java.util.stream.IntStream;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;



public class MedicalRecords {
	
	private Persons person;
	
	private String birthdate;
	
	private List<String> medications;
	
	private List<String> allergies;
	
	
	public Persons getPerson() {
		return person;
	}

	public void setPerson(Persons person) {
		this.person = person;
	}
	
	public String getBirthdate() {
		return birthdate;
	}


	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}


	public List<String> getMedications() {
		return medications;
	}


	public void setMedications(List<String> medications) {
		this.medications = medications;
	}


	public List<String> getAllergies() {
		return allergies;
	}


	public void setAllergies(List<String> allergies) {
		this.allergies = allergies;
	}


	public MedicalRecords() {
		

	}


	public MedicalRecords(String birthdate, List<String> medications, List<String> allergies, Persons person) {
		this.birthdate = birthdate;
		this.medications = medications;
		this.allergies = allergies;
		this.person = person;
	}


	public MedicalRecords MedicalRecords() {
		return MedicalRecords();
	}
	
	

}
