package br.com.posterius.acolyteapp.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_account_acolyte")
public class AccountAcolyte {
	@EmbeddedId
	private AccountAcolyteId id;
	@ManyToOne
	@MapsId("accountId")
	@JoinColumn(name = "account_id")
	private Account account;
	@ManyToOne
	@MapsId("acolyteId")
	@JoinColumn(name = "acolyte_id")
	private Acolyte acolyte;

	public AccountAcolyteId getId() {
		return id;
	}

	public void setId(AccountAcolyteId id) {
		this.id = id;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Acolyte getAcolyte() {
		return acolyte;
	}

	public void setAcolyte(Acolyte acolyte) {
		this.acolyte = acolyte;
	}
}
