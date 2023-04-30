package com.safetynet.alertsapp.model.Json;

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
public class ReadAddressFromJson {

	// create ObjectMapper instance
	static ObjectMapper objectMapper = new ObjectMapper();

	public List<Address> addressList = new ArrayList<>();
	
	

	public List<Address> getAddressList() {
		return addressList;
	}

	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
	}

	// read data from json file
	public ReadAddressFromJson() throws StreamReadException, DatabindException, IOException {

		readAddressFromFile();

	}

	public void readAddressFromFile() throws StreamReadException, DatabindException, IOException {
		objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
		Map<String, ?> resultMap = objectMapper.readValue(new ClassPathResource("data.json").getFile(),
				new TypeReference<Map<String, List>>() {
				});

		List<Object> addresses = (List<Object>) resultMap.get("persons");

		Map<String, String> addressMap = new HashMap<>();

		for (int i = 0; i <= addresses.size() - 1; i++) {

			addressMap = (Map<String, String>) addresses.get(i);
			Address address = new Address();

			address.setAddress(addressMap.get("address"));
			address.setCity(addressMap.get("city"));
			address.setZip(addressMap.get("zip"));
			System.out.println(address);

			addressList.add(address);

		}

		System.out.println(addressList);

	}

}
