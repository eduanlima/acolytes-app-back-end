package br.com.posterius.acolyteapp.controller.person;

import java.sql.Timestamp;
import java.util.UUID;

import br.com.posterius.acolyteapp.entities.person.PersonEntity;

public record PersonRequestDTO(UUID id, Integer code, String firstName, String lastName, Timestamp dateBirth,
		Boolean isDeleted) {
	public PersonRequestDTO(PersonEntity person) {
		this(person.getId(), person.getCode(), person.getFirstName(), person.getLastName(), person.getDateBirth(),
				person.getDeleted());
	}
}
