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
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.type.MapType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.safetynet.alertsapp.model.Address;
import com.safetynet.alertsapp.model.MedicalRecords;
import com.safetynet.alertsapp.model.Persons;
import com.safetynet.alertsapp.model.Json.ReadDataJson;
import com.safetynet.alertsapp.model.Json.ReadMedRecordsFromJson;
import com.safetynet.alertsapp.model.Json.ReadPersonsFromJson;
import com.safetynet.alertsapp.service.PersonsService;

@Repository
public class PersonsRepository {
	
	@Autowired
	private ReadPersonsFromJson readPersons;
	
	private ReadMedRecordsFromJson readMed;
	
	//create ObjectMapper instance
    private static ObjectMapper objectMapper = new ObjectMapper();

	public List<Persons> getAllPersons() throws StreamReadException, DatabindException, IOException {

	 
        return readPersons.getPersonList(); 
        
	}    


	@SuppressWarnings("unchecked")
	public Persons getPersonByName(String firstName, String lastName) {
		
        for (int i = 0; i < ((List<Persons>) readPersons).size(); i++) {
            if (((List<Persons>) readPersons).get(i).getFirstName() == (firstName) && ((List<Persons>) readPersons).get(i).getLastName() == (lastName)) {
                return ((List<Persons>) readPersons).get(i);
            }
        }

		return null;
		
		
	}
	
    @SuppressWarnings("unchecked")
	public void deletePerson(String firstName, String lastName) {
    	((List<Persons>) readPersons).removeIf(x -> x.getFirstName() == (firstName) && x.getLastName() == (lastName));
    }
    
    


/**
    public Persons update(Persons person) {
        int idx = 0;
        int id = 0;
        for (int i = 0; i < ((List<Persons>) readPersons).size(); i++) {
            if ((((List<Persons>) readPersons).get(i).getId() == (product.getId()))) {
                id = product.getId();
                idx = i;
                break;
            }
        }

        Persons product1 = new Persons();
        product1.setId(id);
        product1.setName(product.getName());
        product1.setQuantity(product.getQuantity());
        product1.setPrice(product.getPrice());
        list.set(idx, product);
        return product1;
    }

**/

		  
    public Persons save(Persons p) {
    	Persons person = new Persons();
    	person.setFirstName(p.getFirstName());
    	person.setLastName(p.getLastName());
    	person.setEmail(p.getEmail());
    	person.setPhone(p.getPhone());
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
   
        return medRec;
    	
    	
    }



    
    

	
	
}
