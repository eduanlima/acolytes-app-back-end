package br.com.posterius.acolyteapp.entities;

import java.sql.Timestamp;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "person")
public class Person {
	@Id
	@GeneratedValue(generator = "UUID")
	private UUID id;
	private Integer code;
	private String firstName;
	private String lastName;
	private Timestamp dateBirth;
}
