package com.safetynet.alertsapp.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.safetynet.alertsapp.model.MedicalRecords;
import com.safetynet.alertsapp.model.Persons;
import com.safetynet.alertsapp.model.Dtos.ReadMedRecordsFromJson;
import com.safetynet.alertsapp.model.Dtos.ReadPersonsFromJson;

@Repository
public class MedicalRecordsRepository {
	
	@Autowired
	private ReadMedRecordsFromJson readMedicalRecords;
	
	//create ObjectMapper instance
    private static ObjectMapper objectMapper = new ObjectMapper();
			
	private static List<MedicalRecords> medRecList = new ArrayList<MedicalRecords>();
	
	public List<MedicalRecords> getAllMedicalRecords() {
	
        return readMedicalRecords.medRecList;      
    }
	


}