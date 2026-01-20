package br.com.posterius.acolyteapp.entities.acolyte;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import br.com.posterius.acolyteapp.entities.person.PersonEntity;
import br.com.posterius.acolyteapp.entities.position.PositionEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tb_acolyte")
public class AcolyteEntity {
	@Id
	@Column(nullable = false, updatable = false)
	private UUID id;
	@NotNull
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@MapsId
	@JoinColumn(name = "id")
	private PersonEntity person;
	@OneToMany(mappedBy = "acolyte", cascade = CascadeType.ALL)
	private List<AcolytePositionEntity> acolytePositions = new ArrayList<>();
	
	public AcolyteEntity() {
	}
	
	public AcolyteEntity(@NotNull PersonEntity person, List<AcolytePositionEntity> acolytePositions) {
		super();
		this.person = person;
		this.acolytePositions = acolytePositions;
	}

	public AcolyteEntity(UUID id, @NotNull PersonEntity person) {
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

	public List<AcolytePositionEntity> getAcolytePositions() {
		return acolytePositions;
	}
	
	public void setAcolytePositions(List<AcolytePositionEntity> acolytePositions) {
		this.acolytePositions = acolytePositions;
	}

	public static AcolyteEntity createFor(PersonEntity person) {
		AcolyteEntity acolyte = new AcolyteEntity();
		acolyte.setPerson(person);
		return acolyte;
	}
	
	//Helpers/ delegates
	public String getFirstName() {
		return person.getFirstName();
	}
	
	public void addPosition(PositionEntity position) {
		AcolytePositionEntity acolytePosition = new AcolytePositionEntity(this, position);
		this.acolytePositions.add(acolytePosition);
	}
}
