package com.safetynet.alertsapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.alertsapp.model.Persons;
import com.safetynet.alertsapp.repository.PersonsRepository;

@Service
public class PersonsDetailsService {
	
	@Autowired
    private PersonsRepository personRepository;
	
	/**
	   public List<Persons> getPerson(String birthdate) {
	        return (List<Persons>) personRepository.findByBirthdate(birthdate);
	    }
**/
	

    public List<Persons> getPersons() {
        return personRepository.getAllPersons();
    }
    




}
