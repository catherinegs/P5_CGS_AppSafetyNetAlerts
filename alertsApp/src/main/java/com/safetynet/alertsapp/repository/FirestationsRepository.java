package com.safetynet.alertsapp.repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.safetynet.alertsapp.model.Firestations;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class FirestationsRepository {
	
	@Autowired
	private ReadDataJson readDataJson;

	
	//create ObjectMapper instance
    ObjectMapper objectMapper = new ObjectMapper();
    
	public List<Firestations> fireStations = new ArrayList<>();

	public FirestationsRepository() throws StreamReadException, DatabindException, IOException {
		
		    readDataJson.readFireStationsFromFile();
	}
	

	public List<Firestations> getAllFirestations() {
		
        return fireStations;
}
	
	


}



