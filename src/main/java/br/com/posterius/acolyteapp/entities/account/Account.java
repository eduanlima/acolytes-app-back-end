package br.com.posterius.acolyteapp.entities.account;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import br.com.posterius.acolyteapp.entities.person.Person;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tb_account")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(nullable = false, updatable = false)
	private UUID id;
	@NotNull
	private String login;
	@NotNull
	private String password;
	@NotNull
	@OneToOne
	@JoinColumn(name = "person_id", referencedColumnName = "id")
	private Person person;
	@NotNull
	private Boolean isBlocked;
	@NotNull
	private Boolean isActivated;
	private Integer role;
	@OneToMany(mappedBy = "account")
	private List<AccountAcolyte> accountAcolyte = new ArrayList<>();
	
	@Transient
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public Account() {
	}
	
	public Account(UUID id, @NotNull String login, @NotNull String password, @NotNull Person person,
			@NotNull Boolean isBlocked, @NotNull Boolean isActivated, Integer role) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.person = person;
		this.isBlocked = isBlocked;
		this.isActivated = isActivated;
		this.role = role;
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

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
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

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public BCryptPasswordEncoder getbCryptPasswordEncoder() {
		return bCryptPasswordEncoder;
	}

	public void setbCryptPasswordEncoder(BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	public List<AccountAcolyte> getAccountAcolyte() {
		return accountAcolyte;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return Objects.equals(id, other.id);
	}

	public boolean validatePassword() {		
		if (password.length() < 8) 
			return false;
		
		boolean hasNumber = false, hasSpecialChar =  false, hasUpperCase = false;
		
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
	
	public void encryptPassword(){
		password = bCryptPasswordEncoder.encode(password);
	}
	
	public boolean passwordIsCorrect(String password) {
		return bCryptPasswordEncoder.matches(password, this.password);
	}
}
