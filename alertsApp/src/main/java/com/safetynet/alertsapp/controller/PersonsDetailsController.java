package com.safetynet.alertsapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.safetynet.alertsapp.model.Persons;
import com.safetynet.alertsapp.service.PersonsDetailsService;

@RestController
@RequestMapping("/persons")
public class PersonsDetailsController {
	
	@Autowired
	private PersonsDetailsService service;

	public PersonsDetailsController(PersonsDetailsService service) {
		super();
		this.service = service;
	}
	
	
	@GetMapping("/Persons")
	public List<Persons>  getPersons()  {
		
		return service.getPersons();
	}



}
