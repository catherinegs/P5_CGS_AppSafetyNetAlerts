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

import org.json.simple.JSONArray;
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
public class ReadMedRecordsFromJson {
	
	
	@JsonDeserialize(using = CustomStringDeserializer.class)
	List<String> allergiesList = new ArrayList();


	//create ObjectMapper instance
    private static ObjectMapper objectMapper = new ObjectMapper();
    
	public static  List<MedicalRecords> medRecList = new ArrayList<MedicalRecords>();
	
    // read data from json file
	public ReadMedRecordsFromJson() throws StreamReadException, DatabindException, IOException {

		readMedRecordsFromFile();

	}


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
		
		MedicalRecords medicalRecords = new MedicalRecords();	


        // create list of objects MedicalRecords with birthdate  
		for (int i = 0; i <= medRec.size() - 1; i++) {
			
			medicoMapp = (Map<String, String>) medRec.get(i);
			System.out.println(medicoMapp);
			
			medicalRecords.setBirthdate(medicoMapp.get("birthdate"));
			medRecList.add(medicalRecords);

		

			
			medis = ((Map<String,List>) medRec.get(i)).get("medications");

			medicalRecords.setMedications(medis);
			medRecList.add(medicalRecords);

		


			allergies = ((Map<String,List>) medRec.get(i)).get("allergies");
			
			medicalRecords.setAllergies(allergies);

			System.out.println(medis);
			medRecList.add(medicalRecords);


		
		
		}
		
			
					
			System.out.println(medicalRecords);

			

			
		
       }
	


	}






	
	


