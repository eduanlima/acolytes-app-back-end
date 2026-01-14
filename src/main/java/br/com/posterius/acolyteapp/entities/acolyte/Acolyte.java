package br.com.posterius.acolyteapp.entities.acolyte;

import java.util.Objects;
import java.util.UUID;

import br.com.posterius.acolyteapp.entities.person.Person;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_acolyte")
public class Acolyte {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(nullable = false, updatable = false)
	private UUID id;
	@OneToOne
	@JoinColumn(name = "person_id", referencedColumnName = "id")
	private Person person;
	
	public Acolyte() {
	}

	public Acolyte(UUID id, Person person) {
		this.id = id;
		this.person = person;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Acolyte other = (Acolyte) obj;
		return Objects.equals(id, other.id);
	}
}
