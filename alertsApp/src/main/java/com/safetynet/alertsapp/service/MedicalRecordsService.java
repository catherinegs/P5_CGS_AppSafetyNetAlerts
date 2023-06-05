package com.safetynet.alertsapp.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.safetynet.alertsapp.model.MedicalRecords;
import com.safetynet.alertsapp.model.Persons;
import com.safetynet.alertsapp.repository.MedicalRecordsRepository;
import com.safetynet.alertsapp.repository.PersonsRepository;

@Service
public class MedicalRecordsService {
	
	
    @Autowired
    private MedicalRecordsRepository medRecordsRepository;
    
    public  List<MedicalRecords> getMedicalRecords() {
        return medRecordsRepository.getAllMedicalRecords();
    }
    



}
