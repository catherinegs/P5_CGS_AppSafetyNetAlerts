package com.safetynet.alertsapp.repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.safetynet.alertsapp.model.Address;
import com.safetynet.alertsapp.model.MedicalRecords;
import com.safetynet.alertsapp.model.Persons;

@Repository
public class PersonsRepository {
	
    //create ObjectMapper instance
    ObjectMapper objectMapper = new ObjectMapper();

	private List<Persons> list = new ArrayList<Persons>();


	public void createPersons() throws StreamWriteException, DatabindException, IOException {
	
    //create a Person object
    Persons person = new Persons();
    person.setId(24);
    person.setFirstName("Maria");
    person.setLastName("Kovosi");
    person.setEmail("maria@example.com");
    person.setPhone("+12 785 4895 321");

    Address address = new Address();
    address.setAddress("Karchstr.");
    address.setCity("Hanover");
    address.setZip(66525);
    person.setAddress(address);

    MedicalRecords record = new MedicalRecords();
    
    @SuppressWarnings("deprecation")
	Date birthday = new Date("03/06/1984");
    
    List<String> medicalRecords = new ArrayList<>();
    medicalRecords.add("PayPal");
    medicalRecords.add("SOFORT");
    person.setMedicalRecords(record);

    List<String> allergies = new ArrayList<>();
    allergies.add("gender");
    allergies.add("married");
    allergies.add("income");
    person.setMedicalRecords(record);

    //configure objectMapper for pretty input
    objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);

    //write customerObj object to customer2.json file
    objectMapper.writeValue(new File("../../resources/data2.json"), person);
	
	
	}
		
    public List<Persons> getAllPersons() {
        return list;
    }

	
	
}
