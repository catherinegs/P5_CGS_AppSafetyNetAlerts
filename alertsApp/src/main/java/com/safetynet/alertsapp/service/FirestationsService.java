package com.safetynet.alertsapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.alertsapp.model.Firestations;
import com.safetynet.alertsapp.repository.FirestationsRepository;

@Service
public class FirestationsService {	
	
    @Autowired
    private FirestationsRepository repository;


    public Iterable<Firestations> getFireStations() {
        return repository.getAllFirestations();
    }


}


