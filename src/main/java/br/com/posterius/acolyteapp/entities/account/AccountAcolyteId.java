package br.com.posterius.acolyteapp.entities.account;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class AccountAcolyteId {
	@Column(name = "account_id")
	private UUID accountId;
	@Column(name = "acolyte_id")
	private UUID acolyteId;
	
	public AccountAcolyteId() {
	}

	public AccountAcolyteId(UUID accountId, UUID acolyteId) {
		this.accountId = accountId;
		this.acolyteId = acolyteId;
	}

	public UUID getAccountId() {
		return accountId;
	}

	public void setAccountId(UUID accountId) {
		this.accountId = accountId;
	}

	public UUID getAcolyteId() {
		return acolyteId;
	}

	public void setAcolyteId(UUID acolyteId) {
		this.acolyteId = acolyteId;
	}
}
