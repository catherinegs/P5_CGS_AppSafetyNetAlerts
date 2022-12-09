package com.safetynet.alertsapp.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.safetynet.alertsapp.model.Address;

public class AddressJson {
	
	
	public void jsonAddressParse() throws JsonProcessingException {
		
		

	    //create ObjectMapper instance
	    ObjectMapper objectMapper = new ObjectMapper();

			// Convert JSON string to Object
			String jsonInString =
					"[{ \"addId\":\"1\", \"address\":\"1509 Culver St\", \"city\":\"Culver\", \"zip\":\"97451\"}, \n"+
					" { \"addId\":\"2\", \"address\":\"29 15th St\", \"city\":\"Culver\", \"zip\":\"97451\"},     \n"+
					" { \"addId\":\"3\", \"address\":\"834 Binoc Ave\", \"city\":\"Culver\", \"zip\":\"97451\"},  \n"+
					" { \"addId\":\"4\", \"address\":\"644 Gershwin Cir\", \"city\":\"Culver\", \"zip\":\"97451\"}, \n"+
					" { \"addId\":\"5\", \"address\":\"748 Townings Dr\", \"city\":\"Culver\", \"zip\":\"97451\"}, \n"+
					" { \"addId\":\"6\", \"address\":\"112 Steppes Pl\", \"city\":\"Culver\", \"zip\":\"97451\"}, \n"+
					" { \"addId\":\"7\", \"address\":\"489 Manchester St\", \"city\":\"Culver\", \"zip\":\"97451\"}, \n"+
					" { \"addId\":\"8\", \"address\":\"892 Downing Ct\", \"city\":\"Culver\", \"zip\":\"97451\"}, \n"+
					" { \"addId\":\"9\", \"address\":\"908 73rd St\", \"city\":\"Culver\", \"zip\":\"97451\"}, \n"+
					" { \"addId\":\"10\", \"address\":\"112 Steppes Pl\", \"city\":\"Culver\", \"zip\":\"97451\"}, \n"+
					" { \"addId\":\"11\", \"address\":\"947 E. Rose Dr\", \"city\":\"Culver\", \"zip\":\"97451\"}, \n"+
					" { \"addId\":\"12\", \"address\":\"951 LoneTree Rd\", \"city\":\"Culver\", \"zip\":\"97451\"}, \n"+
					"]";
			
			List<Map<String, Object>> listAddres = new ArrayList<Map<String, Object>>();
			Map<String, Object> mapAddres  = objectMapper.readValue(jsonInString, new TypeReference<Map<String,Object>>(){});
			
			System.out.println(mapAddres);
			listAddres.add(mapAddres);

			
			
			
	}		


}
