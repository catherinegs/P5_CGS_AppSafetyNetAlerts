package com.safetynet.alertsapp.repository;



import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.safetynet.alertsapp.model.Persons;

public class PersonsJson {
	
	public void jsonPersonParse() throws IOException {
	
	

    //create ObjectMapper instance
    ObjectMapper objectMapper = new ObjectMapper();
    
 		
        //read JSON file and convert to a customer object
	
			
			Persons persons = objectMapper.readValue(new File("../../resources/data.json"), Persons.class);
			System.out.println(persons);

	}

}
