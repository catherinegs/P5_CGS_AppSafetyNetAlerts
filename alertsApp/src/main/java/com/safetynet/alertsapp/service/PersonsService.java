package com.safetynet.alertsapp.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.safetynet.alertsapp.model.Persons;
import com.safetynet.alertsapp.repository.PersonsRepository;

@Service
public class PersonsService {
	
	

	    @Autowired
	    private PersonsRepository personRepository;
	    
	    public  Iterable<Persons> getPersons() throws StreamReadException, DatabindException, IOException {
	        return personRepository.getAllPersons();
	    }

	    
	    public Persons updatePersons(Persons person) {
	    	
	        return personRepository.update(person);
	    }
	    
		public Persons getPersonByName(String firstName, String lastName) {
			
			return personRepository.getPersonByName(firstName, lastName);
		}
		
		public String deletePerso(String firstName , String lastName) {
			
			personRepository.deletePerson(firstName, lastName);
			return "person removed" + firstName  +lastName;
		}


	}   


