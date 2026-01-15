package br.com.posterius.acolyteapp.entities.user;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import br.com.posterius.acolyteapp.entities.person.Person;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tb_user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(nullable = false, updatable = false)
	private UUID id;
	@NotNull
	private String login;
	@NotNull
	private String password;
	@NotNull
	private Boolean isBlocked;
	private Integer role;
	@NotNull
	@OneToOne(fetch = FetchType.LAZY)
	@MapsId
	@JoinColumn(name = "id")
	private Person person;
	@OneToMany(mappedBy = "user")
	private List<UserAcolyte> userAcolytes = new ArrayList<>();
	
	public User() {
	}

	public User(UUID id, @NotNull String login, @NotNull String password, @NotNull Boolean isBlocked, Integer role,
			@NotNull Person person, List<UserAcolyte> userAcolytes) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.isBlocked = isBlocked;
		this.role = role;
		this.person = person;
		this.userAcolytes = userAcolytes;
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

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public List<UserAcolyte> getUserAcolytes() {
		return userAcolytes;
	}

	public void setUserAcolytes(List<UserAcolyte> userAcolytes) {
		this.userAcolytes = userAcolytes;
	}

	public boolean validatePassword() {
		if (password.length() < 8)
			return false;

		boolean hasNumber = false, hasSpecialChar = false, hasUpperCase = false;

		for (char c : password.toCharArray()) {
			if (Character.isLetterOrDigit(c)) {
				if (Character.isLetter(c) && Character.isUpperCase(c))
					hasUpperCase = true;

				if (Character.isDigit(c))
					hasNumber = true;
			}

			if (!Character.isLetterOrDigit(c))
				hasSpecialChar = true;
		}

		return hasNumber && hasSpecialChar && hasUpperCase;
	}
}
