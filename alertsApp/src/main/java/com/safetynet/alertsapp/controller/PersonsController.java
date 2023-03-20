package com.safetynet.alertsapp.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.safetynet.alertsapp.model.Persons;
import com.safetynet.alertsapp.service.PersonsService;

@RestController
@RequestMapping("/persons")

public class PersonsController {
	
	@Autowired
	private PersonsService service;
	
	
	
	public PersonsController(PersonsService service) {
		this.service = service;
	}
	
	


	


}
