package br.com.posterius.acolyteapp.entities.user;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class UserAcolyteId {
	@Column(name = "user_id")
	private UUID userId;
	@Column(name = "acolyte_id")
	private UUID acolyteId;
	
	public UserAcolyteId() {
	}

	public UserAcolyteId(UUID accountId, UUID acolyteId) {
		this.userId = accountId;
		this.acolyteId = acolyteId;
	}

	public UUID getUserId() {
		return userId;
	}

	public void setUserId(UUID userId) {
		this.userId = userId;
	}

	public UUID getAcolyteId() {
		return acolyteId;
	}

	public void setAcolyteId(UUID acolyteId) {
		this.acolyteId = acolyteId;
	}
}
