package br.com.posterius.acolyteapp.entities;

import java.sql.Timestamp;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
	@GeneratedValue(generator = "UUID")
	private UUID id;
	@NotNull
	private Integer code;
	@NotNull
	@NotBlank
	private String firstName;
	@NotNull
	@NotBlank
	private String lastName;
	@NotNull
	private Timestamp dateBirth;
	private Boolean isActive;
}
