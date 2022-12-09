package com.safetynet.alertsapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.alertsapp.model.Persons;
import com.safetynet.alertsapp.service.PersonsService;

@RestController
@RequestMapping("/persons")

public class PersonsController {
	
	@Autowired
	private PersonsService service;
	
	@PostMapping("/add")
	public Persons addPersons(@RequestBody Persons person)  {
		
		return service.savePersons(person);
	}
	
	@GetMapping("/test")
	public List<Persons>  getPersons()  {
		
		return service.getPersons();
	}

	


}
