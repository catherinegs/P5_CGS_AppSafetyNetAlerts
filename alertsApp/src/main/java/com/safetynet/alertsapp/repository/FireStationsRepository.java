package com.safetynet.alertsapp.repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.safetynet.alertsapp.model.Address;
import com.safetynet.alertsapp.model.Firestations;
import com.safetynet.alertsapp.model.Persons;

@Repository
public class FireStationsRepository {
	
	@Autowired
	private ReadDataJson readDataJson;

	
	//create ObjectMapper instance
    ObjectMapper objectMapper = new ObjectMapper();
    
	public List<Firestations> fireStations = new ArrayList<>();

	public FireStationsRepository() throws StreamReadException, DatabindException, IOException {
		
		    readDataJson.readPersonsFromFile();
	}
	

	public List<Firestations> getAllFirestations() {
		
        return fireStations;
}
	
	


}
