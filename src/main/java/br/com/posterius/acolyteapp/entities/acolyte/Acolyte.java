package br.com.posterius.acolyteapp.entities.acolyte;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import br.com.posterius.acolyteapp.entities.person.Person;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tb_acolyte")
public class Acolyte {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(nullable = false, updatable = false)
	private UUID id;
	@NotNull
	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	@JoinColumn(name = "id")
	private Person person;
	@OneToMany(mappedBy = "acolyte")
	private List<AcolytePosition> acolytePositions = new ArrayList<>();
	
	public Acolyte() {
	}
	
	public Acolyte(UUID id, @NotNull Person person) {
		this.id = id;
		this.person = person;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public List<AcolytePosition> getAcolytePositions() {
		return acolytePositions;
	}
	
	public static Acolyte createFor(Person person) {
		Acolyte acolyte = new Acolyte();
		acolyte.setPerson(person);
		return acolyte;
	}
	
	//Helpers/ delegates
	public String getFirstName() {
		return person.getFirstName();
	}
}
