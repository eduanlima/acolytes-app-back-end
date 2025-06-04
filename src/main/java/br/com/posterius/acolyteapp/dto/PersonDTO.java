package br.com.posterius.acolyteapp.dto;

import java.sql.Timestamp;
import java.util.UUID;

import org.springframework.beans.BeanUtils;

import br.com.posterius.acolyteapp.entities.Person;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class PersonDTO {
	private UUID id;
	private Integer code;
	private String firstName;
	private String lastName;
	private Timestamp dateBirth;
	
	public PersonDTO(Person entity) {
		BeanUtils.copyProperties(entity, this);
	}
}
