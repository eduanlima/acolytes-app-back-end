package br.com.posterius.acolyteapp.dto;
import java.util.UUID;

import org.springframework.beans.BeanUtils;

import br.com.posterius.acolyteapp.entities.Account;
import br.com.posterius.acolyteapp.entities.Person;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class AccountDTO {
	private UUID id;
	private String login;
	private String password;
	private String firstName;
	
	public AccountDTO(Account entity) {
		id = entity.getId();
		login = entity.getLogin();
		password = entity.getPassword();
		firstName = entity.getPerson().getFirstName();
	}
}
