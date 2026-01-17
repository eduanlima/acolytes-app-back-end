package br.com.posterius.acolyteapp.entities.acolyte;

import java.io.Serializable;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class AcolytePositionId implements Serializable {
	private static final long serialVersionUID = 1L;
	private UUID acolyteId;
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
