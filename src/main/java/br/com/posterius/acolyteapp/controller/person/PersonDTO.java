package br.com.posterius.acolyteapp.controller.person;

import java.sql.Timestamp;
import java.util.UUID;

import br.com.posterius.acolyteapp.entities.person.PersonEntity;

public record PersonDTO(UUID id, Integer code, String firstName, String lastName, Timestamp dateBirth, Boolean deleted) {
	public PersonDTO(PersonEntity person) {
		this(person.getId(), person.getCode(), person.getFirstName(), person.getLastName(), person.getDateBirth(), person.getDeleted());
	}
}
