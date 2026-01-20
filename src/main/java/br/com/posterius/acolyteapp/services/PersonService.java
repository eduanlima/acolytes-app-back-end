package br.com.posterius.acolyteapp.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import br.com.posterius.acolyteapp.controller.person.PersonDTO;
import br.com.posterius.acolyteapp.controller.person.PersonRequestDTO;
import br.com.posterius.acolyteapp.entities.person.PersonEntity;
import br.com.posterius.acolyteapp.repositories.person.PersonRepository;

@Service
public class PersonService {
	@Autowired
	private PersonRepository personRepository;
	
	public PersonEntity validateUser(UUID personId) {
		return personRepository.findByIdAndDeletedFalse(personId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	@Transactional(readOnly = true)
	public List<PersonDTO> findAll(){
		return personRepository.findAll().stream().map(e -> new PersonDTO(e)).toList();
	}
	
	@Transactional(readOnly = true)
	public PersonDTO findById(UUID id) {
		Optional<PersonEntity> optional = personRepository.findByIdAndDeletedFalse(id);
		PersonEntity entity = optional.get();
		return new PersonDTO(entity);
	} 
	
	@Transactional
	public PersonEntity save(PersonRequestDTO personDto) {
		PersonEntity person = new PersonEntity();
		
		if (personDto.id() != null) {
			Optional<PersonEntity> optionalPerson = personRepository.findById(personDto.id());
			person = optionalPerson != null ? optionalPerson.get() : person;
		}
		
		if (person.getId() == null) {
			Integer lastCode = personRepository.findMaxCode();
			person.setCode(lastCode == null ? 1 : lastCode + 1);
		}
		
		copyRecordToEntity(personDto, person);
		person = personRepository.saveAndFlush(person);
		return person;
	}
	
	@Transactional
	public void delete(UUID personId) {
		PersonEntity person = validateUser(personId);
		person.setDeleted(true);
		personRepository.save(person);
	}
	
	@Transactional
	public PersonDTO insert(PersonDTO dto) {
		PersonEntity entity = new PersonEntity();
		copyDtoToEntity(dto, entity);
		Integer lastCode = personRepository.findMaxCode();
		entity.setCode(lastCode == null ? 1 : lastCode + 1);
		entity = personRepository.save(entity);
		return new PersonDTO(entity);
	}
	
	@Transactional
	public PersonDTO update(UUID id, PersonDTO dto) {
		PersonEntity entity = personRepository.getReferenceById(id);
		entity.setFirstName(dto.getFirstName());
		entity.setLastName(dto.getLastName());
		entity.setDateBirth(dto.getDateBirth());
		
		entity = personRepository.save(entity);
		return new PersonDTO(entity);
	}
	
	private void copyDtoToEntity(PersonDTO dto, PersonEntity entity ) {
		BeanUtils.copyProperties(dto, entity);
	}
	
	private void copyRecordToEntity(PersonRequestDTO personDto, PersonEntity person) {
		person.setFirstName(personDto.firstName());
		person.setLastName(personDto.lastName());
		person.setDateBirth(personDto.dateBirth());
		person.setDeleted(false);
	}
	
	
}
