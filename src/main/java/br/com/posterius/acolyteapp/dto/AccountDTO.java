package br.com.posterius.acolyteapp.dto;
import java.util.UUID;

import br.com.posterius.acolyteapp.entities.Account;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
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
}
