package com.safetynet.alertsapp.model.Dtos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
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

	// create ObjectMapper instance
	static ObjectMapper objectMapper = new ObjectMapper();

	private static Persons person1;

	public void readDataFromFile() throws StreamReadException, DatabindException, IOException {
		objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		Map<String, ?> resultMap = objectMapper.readValue(new ClassPathResource("data.json").getFile(),
				new TypeReference<Map<String, List>>() {
				});

		System.out.println(resultMap);

	}
	
    // read data from json file
	public ReadDataJson() throws StreamReadException, DatabindException, IOException {

		readDataFromFile();

	}

	public static void readMedicalRecordsFromFile() throws StreamReadException, DatabindException, IOException {
		objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		Map<String, ?> resultMap = objectMapper.readValue(new ClassPathResource("data.json").getFile(),
				new TypeReference<Map<String, List>>() {
				});
		
		List<Object> medRec = (List<Object>) resultMap.get("medicalrecords");

		Map<String, String> medRecMap = new HashMap<>();
		
		for (int j = 0; j <= medRec.size() - 1; j++) {
			medRecMap = (Map<String, String>) medRec.get(j);
			
			MedicalRecords medReco = new MedicalRecords();

			List<Object> medications = new ArrayList();
			medications.add(medRecMap.get("medications"));
			
			List<MedicalRecords> medRecList = new ArrayList<>();

			medReco.setBirthdate(medRecMap.get("birthdate"));
			person1.setMedicalRecords(medReco);

			medRecList.add(medReco);
			

		}

		System.out.println(medRec);

	}

	public static void readFireStationsFromFile() throws StreamReadException, DatabindException, IOException {
		objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		Map<String, ?> resultMap = objectMapper.readValue(new ClassPathResource("data.json").getFile(),
				new TypeReference<Map<String, List>>() {
				});

		List<Object> stations = (List<Object>) resultMap.get("firestations");

		Map<String, String> stationsMap = new HashMap<>();
		
		List<Firestations> firestationsList = new ArrayList<>();

		for (int i = 0; i <= stations.size() - 1; i++) {

			stationsMap = (Map<String, String>) stations.get(i);
			Address address1 = new Address();
			Firestations fireStation1 = new Firestations();


			System.out.println(stationsMap);

			fireStation1.setStation(stationsMap.get("station"));
			address1.setAddress(stationsMap.get("address"));
			fireStation1.setAddress(address1);
			System.out.println(fireStation1);
			
			firestationsList.add(fireStation1);


		}


		System.out.println(firestationsList);

	}

}
