package com.safetynet.alertsapp.model.Dtos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class ReadPersonsFromJson {
	
	
	//create ObjectMapper instance
    private static ObjectMapper objectMapper = new ObjectMapper();
    
	public static List<Persons> personList = new ArrayList<Persons>();
	
	
    // read data from json file
	public ReadPersonsFromJson() throws StreamReadException, DatabindException, IOException {

		readPersonsFromFile();

	}

    
    // read persons from json file
	@SuppressWarnings("unchecked")
	public static void readPersonsFromFile() throws StreamReadException, DatabindException, IOException {

		objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		Map<String, ?> resultMap = objectMapper.readValue(new ClassPathResource("data.json").getFile(),
				new TypeReference<Map<String, List>>() {
				});

		List<Object> pers = (List<Object>) resultMap.get("persons");

		Map<String, String> personsMap = new HashMap<>();
						
        // create list of objects Persons 
		for (int i = 0; i <= pers.size() - 1; i++) {			
			personsMap = (Map<String, String>) pers.get(i);
			System.out.println(personsMap);
			Persons person = new Persons();
			Address address = new Address();
			MedicalRecords medicalRecords = new MedicalRecords();	
			
		
		    //create new object Persons
			person.setFirstName(personsMap.get("firstName"));
			person.setLastName(personsMap.get("lastName"));
			person.setPhone(personsMap.get("phone"));
			person.setEmail(personsMap.get("email"));
			address.setAddress(personsMap.get("address"));
			address.setZip(personsMap.get("zip"));
			address.setCity(personsMap.get("city"));
			person.setAddress(address);
			person.setMedicalRecords(medicalRecords);
			System.out.println(person);
			personList.add(person);

		}

		System.out.println(personList);
		
	}


}
