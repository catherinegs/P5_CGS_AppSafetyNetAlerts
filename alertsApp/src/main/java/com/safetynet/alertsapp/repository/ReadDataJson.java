package com.safetynet.alertsapp.repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.safetynet.alertsapp.model.Address;
import com.safetynet.alertsapp.model.Firestations;
import com.safetynet.alertsapp.model.MedicalRecords;
import com.safetynet.alertsapp.model.Persons;

@Component
public class ReadDataJson {
	
	//create ObjectMapper instance
    static ObjectMapper objectMapper = new ObjectMapper();
    public void readDataFromFile () throws StreamReadException, DatabindException, IOException {
        Map<String, Object> resultMap  = objectMapper.readValue(new ClassPathResource("data.json").getFile() , Map.class);
        System.out.println(resultMap);
        
    }    
    
	public ReadDataJson() throws StreamReadException, DatabindException, IOException {
		
		
		readPersonsFromFile();

	}
	
	public static void readPersonsFromFile () throws StreamReadException, DatabindException, IOException {
        Map<String, Map<String, String>> resultMap  = objectMapper.readValue(new ClassPathResource("data.json").getFile() , Map.class);
        Map<String, String> persons = new HashMap<>();
        persons = resultMap.get("persons");

          for (String person :  persons.keySet()){
        	  
        		        	 
        	  
          	Persons person1 = new Persons();
          	Address address1 = new Address();

          	person1.setFirstName(persons.get("firstName"));
          	person1.setLastName(persons.get("lastName"));
          	person1.setPhone(persons.get("phone"));
          	person1.setEmail(persons.get("email"));
          	
          	address1.setAddress(persons.get("address"));
        	address1.setZip(persons.get("zip"));
        	address1.setCity(persons.get("city"));
        	
            person1.setAddress(address1);
            

          }
          
        Map<String, String> medicalRecords = resultMap.get("medicalrecords");
        
          for (String medicalRecord :  medicalRecords.keySet() ){
           MedicalRecords medRec1 = new MedicalRecords();
       
          List<String> medications = new ArrayList<>();
         //medications.setMedications(medicalRecord.get("medications"));
          
          }
          
          System.out.println(persons);
                 
       }
	
	
	
	private static Date Date(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public static void readFireStationsFromFile() throws StreamReadException, DatabindException, IOException {
        Map<String, Map<String, String>> resultMap  = objectMapper.readValue(new ClassPathResource("data.json").getFile() , Map.class);
        Map<String, String> fireStations = new HashMap<>();
        fireStations =resultMap.get("firestations");
        
        for (String fireStation :  fireStations.keySet()){
        	
        	Firestations fireStation1 = new Firestations(); 
        	Address address1 = new Address();
        	
        	fireStation1.setStation(fireStations.get("station"));
          	address1.setAddress(fireStations.get("address"));
          	fireStation1.setAddress(address1);


        	
        	
        }
       
        


		
	}

	
	



}
