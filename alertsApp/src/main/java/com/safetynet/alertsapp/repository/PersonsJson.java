package com.safetynet.alertsapp.repository;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.safetynet.alertsapp.model.Persons;

public class PersonsJson {
	
	

    //create ObjectMapper instance
    ObjectMapper objectMapper = new ObjectMapper();

    //read json file and convert to person object
    //Persons person = objectMapper.readValue("{\"firstName\": \"John\"}", Persons.class);


}
