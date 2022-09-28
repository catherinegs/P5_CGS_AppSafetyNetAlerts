package com.safetynet.alertsapp.repository;



import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.safetynet.alertsapp.model.Persons;

public class PersonsJson {
	
	public void jsonPersonParse() throws JsonProcessingException {
	
	

    //create ObjectMapper instance
    ObjectMapper objectMapper = new ObjectMapper();
    
    
   

		// Convert JSON string to Object
		String jsonInString =
				"[{ \"id\" : \"1\", \"firstName\": \"John\", \"lastName\": \"Boyd\", \"phone\": \"841-874-6512\", \"email\": \"jaboyd@email.com\"}, \n"+
		        " { \"id\" : \"2\", \"firstName\": \"Jacob\", \"lastName\": \"Boyd\", \"phone\": \"841-874-6513\", \"email\": \"drk@email.com\"}, \n"+
				" { \"id\" : \"3\", \"firstName\": \"Tenley\", \"lastName\": \"Boyd\", \"phone\": \"841-874-6512\", \"email\": \"tenz@email.com\"}, \n"+
		        " { \"id\" : \"4\", \"firstName\": \"Roger\", \"lastName\": \"Boyd\", \"phone\": \"841-874-6512\", \"email\": \"jaboyd@email.com\"}, \n"+
				" { \"id\" : \"5\", \"firstName\": \"Felicia\", \"lastName\": \"Boyd\", \"phone\": \"841-874-6544\", \"email\": \"jaboyd@email.com\"}, \n"+
				" { \"id\" : \"6\", \"firstName\": \"Jonathan\", \"lastName\": \"Marrack\", \"phone\": \"841-874-6513\", \"email\": \"drk@email.com\"}, \n"+
		        " { \"id\" : \"7\", \"firstName\": \"Tessa\", \"lastName\": \"Carman\", \"phone\": \"841-874-6512\", \"email\": \"tenz@email.com\"}, \n"+
				" { \"id\" : \"8\", \"firstName\": \"Peter\", \"lastName\": \"Duncan\", \"phone\": \"841-874-6512\", \"email\": \"jaboyd@email.com\"}, \n"+
		        " { \"id\" : \"9\", \"firstName\": \"Foster\", \"lastName\": \"Shepard\", \"phone\": \"841-874-6544\", \"email\": \"jaboyd@email.com\"}, \n"+
				" { \"id\" : \"10\", \"firstName\": \"Tony\", \"lastName\": \"Cooper\", \"phone\": \"841-874-6874\", \"email\": \"tcoop@ymail.com\"}, \n"+
				" { \"id\" : \"11\", \"firstName\": \"Lily\", \"lastName\": \"Cooper\", \"phone\": \"841-874-9845\", \"email\": \"lily@email.com\"}, \n"+
		        " { \"id\" : \"12\", \"firstName\": \"Sophia\", \"lastName\": \"Zemicks\", \"phone\": \"841-874-7878\", \"email\": \"soph@email.com\"}, \n"+
				" { \"id\" : \"13\", \"firstName\": \"Warren\", \"lastName\": \"Zemicks\", \"phone\": \"841-874-7512\", \"email\": \"ward@email.com\"}, \n"+
		        " { \"id\" : \"14\", \"firstName\": \"Zach\", \"lastName\": \"Zemicks\", \"phone\": \"841-874-7512\", \"email\": \"zarc@email.com\"}, \n"+
				" { \"id\" : \"15\", \"firstName\": \"Reginald\", \"lastName\": \"Walker\", \"phone\": \"841-874-8547\", \"email\": \"reg@email.com\"}, \n"+
				" { \"id\" : \"16\", \"firstName\": \"Jamie\", \"lastName\": \"Peters\", \"phone\": \"841-874-7462\", \"email\": \"jpeter@email.com\"}, \n"+
		        " { \"id\" : \"17\", \"firstName\": \"Ron\", \"lastName\": \"Peters\", \"phone\": \"841-874-8888\", \"email\": \"jpeter@email.com \"}, \n"+
				" { \"id\" : \"18\", \"firstName\": \"Allison\", \"lastName\": \"Boyd\", \"phone\": \"841-874-9888\", \"email\": \"aly@imail.com\"}, \n"+
		        " { \"id\" : \"19\", \"firstName\": \"Brian\", \"lastName\": \"Stelzer\", \"phone\": \"841-874-7784\", \"email\": \"bstel@email.com\"}, \n"+
				" { \"id\" : \"20\", \"firstName\": \"Shawna\", \"lastName\": \"Stelzer\", \"phone\": \"841-874-7784\", \"email\": \"ssanw@email.com\"}, \n"+
				" { \"id\" : \"21\", \"firstName\": \"Kendrick\", \"lastName\": \"Stelzer\", \"phone\": \"841-874-7784\", \"email\": \"bstel@email.com\"}, \n"+
		        " { \"id\" : \"22\", \"firstName\": \"Clive\", \"lastName\": \"Ferguson\", \"phone\": \"841-874-6741\", \"email\": \"clivfd@ymail.com\"}, \n"+
				" { \"id\" : \"23\", \"firstName\": \"Eric\", \"lastName\": \"Cadigan\", \"phone\": \"841-874-7458\", \"email\": \"gramps@email.com\"}, \n"+
				"]";
		
		
			
			Persons persons = objectMapper.readValue(jsonInString, Persons.class);
			System.out.println(persons);

	}

}
