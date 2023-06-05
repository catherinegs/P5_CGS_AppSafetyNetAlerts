package com.safetynet.alertsapp.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.alertsapp.model.MedicalRecords;
import com.safetynet.alertsapp.model.Persons;
import com.safetynet.alertsapp.service.MedicalRecordsService;

@RestController
@RequestMapping("/medicalrecords")
public class MedicalRecordsController {
	
	@Autowired
	private MedicalRecordsService medRec;

	public MedicalRecordsController(MedicalRecordsService medRec) {
		this.medRec = medRec;
	}
	
	
	@GetMapping("/Medicalrecord")
	public ResponseEntity<Iterable<MedicalRecords>>  getmedicalRecords()  {
		
		return  new ResponseEntity<>(medRec.getMedicalRecords(), HttpStatus.OK);
	}


	

}
