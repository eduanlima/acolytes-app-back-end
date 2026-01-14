package br.com.posterius.acolyteapp.entities.acolyte;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class AcolytePositionId {
	@Column(name = "acolyte_id")
	private UUID acolyteId;
	@Column(name = "position_id")
	private UUID positionId;
	
	public AcolytePositionId() {
	}

	public AcolytePositionId(UUID acolyteId, UUID positionId) {
		this.acolyteId = acolyteId;
		this.positionId = positionId;
	}

	public UUID getAcolyteId() {
		return acolyteId;
	}

	public void setAcolyteId(UUID acolyteId) {
		this.acolyteId = acolyteId;
	}

	public UUID getPositionId() {
		return positionId;
	}

	public void setPositionId(UUID positionId) {
		this.positionId = positionId;
	}
}
