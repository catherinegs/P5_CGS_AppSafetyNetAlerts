package com.safetynet.alertsapp.repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.json.simple.JSONArray;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.DeserializationFeature;
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
       List<Map<String, Object>> resultMap  =  (List<Map<String, Object>>) objectMapper.readValue(new ClassPathResource("data.json").getFile() , List.class);
        

        System.out.println(resultMap);
        
    }    
    
	public ReadDataJson() throws StreamReadException, DatabindException, IOException {
		
		
		readDataFromFile();

	}
	
	public static void readPersonsFromFile () throws StreamReadException, DatabindException, IOException {
        objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		Map<String, ?> resultMap  = objectMapper.readValue(new ClassPathResource("data.json").getFile() , new TypeReference<Map<String, List>>() {});

        List<Object>personMap = (List<Object>) resultMap.get("persons");
                
 
		
        for (Object person :  personMap){
        	
      	   int i=0;
      	  
        	Persons person1 = new Persons();
        	Address address1 = new Address();
            person1.setFirstName(personMap.get(i).toString());
            
            /**
        	person1.setLastName(personMap.get("lastName"));
        	person1.setPhone(personMap.get("phone"));
        	person1.setEmail(personMap.get("email"));
        	
        	address1.setAddress(personMap.get("address"));
      	address1.setZip(personMap.get("zip"));
      	address1.setCity(personMap.get("city"));
      	
          person1.setAddress(address1);
          **/

        

          

        
             
        }



	}      
                 
       
	



}
