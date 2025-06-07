package br.com.posterius.acolyteapp.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.posterius.acolyteapp.dto.PersonDTO;
import br.com.posterius.acolyteapp.entities.Person;
import br.com.posterius.acolyteapp.repositories.PersonRepository;

@Service
public class PersonService {
	@Autowired
	private PersonRepository personRepository;
	
	@Transactional(readOnly = true)
	public List<PersonDTO> findAll(){
		return personRepository.findAll().stream().map(e -> new PersonDTO(e)).toList();
	}
	
	
	@Transactional(readOnly = true)
	public PersonDTO findById(UUID id) {
		Optional<Person> optional = personRepository.findById(id);
		Person entity = optional.get();
		return new PersonDTO(entity);
	} 
	
	@Transactional
	public PersonDTO insert(PersonDTO dto) {
		Person entity = new Person();
		copyDtoToEntity(dto, entity);
		Integer lastCode = personRepository.findMaxCode();
		entity.setCode(lastCode == null ? 1 : lastCode + 1);
		entity = personRepository.save(entity);
		return new PersonDTO(entity);
	}
	
	@Transactional
	public PersonDTO update(UUID id, PersonDTO dto) {
		Person entity = personRepository.getReferenceById(id);
		copyDtoToEntity(dto, entity);
		entity = personRepository.save(entity);
		return new PersonDTO(entity);
	}
	
	private void copyDtoToEntity(PersonDTO dto, Person entity ) {
		BeanUtils.copyProperties(dto, entity);
	}
}
