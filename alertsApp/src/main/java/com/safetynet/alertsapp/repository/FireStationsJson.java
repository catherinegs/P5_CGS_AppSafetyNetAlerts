package com.safetynet.alertsapp.repository;

import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.safetynet.alertsapp.model.Firestations;

public class FireStationsJson {
	
	public void jsonFireStationsParse() throws JsonProcessingException {
		
	    //create ObjectMapper instance
	    ObjectMapper objectMapper = new ObjectMapper();

			// Convert JSON string to Object
			String jsonInString =
					
					"[{ \"station\":\"3\"}, \n"+
					" { \"station\":\"2\"}, \n"+ 
					" { \"station\":\"3\"}, \n"+
					" { \"station\":\"1\"}, \n"+
					" { \"station\":\"3\"}, \n"+
					" { \"station\":\"3\"}, \n"+
					" { \"station\":\"4\"}, \n"+
					" { \"station\":\"2\"}, \n"+
					" { \"station\":\"4\"}, \n"+
					"]";
			
			Map<String, Object> firestations  = objectMapper.readValue(jsonInString, new TypeReference<Map<String,Object>>(){});
			System.out.println(firestations);		
							        
					
	}			


}
