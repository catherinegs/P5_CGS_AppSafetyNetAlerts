package com.safetynet.alertsapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.alertsapp.model.Persons;
import com.safetynet.alertsapp.repository.PersonsRepository;

@Service
public class PersonsService {
	
	

	    @Autowired
	    private PersonsRepository repository;

	    public Persons savePersons(Persons person) {
	        return repository.save(person);
	    }

	    public List<Persons> getPersons() {
	        return repository.getAllPersons();
	    }
	}   


