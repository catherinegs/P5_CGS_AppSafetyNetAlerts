package com.safetynet.alertsapp.repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MedicalRecordsJson {
	
	public void jsonMedicalRecords() throws IOException {
		
        //JSON parser object to parse read file


    //create ObjectMapper instance
    ObjectMapper objectMapper = new ObjectMapper();
    
	// Convert JSON string to Object
	String jsonMedic =
			"[{ \"medications\":[\"aznol:350mg\", \"hydrapermazol:100mg\"]},\n"
			+ "{ \"medications\":[\"pharmacol:5000mg\", \"terazine:10mg\", \"noznazol:250mg\"]},\n"
			+ "{ \"medications\":[], \"allergies\":[\"peanut\"] },\n"
			+ "{  \"medications\":[]},\n"
			+ "{ \"medications\":[\"tetracyclaz:650mg\"]},\n"
			+ "{  \"medications\":[]},\n"
			+ "{  \"medications\":[]},\n"
			+ "{  \"medications\":[]},\n"
			+ "{ \"medications\":[]},\n"
			+ "{ \"medications\":[\"hydrapermazol:300mg\", \"dodoxadin:30mg\"] },\n"
			+ "{  \"medications\":[]},\n"
			+ "{ \"medications\":[\"aznol:60mg\", \"hydrapermazol:900mg\", \"pharmacol:5000mg\", \"terazine:500mg\"]},\n"
			+ "{ \"medications\":[] },\n"
			+ "{ \"medications\":[] },\n"
			+ "{ \"medications\":[\"thradox:700mg\"] },\n"
			+ "{ \"medications\":[]},\n"
			+ "{ \"medications\":[]},\n"
			+ "{ \"medications\":[\"aznol:200mg\"]},\n"
			+ "{ \"medications\":[\"ibupurin:200mg\", \"hydrapermazol:400mg\"]},\n"
			+ "{ \"medications\":[]},\n"
			+ "{  \"medications\":[\"noxidian:100mg\", \"pharmacol:2500mg\"]},\n"
			+ "{ \"medications\":[]},\n"
			+ "{ \"medications\":[\"tradoxidine:400mg\"]}\n"
			+ "]";
	
	   List<Map<String, Object>> medications = new ArrayList<Map<String, Object>>(); 
	   Map<String, Object> medicationsMap  = objectMapper.readValue(jsonMedic, new TypeReference<Map<String,Object>>(){});
	    
		
			System.out.println(medicationsMap);
			medications.add(medicationsMap);
			
	        //read JSON file and convert to a customer object
	
	String jsonAller =
			"[{  \"allergies\":[\"nillacilan\"] },\n"
			+ "{ \"allergies\":[] },\n"
			+ "{ \"allergies\":[\"peanut\"] },\n"
			+ "{ \"allergies\":[] },\n"
			+ "{ \"allergies\":[\"xilliathal\"] },\n"
			+ "{ \"allergies\":[] },\n"
			+ "{ \"allergies\":[] },\n"
			+ "{ \"allergies\":[\"shellfish\"] },\n"
			+ "{ \"allergies\":[] },\n"
			+ "{ \"allergies\":[\"shellfish\"] },\n"
			+ "{ \"allergies\":[] },\n"
			+ "{ \"allergies\":[\"peanut\", \"shellfish\", \"aznol\"] },\n"
			+ "{ \"allergies\":[] },\n"
			+ "{ \"allergies\":[] },\n"
			+ "{ \"allergies\":[\"illisoxian\"] },\n"
			+ "{ \"allergies\":[] },\n"
			+ "{ \"allergies\":[] },\n"
			+ "{ \"allergies\":[\"nillacilan\"] },\n"
			+ "{ \"allergies\":[\"nillacilan\"] },\n"
			+ "{ \"allergies\":[] },\n"
			+ "{ \"allergies\":[] },\n"
			+ "{\"allergies\":[] },\n"
			+ "{ \"allergies\":[] }\n"
			+ "]";  
	
	   List<Map<String, Object>> allergies = new ArrayList<Map<String, Object>>(); 
	   Map<String, Object> allergiesMap  = objectMapper.readValue(jsonMedic, new TypeReference<Map<String,Object>>(){});
	    
	        //read JSON file and convert to a customer object
		
			System.out.println(allergiesMap);
			allergies.add(allergiesMap);


 
	}


}
