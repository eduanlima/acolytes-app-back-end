package br.com.posterius.acolyteapp.entities.acolyte;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import br.com.posterius.acolyteapp.entities.person.PersonEntity;
import br.com.posterius.acolyteapp.entities.position.Position;
import jakarta.persistence.CascadeType;
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
	@Column(nullable = false, updatable = false)
	private UUID id;
	@NotNull
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@MapsId
	@JoinColumn(name = "id")
	private PersonEntity person;
	@OneToMany(mappedBy = "acolyte", cascade = CascadeType.ALL)
	private List<AcolytePosition> acolytePositions = new ArrayList<>();
	
	public Acolyte() {
	}
	
	public Acolyte(@NotNull PersonEntity person, List<AcolytePosition> acolytePositions) {
		super();
		this.person = person;
		this.acolytePositions = acolytePositions;
	}

	public Acolyte(UUID id, @NotNull PersonEntity person) {
		this.id = id;
		this.person = person;
	}
	
	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public PersonEntity getPerson() {
		return person;
	}

	public void setPerson(PersonEntity person) {
		this.person = person;
	}

	public List<AcolytePosition> getAcolytePositions() {
		return acolytePositions;
	}
	
	public void setAcolytePositions(List<AcolytePosition> acolytePositions) {
		this.acolytePositions = acolytePositions;
	}

	public static Acolyte createFor(PersonEntity person) {
		Acolyte acolyte = new Acolyte();
		acolyte.setPerson(person);
		return acolyte;
	}
	
	//Helpers/ delegates
	public String getFirstName() {
		return person.getFirstName();
	}
	
	public void addPosition(Position position) {
		AcolytePosition acolytePosition = new AcolytePosition(this, position);
		this.acolytePositions.add(acolytePosition);
	}
}
