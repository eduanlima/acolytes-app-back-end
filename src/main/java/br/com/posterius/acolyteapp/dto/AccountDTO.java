package br.com.posterius.acolyteapp.dto;
import java.util.UUID;

import br.com.posterius.acolyteapp.entities.account.Account;

public class AccountDTO {
	private UUID id;
	private String login;
	private String password;
	private Boolean isBlocked;
	private Boolean isActivated;
	private String firstName;
	private Integer role;
	
	public AccountDTO(Account entity) {
		this.id = entity.getId();
		this.login = entity.getLogin();
		this.password = entity.getPassword();
		this.isBlocked = entity.getIsBlocked();
		this.isActivated = entity.getIsActivated();
		this.firstName = entity.getPerson().getFirstName();
		this.role = entity.getRole();
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getIsBlocked() {
		return isBlocked;
	}

	public void setIsBlocked(Boolean isBlocked) {
		this.isBlocked = isBlocked;
	}

	public Boolean getIsActivated() {
		return isActivated;
	}

	public void setIsActivated(Boolean isActivated) {
		this.isActivated = isActivated;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}
}
