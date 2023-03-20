package com.safetynet.alertsapp.repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.safetynet.alertsapp.model.Address;
import com.safetynet.alertsapp.model.MedicalRecords;
import com.safetynet.alertsapp.model.Persons;
import com.safetynet.alertsapp.service.PersonsService;

@Repository
public class PersonsRepository {
	
	@Autowired
	private ReadDataJson readDataJson;

	
	//create ObjectMapper instance
    ObjectMapper objectMapper = new ObjectMapper();
    
    //create new object Persons
    
    Persons person = new Persons();
    

	public List<Persons> persons = new ArrayList<>();
	
    
	
	public PersonsRepository() throws StreamReadException, DatabindException, IOException {
				
		ReadDataJson.readPersonsFromFile();
	}
	

	public List<Persons> getAllPersons() {
        	

        return persons;
        
    }
	/**
	public Persons findByBirthdate(String birthdate) {
		
		
	
        for (Persons person : persons) {
            if (Objects.equals(person.getBirthdate(), (birthdate))) {
                return person;
            }
        }
		return null;
		
		
	}
**/

	public void createPersons(Persons p) throws StreamWriteException, DatabindException, IOException {
	
    //create a Person object
    Persons person = new Persons();
    person.setFirstName("Maria");
    person.setLastName("Kovosi");
    person.setEmail("maria@example.com");
    person.setPhone("+12 785 4895 321");
    @SuppressWarnings("deprecation")

    Address address = new Address();
    address.setAddress("Karchstr.");
    address.setCity("Hanover");
    address.setZip("66525");
    person.setAddress(address);

    MedicalRecords medRec = new MedicalRecords();    
    List<String> medications = new ArrayList<>();
    medications.add("PayPal");
    medications.add("SOFORT");
    person.setMedicalRecords(medRec);
    List<String> allergies = new ArrayList<>();
    allergies.add("gender");
    allergies.add("married");
    allergies.add("income");
    person.setMedicalRecords(medRec);
    
    //configure objectMapper for pretty input
    objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
    //write customerObj object to customer2.json file
    objectMapper.writeValue(new File("../../resources/data2.json"), person);	
	
	}
		  
    public Persons save(Persons p) {
    	Persons person = new Persons();
    	person.setFirstName(p.getFirstName());
    	person.setLastName(p.getLastName());
    	person.setEmail(p.getEmail());
    	person.setPhone(p.getPhone());
    	persons.add(person);
        return person;
    }
    
    public Address save(Address addr) {
    	Address address = new Address();
        address.setAddress(addr.getAddress());      
        address.setCity(addr.getCity());
        address.setZip(addr.getZip());   	
    	return address;    	
    }
    
    public MedicalRecords save(MedicalRecords medrec) {
    	
        MedicalRecords medRec = new MedicalRecords();  
        List<String> medications = new ArrayList<>();
   
        return medRec;
    	
    	
    }



    
    

	
	
}
