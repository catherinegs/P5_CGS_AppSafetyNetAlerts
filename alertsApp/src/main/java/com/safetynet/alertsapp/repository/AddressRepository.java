package com.safetynet.alertsapp.repository;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.safetynet.alertsapp.model.Address;
import com.safetynet.alertsapp.model.Json.ReadAddressFromJson;

@Repository
public class AddressRepository {
	
	@Autowired
	private ReadAddressFromJson readAddresses;
	
	//create ObjectMapper instance
    private static ObjectMapper objectMapper = new ObjectMapper();
				    

	public List<Address> getAllAddress() throws StreamReadException, DatabindException, IOException {
		
	 
        return readAddresses.addressList;      
    }
	

}
