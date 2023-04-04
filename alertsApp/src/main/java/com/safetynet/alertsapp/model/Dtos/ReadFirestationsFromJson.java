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
import com.safetynet.alertsapp.model.Address;
import com.safetynet.alertsapp.model.Firestations;

@Component
public class ReadFirestationsFromJson {
	
	// create ObjectMapper instance
	static ObjectMapper objectMapper = new ObjectMapper();
	
	public static List<Firestations> firestationsList = new ArrayList<>();


    // read data from json file
	public ReadFirestationsFromJson() throws StreamReadException, DatabindException, IOException {

		readFireStationsFromFile();

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
			Address address = new Address();
			Firestations fireStation = new Firestations();
			System.out.println(stationsMap);

			fireStation.setStation(stationsMap.get("station"));
			address.setAddress(stationsMap.get("address"));
			fireStation.setAddress(address);
			System.out.println(fireStation);
			
			firestationsList.add(fireStation);

		}

		System.out.println(firestationsList);

	}
	

}
