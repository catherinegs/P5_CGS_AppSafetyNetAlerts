package com.safetynet.alertsapp.repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.safetynet.alertsapp.model.Address;
import com.safetynet.alertsapp.model.Firestations;
import com.safetynet.alertsapp.model.Json.ReadDataJson;
import com.safetynet.alertsapp.model.Json.ReadFirestationsFromJson;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Repository
public class FirestationsRepository {
	
	@Autowired
	private ReadFirestationsFromJson readFirestations;

	
	//create ObjectMapper instance
    ObjectMapper objectMapper = new ObjectMapper();
    

	public List<Firestations> getAllFirestations() {
		
        return readFirestations.firestationsList;
}
	
	


}



