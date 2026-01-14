package br.com.posterius.acolyteapp.entities.acolyte;

import br.com.posterius.acolyteapp.entities.position.Position;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_acolyte_position")
public class AcolytePosition {
	@EmbeddedId
	private AcolytePositionId id;
	@ManyToOne
	@MapsId("acolyteId")
	@JoinColumn(name = "acolyte_id")
	private Acolyte acolyte;
	@ManyToOne
	@MapsId("positionId")
	@JoinColumn(name = "position_id")
	private Position position;
	
	public AcolytePosition() {
	}

	public AcolytePositionId getId() {
		return id;
	}

	public void setId(AcolytePositionId id) {
		this.id = id;
	}

	public Acolyte getAcolyte() {
		return acolyte;
	}

	public void setAcolyte(Acolyte acolyte) {
		this.acolyte = acolyte;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}
}
