package br.com.posterius.acolyteapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.posterius.acolyteapp.entities.Person;
import br.com.posterius.acolyteapp.services.PersonService;

@RestController
@RequestMapping(value = "/person")
public class PersonController {
	@Autowired
	private PersonService personService;
	
	@GetMapping
	public List<Person> findAll(){
		return personService.findAll();
	}
}
