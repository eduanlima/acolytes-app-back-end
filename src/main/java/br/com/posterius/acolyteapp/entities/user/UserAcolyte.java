package br.com.posterius.acolyteapp.entities.user;

import br.com.posterius.acolyteapp.entities.acolyte.Acolyte;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_user_acolyte")
public class UserAcolyte {
	@EmbeddedId
	private UserAcolyteId id;
	@ManyToOne
	@MapsId("userId")
	@JoinColumn(name = "user_id")
	private User user;
	@ManyToOne
	@MapsId("acolyteId")
	@JoinColumn(name = "acolyte_id")
	private Acolyte acolyte;

	public UserAcolyteId getId() {
		return id;
	}

	public void setId(UserAcolyteId id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Acolyte getAcolyte() {
		return acolyte;
	}

	public void setAcolyte(Acolyte acolyte) {
		this.acolyte = acolyte;
	}	
}
