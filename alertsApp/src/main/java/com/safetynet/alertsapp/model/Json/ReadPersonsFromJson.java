package com.safetynet.alertsapp.model.Json;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.safetynet.alertsapp.model.Address;
import com.safetynet.alertsapp.model.MedicalRecords;
import com.safetynet.alertsapp.model.Persons;

@Component
@Order(2)
public class ReadPersonsFromJson {
	
	
	//create ObjectMapper instance
    private static ObjectMapper objectMapper = new ObjectMapper();
    

	@Autowired
    private ReadMedRecordsFromJson readMed;
	   
	private List<Persons> personList = new ArrayList<Persons>();
	
    public List<Persons> getPersonList() {
		return personList;
	}


	public void setPersonList(List<Persons> personList) {
		this.personList = personList;
	}

   /***
	// read data from json file
	public ReadPersonsFromJson() throws StreamReadException, DatabindException, IOException {

		readPersonsFromFile();

	}
**/
    
    // read persons from json file
	@PostConstruct
	@SuppressWarnings("unchecked")
	public void readPersonsFromFile() throws StreamReadException, DatabindException, IOException {

		objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		Map<String, ?> resultMap = objectMapper.readValue(new ClassPathResource("data.json").getFile(),
				new TypeReference<Map<String, List>>() {
				});

		List<Object> pers = (List<Object>) resultMap.get("persons");

		Map<String, String> personsMap = new HashMap<>();
		
		List<MedicalRecords> medList = readMed.getMedRecList();
		System.out.println(medList);

	
        // create list of objects Persons 
		for (int i = 0; i <= pers.size() - 1; i++) {			
			personsMap = (Map<String, String>) pers.get(i);
			System.out.println(personsMap);
			
			Persons person = new Persons();
			Address address = new Address();

		
		    //create new object Persons
			person.setFirstName(personsMap.get("firstName"));
			person.setLastName(personsMap.get("lastName"));
			person.setPhone(personsMap.get("phone"));
			person.setEmail(personsMap.get("email"));
			address.setAddress(personsMap.get("address"));
			address.setZip(personsMap.get("zip"));
			address.setCity(personsMap.get("city"));
			person.setAddress(address);
						
			MedicalRecords medicalRecords = readMed.get();
						
			person.setMedicalRecords(medicalRecords);
		    	
			
			
							
			System.out.println(person);
			personList.add(person);

		}
				
		
	}
	






}
