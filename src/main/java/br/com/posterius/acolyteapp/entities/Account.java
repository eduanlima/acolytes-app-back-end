package br.com.posterius.acolyteapp.entities;

import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "account")
public class Account {
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(generator = "UUID")
	private UUID id;
	@NotNull
	private String login;
	@NotNull
	private String password;
	@NotNull
	@OneToOne
	@JoinColumn(name = "person_id", referencedColumnName = "id")
	private Person person;
	@NotNull
	private Boolean isBlocked;
	@NotNull
	private Boolean isActivated;
}
