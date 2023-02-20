package com.safetynet.alertsapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.safetynet.alertsapp.model.Firestations;
import com.safetynet.alertsapp.repository.FireStationsRepository;

@Service
public class FireStationsService {
	

    @Autowired
    private FireStationsRepository repository;


    public Iterable<Firestations> getFireStations() {
        return repository.getAllFirestations();
    }


}
