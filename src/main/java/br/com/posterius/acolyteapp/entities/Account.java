package br.com.posterius.acolyteapp.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "tb_account")
public class Account {
	@EqualsAndHashCode.Include
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
