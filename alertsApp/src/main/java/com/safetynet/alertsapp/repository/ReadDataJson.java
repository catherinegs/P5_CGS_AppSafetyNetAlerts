package com.safetynet.alertsapp.repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
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

        List<Object>pers = (List<Object>) resultMap.get("persons");
        

        Map <String, String> personsMap = new HashMap<>();
   
	
       
      
      	  for (int i=0; i<=pers.size()-1; i++) {
      	   
      	    personsMap = (Map<String, String>) pers.get(i);
      	    
            System.out.println(personsMap);
            
     	   
        	Persons person1 = new Persons();
        	Address address1 = new Address();
        	
        	/**
        	
        	//person1.setFirstName(persons.get(i).thisFirstName);
        	person1.setLastName(persons.get(i).toString());
        	person1.setPhone(persons.get(i).toString());
        	person1.setEmail(persons.get(i).toString());
        	
        	address1.setAddress(persons.get(i).toString());
      	    address1.setZip(persons.get(i).toString());
      	    address1.setCity(persons.get(i).toString());
      	
            person1.setAddress(address1);
            //System.out.println(person1);
             * 
             */
            
      	   }
      	  
          System.out.println(pers);

         

      	   }

         }


             
        



	     
                 
       
	




