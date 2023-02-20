package com.safetynet.alertsapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.alertsapp.model.Firestations;
import com.safetynet.alertsapp.service.FireStationsService;

@RestController
@RequestMapping("/firestations")
public class FireStationsController {
	
	@Autowired
	private FireStationsService service;
	
	
	public FireStationsController(FireStationsService service) {
		this.service = service;
	}



	@GetMapping("/testfirestaions")
	public Iterable<Firestations>  getFireStations()  {
		
		return service.getFireStations();
	}

}
