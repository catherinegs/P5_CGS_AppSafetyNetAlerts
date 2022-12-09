package com.safetynet.alertsapp.repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
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
        Map<String, List <Map<String, String>>> resultMap  = objectMapper.readValue(new ClassPathResource("data.json").getFile() , Map.class);
        List<Map<String, String>> persons = resultMap.get("persons");

          for (Map<String, String> person :  persons ){
        		        	 
        	  
          	Persons person1 = new Persons();
          	Address address1 = new Address();

          	person1.setFirstName(person.get("firstName"));
          	person1.setLastName(person.get("lastName"));
          	person1.setPhone(person.get("phone"));
          	person1.setEmail(person.get("email"));
          	
          	address1.setAddress(person.get("address"));
        	address1.setZip(person.get("zip"));
        	address1.setCity(person.get("city"));
        	
            person1.setAddress(address1);
            

          }
          
        List<Map<String, String>> medicalRecords = resultMap.get("medicalrecords");
        
          for (Map<String, String> medicalRecord :  medicalRecords ){
           MedicalRecords medRec1 = new MedicalRecords();
           medRec1.setBirthdate(Date(medicalRecord.get("birthday")));
       
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
        Map<String, List <Map<String, String>>> resultMap  = objectMapper.readValue(new ClassPathResource("data.json").getFile() , Map.class);
        List<Map<String, String>> fireStations = resultMap.get("firestations");
        
        for (Map<String, String> fireStation :  fireStations ){
        	
        	Firestations fireStation1 = new Firestations();
        	
        	//fireStation1.setStation(fireStation.get("fireStation"));
        	
        	
        }
       
        


		
	}

	
	



}
