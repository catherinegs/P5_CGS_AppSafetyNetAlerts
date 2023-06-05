package com.safetynet.alertsapp.model.Json;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.annotation.PostConstruct;

import org.json.simple.JSONArray;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.safetynet.alertsapp.model.Address;
import com.safetynet.alertsapp.model.MedicalRecords;
import com.safetynet.alertsapp.model.Persons;

@Component
@Order(1)
public class ReadMedRecordsFromJson {
		

	//create ObjectMapper instance
    private static ObjectMapper objectMapper = new ObjectMapper();
    
	public static  List<MedicalRecords> medRecList = new ArrayList<MedicalRecords>();
	
	MedicalRecords medicalRecords = new MedicalRecords();
	
	public static int count;


	
	
    public static List<MedicalRecords> getMedRecList() {
		return medRecList;
	}


	public static void setMedRecList(List<MedicalRecords> medRecList) {
		ReadMedRecordsFromJson.medRecList = medRecList;
	}

/**
	// read data from json file
	public ReadMedRecordsFromJson() throws StreamReadException, DatabindException, IOException {

		readMedRecordsFromFile();

	}
**/
	@PostConstruct
	@SuppressWarnings("unchecked")
	public void readMedRecordsFromFile() throws StreamReadException, DatabindException, IOException {

		objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		Map<String, ?> resultMap = objectMapper.readValue(new ClassPathResource("data.json").getFile(),
				new TypeReference<Map<String, List>>() {
				});
		
		List<Object> medRec = (List<Object>) resultMap.get("medicalrecords");
		Map<String, String> medicoMapp = new HashMap<>();

		List<String> medis = new ArrayList<String> ();
		List<String> allergies= new ArrayList<String>();
		
		Persons person = new Persons();


        // create list of objects MedicalRecords with birthdate  
		for (int i = 0; i <= medRec.size() - 1; i++) {
			
			medicoMapp = (Map<String, String>) medRec.get(i);
			System.out.println(medicoMapp);
			
			medicalRecords.setBirthdate(medicoMapp.get("birthdate"));
			person.setFirstName(medicoMapp.get("firstName"));
			person.setLastName(medicoMapp.get("lastName"));
			medicalRecords.setPerson(person);

			
			System.out.println(medicalRecords);

			medRecList.add(medicalRecords);

						
			medis = ((Map<String,List>) medRec.get(i)).get("medications");
			
			allergies = ((Map<String,List>) medRec.get(i)).get("allergies");

			
			for (int j = 0; j <= medis.size() - 1; j++) {
				
			medicalRecords.setMedications(medis);
			medRecList.add(medicalRecords);

			
			}
			
			for (int k = 0; k <= allergies.size() - 1; k++) {
		
			
			medicalRecords.setAllergies(allergies);
			medRecList.add(medicalRecords);


			
			}
					
			System.out.println(medis);
			
			System.out.println(allergies);
			
			
			
			
		}
				
				
       }
	
	
	/**
	public  MedicalRecords getMedRecords() {
		  
			  
			  ((IntStream) medicalRecords).forEach(medicalRecord -> System.out.println(medicalRecord));
			  
		  

		  
		  return medicalRecords;
		  
		  
		  
		  
	  }
	 * @param j 

**/


	public MedicalRecords get() {
		

	return medicalRecords;
	}

	
	}



	


	






	
	


