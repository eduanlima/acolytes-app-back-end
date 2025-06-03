package br.com.posterius.acolyteapp.entities;

import java.sql.Timestamp;
import java.util.UUID;

import lombok.Data;

@Data
public class Person {
	private UUID id;
	private Integer code;
	private String firstName;
	private String lastName;
	private Timestamp dateOfBirth;
}
