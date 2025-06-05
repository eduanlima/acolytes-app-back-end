package br.com.posterius.acolyteapp.entities;

import java.sql.Timestamp;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "person")
public class Person {
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(generator = "UUID", strategy = GenerationType.UUID)
	private UUID id;
	private Integer code;
	private String firstName;
	private String lastName;
	private Timestamp dateBirth;
}
