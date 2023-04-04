package com.safetynet.alertsapp.model.Dtos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.safetynet.alertsapp.model.MedicalRecords;
import com.safetynet.alertsapp.model.Persons;

@Component
public class ReadMedRecordsFromJson {
	
	
	//create ObjectMapper instance
    private static ObjectMapper objectMapper = new ObjectMapper();
    
	public static List<MedicalRecords> medRecList = new ArrayList<MedicalRecords>();

    
	@SuppressWarnings("unchecked")
	public static void readPersonsFromFile() throws StreamReadException, DatabindException, IOException {

		objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		Map<String, ?> resultMap = objectMapper.readValue(new ClassPathResource("data.json").getFile(),
				new TypeReference<Map<String, List>>() {
				});
		
		List<Object> medRec = (List<Object>) resultMap.get("medicalrecords");

		Map<String, String> medRecMap = new HashMap<>();
		
		for (int j = 0; j <= medRec.size() - 1; j++) {
			medRecMap = (Map<String, String>) medRec.get(j);
			
			MedicalRecords medReco = new MedicalRecords();

			List<String> medicationsList = new ArrayList();
			medicationsList.add(medRecMap.get("medications"));
			List<String> allergiesList = new ArrayList();
			allergiesList.add(medRecMap.get("allergies"));
			medReco.setBirthdate(medRecMap.get("birthdate"));
			medReco.setMedications(medicationsList);
			medReco.setAllergies(allergiesList);

			medRecList.add(medReco);
			

		}

		System.out.println(medRecList);
		
		
	}




	
	

}
