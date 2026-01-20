package br.com.posterius.acolyteapp.controller.user;

import java.util.UUID;

import br.com.posterius.acolyteapp.controller.person.PersonDTO;
import br.com.posterius.acolyteapp.entities.user.User;

public record UserDTO(UUID id, String login, String password, Boolean isBlocked, Integer role, PersonDTO person) {
	public UserDTO(UUID id, UserDTO user) {
		this(id, user.login(), user.password(), user.isBlocked(), user.role(), user.person());
	}
	
	public UserDTO(User user) {
		this(user.getId(), user.getLogin(), user.getPassword(), user.getIsBlocked(), user.getRole(), new PersonDTO(user.getPerson()));
	}
}
