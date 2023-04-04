package com.safetynet.alertsapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.alertsapp.model.Firestations;
import com.safetynet.alertsapp.repository.FirestationsRepository;

@Service
public class FirestationsService {	
	
    @Autowired
    private FirestationsRepository repository;


    public List<Firestations> getFireStations() {
        return repository.getAllFirestations();
    }


}


