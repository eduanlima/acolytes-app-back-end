package br.com.posterius.acolyteapp.entities.acolyte;

import br.com.posterius.acolyteapp.entities.position.PositionEntity;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_acolyte_position")
public class AcolytePositionEntity {
	@EmbeddedId
	private AcolytePositionId id;
	@ManyToOne
	@MapsId("acolyteId")
	@JoinColumn(name = "acolyte_id", nullable = false)
	private AcolyteEntity acolyte;
	@ManyToOne
	@MapsId("positionId")
	@JoinColumn(name = "position_id", nullable = false)
	private PositionEntity position;
	
	public AcolytePositionEntity() {
	}
	
	public AcolytePositionEntity(AcolyteEntity acolyte, PositionEntity position) {
		this.acolyte = acolyte;
		this.position = position;
	}

	public AcolytePositionId getId() {
		return id;
	}

	public void setId(AcolytePositionId id) {
		this.id = id;
	}

	public AcolyteEntity getAcolyte() {
		return acolyte;
	}

	public void setAcolyte(AcolyteEntity acolyte) {
		this.acolyte = acolyte;
	}

	public PositionEntity getPosition() {
		return position;
	}

	public void setPosition(PositionEntity position) {
		this.position = position;
	}
}
