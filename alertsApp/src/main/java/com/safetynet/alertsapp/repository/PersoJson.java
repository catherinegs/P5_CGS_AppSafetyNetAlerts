package com.safetynet.alertsapp.repository;



import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.safetynet.alertsapp.model.Address;
import com.safetynet.alertsapp.model.Firestations;
import com.safetynet.alertsapp.model.Persons;


public class PersoJson {
	

	List<Persons> persons = new ArrayList<>();
	List<Firestations> stations = new ArrayList<>();
	
    public void readPersonsFromFile () throws StreamReadException, DatabindException, IOException {
    	
    	//create ObjectMapper instance
        ObjectMapper objectMapper = new ObjectMapper();
        
		
        //JSON parser object to parse read file

    
	// Convert JSON string to Object
	String personJson =
			"[{ \"personId\" : \"1\", \"firstName\": \"John\", \"lastName\": \"Boyd\", \"phone\": \"841-874-6512\", \"email\": \"jaboyd@email.com\", \"birthdate\":\"03/06/1984\", "
			+ "\"address\" : { \"addId\":\"1\", \"address\":\"1509 Culver St\", \"city\":\"Culver\", \"zip\":\"97451\", "
			+ " \"medications\":{{[\"aznol:350mg\", \"hydrapermazol:100mg\"]}}},\n"+
	        " { \"personId\" : \"2\", \"firstName\": \"Jacob\", \"lastName\": \"Boyd\", \"phone\": \"841-874-6513\", \"email\": \"drk@email.com\", \"birthdate\":\"03/06/1989\", "
			+ "\"address\" : { \"addId\":\"1\", \"address\":\"1509 Culver St\", \"city\":\"Culver\", \"zip\":\"97451\"}}, \n"+
			" { \"personId\" : \"3\", \"firstName\": \"Tenley\", \"lastName\": \"Boyd\", \"phone\": \"841-874-6512\", \"email\": \"tenz@email.com\", \"birthdate\":\"02/18/2012\", "
			+ "\"address\" : { \"addId\":\"1\", \"address\":\"1509 Culver St\", \"city\":\"Culver\", \"zip\":\"97451\"}}, \n"+
	        " { \"personId\" : \"4\", \"firstName\": \"Roger\", \"lastName\": \"Boyd\", \"phone\": \"841-874-6512\", \"email\": \"jaboyd@email.com\", \"birthdate\":\"09/06/2017\", "
			+ "\"address\" : { \"addId\":\"1\", \"address\":\"1509 Culver St\", \"city\":\"Culver\", \"zip\":\"97451\"}}, \n"+
			" { \"personId\" : \"5\", \"firstName\": \"Felicia\", \"lastName\": \"Boyd\", \"phone\": \"841-874-6544\", \"email\": \"jaboyd@email.com\", \"birthdate\":\"01/08/1986\", "
			+ "\"address\" : { \"addId\":\"1\", \"address\":\"1509 Culver St\", \"city\":\"Culver\", \"zip\":\"97451\"}},\n"+
			" { \"personId\" : \"6\", \"firstName\": \"Jonathan\", \"lastName\": \"Marrack\", \"phone\": \"841-874-6513\", \"email\": \"drk@email.com\", \"birthdate\":\"01/03/1989\", "
			+ "\"address\" : { \"addId\":\"2\", \"address\":\"29 15th St\", \"city\":\"Culver\", \"zip\":\"97451\"}}, \n"+
	        " { \"personId\" : \"7\", \"firstName\": \"Tessa\", \"lastName\": \"Carman\", \"phone\": \"841-874-6512\", \"email\": \"tenz@email.com\", \"birthdate\":\"02/18/2012\", "
			+ "\"address\" :  { \"addId\":\"3\", \"address\":\"834 Binoc Ave\", \"city\":\"Culver\", \"zip\":\"97451\"}}, \n"+
			" { \"personId\" : \"8\", \"firstName\": \"Peter\", \"lastName\": \"Duncan\", \"phone\": \"841-874-6512\", \"email\": \"jaboyd@email.com\", \"birthdate\":\"09/06/2000\", "
			+ " \"address\" :{ \"addId\":\"4\", \"address\":\"644 Gershwin Cir\", \"city\":\"Culver\", \"zip\":\"97451\"}}, \n"+
	        " { \"personId\" : \"9\", \"firstName\": \"Foster\", \"lastName\": \"Shepard\", \"phone\": \"841-874-6544\", \"email\": \"jaboyd@email.com\", \"birthdate\":\"01/08/1980\", "
			+ "\"address\" : { \"addId\":\"5\", \"address\":\"748 Townings Dr\", \"city\":\"Culver\", \"zip\":\"97451\"}}, \n"+
			" { \"personId\" : \"10\", \"firstName\": \"Tony\", \"lastName\": \"Cooper\", \"phone\": \"841-874-6874\", \"email\": \"tcoop@ymail.com\", \"birthdate\":\"03/06/1994\", "
			+ " { \"addId\":\"6\", \"address\":\"112 Steppes Pl\", \"city\":\"Culver\", \"zip\":\"97451\"}}, \n"+
			" { \"personId\" : \"11\", \"firstName\": \"Lily\", \"lastName\": \"Cooper\", \"phone\": \"841-874-9845\", \"email\": \"lily@email.com\", \"birthdate\":\"03/06/1994\", "
			+ " { \"addId\":\"7\", \"address\":\"489 Manchester St\", \"city\":\"Culver\", \"zip\":\"97451\"}, \n}, \n"+
	        " { \"personId\" : \"12\", \"firstName\": \"Sophia\", \"lastName\": \"Zemicks\", \"phone\": \"841-874-7878\", \"email\": \"soph@email.com\", \"birthdate\":\"03/06/1988\", "
			+ " { \"addId\":\"8\", \"address\":\"892 Downing Ct\", \"city\":\"Culver\", \"zip\":\"97451\"}}, \n"+
			" { \"personId\" : \"13\", \"firstName\": \"Warren\", \"lastName\": \"Zemicks\", \"phone\": \"841-874-7512\", \"email\": \"ward@email.com\", \"birthdate\":\"03/06/1985\", "
			+ " { \"addId\":\"8\", \"address\":\"892 Downing Ct\", \"city\":\"Culver\", \"zip\":\"97451\"}}, \n"+
	        " { \"personId\" : \"14\", \"firstName\": \"Zach\", \"lastName\": \"Zemicks\", \"phone\": \"841-874-7512\", \"email\": \"zarc@email.com\", \"birthdate\":\"03/06/2017\", "
			+ " { \"addId\":\"8\", \"address\":\"892 Downing Ct\", \"city\":\"Culver\", \"zip\":\"97451\"}}, \n"+
			" { \"personId\" : \"15\", \"firstName\": \"Reginald\", \"lastName\": \"Walker\", \"phone\": \"841-874-8547\", \"email\": \"reg@email.com\", \"birthdate\":\"08/30/1979\", "
			+ " { \"addId\":\"9\", \"address\":\"908 73rd St\", \"city\":\"Culver\", \"zip\":\"97451\"}}, \n"+
			" { \"personId\" : \"16\", \"firstName\": \"Jamie\", \"lastName\": \"Peters\", \"phone\": \"841-874-7462\", \"email\": \"jpeter@email.com\", \"birthdate\":\"03/06/1982\", "
			+ " { \"addId\":\"9\", \"address\":\"908 73rd St\", \"city\":\"Culver\", \"zip\":\"97451\"}}, \n"+
	        " { \"personId\" : \"17\", \"firstName\": \"Ron\", \"lastName\": \"Peters\", \"phone\": \"841-874-8888\", \"email\": \"jpeter@email.com \", \"birthdate\":\"04/06/1965\", "
			+ " { \"addId\":\"10\", \"address\":\"112 Steppes Pl\", \"city\":\"Culver\", \"zip\":\"97451\"}}, \n"+
			" { \"personId\" : \"18\", \"firstName\": \"Allison\", \"lastName\": \"Boyd\", \"phone\": \"841-874-9888\", \"email\": \"aly@imail.com\", \"birthdate\":\"03/15/1965\", "
			+ " { \"addId\":\"10\", \"address\":\"112 Steppes Pl\", \"city\":\"Culver\", \"zip\":\"97451\"}}, \n"+
	        " { \"personId\" : \"19\", \"firstName\": \"Brian\", \"lastName\": \"Stelzer\", \"phone\": \"841-874-7784\", \"email\": \"bstel@email.com\", \"birthdate\":\"12/06/1975\", "
			+ " { \"addId\":\"11\", \"address\":\"947 E. Rose Dr\", \"city\":\"Culver\", \"zip\":\"97451\"}}, \n"+
			" { \"personId\" : \"20\", \"firstName\": \"Shawna\", \"lastName\": \"Stelzer\", \"phone\": \"841-874-7784\", \"email\": \"ssanw@email.com\", \"birthdate\":\"07/08/1980\", "
			+ " { \"addId\":\"11\", \"address\":\"947 E. Rose Dr\", \"city\":\"Culver\", \"zip\":\"97451\"}}, \n"+
			" { \"personId\" : \"21\", \"firstName\": \"Kendrick\", \"lastName\": \"Stelzer\", \"phone\": \"841-874-7784\", \"email\": \"bstel@email.com\", \"birthdate\":\"03/06/2014\", "
			+ " { \"addId\":\"11\", \"address\":\"947 E. Rose Dr\", \"city\":\"Culver\", \"zip\":\"97451\"}}, \n"+
	        " { \"personId\" : \"22\", \"firstName\": \"Clive\", \"lastName\": \"Ferguson\", \"phone\": \"841-874-6741\", \"email\": \"clivfd@ymail.com\", \"birthdate\":\"03/06/1994\", "
			+ " { \"addId\":\"5\", \"address\":\"748 Townings Dr\", \"city\":\"Culver\", \"zip\":\"97451\"}}, \n"+
			" { \"personId\" : \"23\", \"firstName\": \"Eric\", \"lastName\": \"Cadigan\", \"phone\": \"841-874-7458\", \"email\": \"gramps@email.com\", \"birthdate\":\"08/06/1945, "
			+ " { \"addId\":\"12\", \"address\":\"951 LoneTree Rd\", \"city\":\"Culver\", \"zip\":\"97451\"}}, \n"+
			"]";
    	
 	

        Persons persons  = objectMapper.readValue(personJson, Persons.class);
    
        //read JSON file and convert to a customer object
	
		System.out.println(persons);
		
		
	}
    
 
		

}
