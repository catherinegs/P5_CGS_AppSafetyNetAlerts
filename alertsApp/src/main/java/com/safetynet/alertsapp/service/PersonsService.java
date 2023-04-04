package com.safetynet.alertsapp.service;

import java.io.IOException;
import java.util.List;

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
	    
	    public  List<Persons> getPersons() throws StreamReadException, DatabindException, IOException {
	        return personRepository.getAllPersons();
	    }

	    
	    public Persons savePersons(Persons person) {
	    	Persons savedPerson = personRepository.save(person);
	        return savedPerson;
	    }
	    
	    

	}   


