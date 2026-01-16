package br.com.posterius.acolyteapp.controller.person;

import java.sql.Timestamp;
import java.util.UUID;

import org.springframework.beans.BeanUtils;

import br.com.posterius.acolyteapp.entities.person.Person;

public class PersonDTO {
	private UUID id;
	private Integer code;
	private String firstName;
	private String lastName;
	private Timestamp dateBirth;
	private Boolean isActivated;
	
	public PersonDTO(Person entity) {
		BeanUtils.copyProperties(entity, this);
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Timestamp getDateBirth() {
		return dateBirth;
	}

	public void setDateBirth(Timestamp dateBirth) {
		this.dateBirth = dateBirth;
	}

	public Boolean getIsActivated() {
		return isActivated;
	}

	public void setIsActivated(Boolean isActivated) {
		this.isActivated = isActivated;
	}
}
