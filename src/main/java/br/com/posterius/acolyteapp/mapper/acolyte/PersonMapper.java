package br.com.posterius.acolyteapp.mapper.acolyte;

import br.com.posterius.acolyteapp.controller.person.PersonDTO;
import br.com.posterius.acolyteapp.entities.person.PersonEntity;

public class PersonMapper {
	public static final PersonEntity toEntity(PersonDTO personDto) {
		PersonEntity person = new PersonEntity();
		person.setId(personDto.id());
		person.setCode(personDto.code());
		person.setFirstName(personDto.firstName());
		person.setLastName(personDto.lastName());
		person.setDateBirth(personDto.dateBirth());
		person.setDeleted(personDto.deleted());
		return person;
	}
}
