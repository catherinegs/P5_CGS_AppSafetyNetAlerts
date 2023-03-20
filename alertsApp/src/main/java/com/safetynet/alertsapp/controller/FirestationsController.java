package com.safetynet.alertsapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.alertsapp.model.Firestations;
import com.safetynet.alertsapp.service.FirestationsService;

@RestController
@RequestMapping("/firestations")

public class FirestationsController {
	
	@Autowired
	private FirestationsService service;
	
	
	public FirestationsController(FirestationsService service) {
		this.service = service;
	}



	@GetMapping("/testfirestaions")
	public Iterable<Firestations>  getFireStations()  {
		
		return service.getFireStations();
	}

}


