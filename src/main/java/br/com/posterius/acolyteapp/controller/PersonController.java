package br.com.posterius.acolyteapp.controller;

import java.net.URI;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.posterius.acolyteapp.dto.PersonDTO;
import br.com.posterius.acolyteapp.services.PersonService;

@RestController
@RequestMapping(value = "/person")
public class PersonController {
	@Autowired
	private PersonService personService;
	
	@GetMapping
	public List<PersonDTO> findAll() {
		return personService.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PersonDTO> findById(@PathVariable UUID id) {
		PersonDTO dto = personService.findById(id);
		return ResponseEntity.ok(dto);
	}
	
	@PostMapping
	public ResponseEntity<PersonDTO> insert(@RequestBody PersonDTO dto) {
		dto = personService.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<PersonDTO> update(@PathVariable UUID id, @RequestBody PersonDTO dto) {
		dto = personService.update(id, dto);
		return ResponseEntity.ok(dto);
	}
}
