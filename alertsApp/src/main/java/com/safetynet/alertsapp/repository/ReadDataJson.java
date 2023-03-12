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

	// create ObjectMapper instance
	static ObjectMapper objectMapper = new ObjectMapper();

	public void readDataFromFile() throws StreamReadException, DatabindException, IOException {
		List<Map<String, Object>> resultMap = (List<Map<String, Object>>) objectMapper
				.readValue(new ClassPathResource("data.json").getFile(), List.class);

		System.out.println(resultMap);

	}

	public ReadDataJson() throws StreamReadException, DatabindException, IOException {

		readDataFromFile();

	}

	public static void readPersonsFromFile() throws StreamReadException, DatabindException, IOException {
		objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		Map<String, ?> resultMap = objectMapper.readValue(new ClassPathResource("data.json").getFile(),
				new TypeReference<Map<String, List>>() {
				});

		List<Object> pers = (List<Object>) resultMap.get("persons");

		Map<String, String> personsMap = new HashMap<>();

		for (int i = 0; i <= pers.size() - 1; i++) {

			personsMap = (Map<String, String>) pers.get(i);

			System.out.println(personsMap);

			Persons person1 = new Persons();
			Address address1 = new Address();

			person1.setFirstName(personsMap.get("firstName"));
			person1.setLastName(personsMap.get("lastName"));
			person1.setPhone(personsMap.get("phone"));
			person1.setEmail(personsMap.get("email"));
			address1.setAddress(personsMap.get("address"));
			address1.setZip(personsMap.get("zip"));
			address1.setCity(personsMap.get("city"));
			person1.setAddress(address1);
			System.out.println(person1);

		}

		System.out.println(pers);

	}
	
	public static void readFireStationsFromFile() throws StreamReadException, DatabindException, IOException {
		objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		Map<String, ?> resultMap = objectMapper.readValue(new ClassPathResource("data.json").getFile(),
				new TypeReference<Map<String, List>>() {
				});

		List<Object> stations = (List<Object>) resultMap.get("firestations");

		Map<String, String> stationsMap = new HashMap<>();

		for (int i = 0; i <= stations.size() - 1; i++) {

			stationsMap = (Map<String, String>) stations.get(i);

			System.out.println(stationsMap);

			Address address1 = new Address();
        	Firestations fireStation1 = new Firestations(); 
        	
        	fireStation1.setStation(stationsMap.get("station"));
          	address1.setAddress(stationsMap.get("address"));
          	fireStation1.setAddress(address1);        	
			System.out.println(fireStation1);

		}

		System.out.println(stations);

	}

	

}
