package br.com.posterius.acolyteapp.entities.user;

import java.util.Objects;
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

	@Override
	public int hashCode() {
		return Objects.hash(acolyteId, userId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserAcolyteId other = (UserAcolyteId) obj;
		return Objects.equals(acolyteId, other.acolyteId) && Objects.equals(userId, other.userId);
	}
}
