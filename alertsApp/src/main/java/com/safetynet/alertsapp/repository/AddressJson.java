package com.safetynet.alertsapp.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.safetynet.alertsapp.model.Address;

public class AddressJson {
	
	
	public void jsonAddressParse() throws JsonProcessingException {
		
		

	    //create ObjectMapper instance
	    ObjectMapper objectMapper = new ObjectMapper();
	    
	    
	   

			// Convert JSON string to Object
			String jsonInString =
					"[{ \"address\":\"1509 Culver St\", \"city\":\"Culver\", \"zip\":\"97451\"}, \n"+
					" { \"address\":\"1509 Culver St\", \"city\":\"Culver\", \"zip\":\"97451\"}, \n"+
					" { \"address\":\"1509 Culver St\", \"city\":\"Culver\", \"zip\":\"97451\"}, \n"+
					" { \"address\":\"1509 Culver St\", \"city\":\"Culver\", \"zip\":\"97451\"}, \n"+
					" { \"address\":\"1509 Culver St\", \"city\":\"Culver\", \"zip\":\"97451\"}, \n"+
					" { \"address\":\"29 15th St\", \"city\":\"Culver\", \"zip\":\"97451\"},     \n"+
					" { \"address\":\"834 Binoc Ave\", \"city\":\"Culver\", \"zip\":\"97451\"},  \n"+
					" { \"address\":\"644 Gershwin Cir\", \"city\":\"Culver\", \"zip\":\"97451\"}, \n"+
					" { \"address\":\"748 Townings Dr\", \"city\":\"Culver\", \"zip\":\"97451\"}, \n"+
					" {  \"address\":\"112 Steppes Pl\", \"city\":\"Culver\", \"zip\":\"97451\"}, \n"+
					" { \"address\":\"489 Manchester St\", \"city\":\"Culver\", \"zip\":\"97451\"}, \n"+
					" { \"address\":\"892 Downing Ct\", \"city\":\"Culver\", \"zip\":\"97451\"}, \n"+
					" { \"address\":\"892 Downing Ct\", \"city\":\"Culver\", \"zip\":\"97451\"}, \n"+
					" { \"address\":\"892 Downing Ct\", \"city\":\"Culver\", \"zip\":\"97451\"}, \n"+
					" { \"address\":\"908 73rd St\", \"city\":\"Culver\", \"zip\":\"97451\"}, \n"+
					" { \"address\":\"908 73rd St\", \"city\":\"Culver\", \"zip\":\"97451\"}, \n"+
					" { \"address\":\"112 Steppes Pl\", \"city\":\"Culver\", \"zip\":\"97451\"}, \n"+
					" { \"address\":\"112 Steppes Pl\", \"city\":\"Culver\", \"zip\":\"97451\"}, \n"+
					" { \"address\":\"947 E. Rose Dr\", \"city\":\"Culver\", \"zip\":\"97451\"}, \n"+
					" { \"address\":\"947 E. Rose Dr\", \"city\":\"Culver\", \"zip\":\"97451\"}, \n"+
					" { \"address\":\"947 E. Rose Dr\", \"city\":\"Culver\", \"zip\":\"97451\"}, \n"+
					" { \"address\":\"748 Townings Dr\", \"city\":\"Culver\", \"zip\":\"97451\"}, \n"+
					" { \"address\":\"951 LoneTree Rd\", \"city\":\"Culver\", \"zip\":\"97451\"}, \n"+
					"]";
			Address addresses = objectMapper.readValue(jsonInString, Address.class);
			
			System.out.println(addresses);

			
			
			
	}		


}
