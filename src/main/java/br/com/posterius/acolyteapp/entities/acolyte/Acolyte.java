package br.com.posterius.acolyteapp.entities.acolyte;

import java.util.ArrayList;
import java.util.List;

import br.com.posterius.acolyteapp.entities.person.Person;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_acolyte")
@PrimaryKeyJoinColumn(name = "id")
public class Acolyte extends Person {
	@OneToMany(mappedBy = "acolyte")
	private List<AcolytePosition> acolytePositions = new ArrayList<>();
	
	public Acolyte() {
		super();
	}
	
	public List<AcolytePosition> getAcolytePositions() {
		return acolytePositions;
	}
}
