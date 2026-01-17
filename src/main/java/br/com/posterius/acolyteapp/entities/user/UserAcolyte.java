package br.com.posterius.acolyteapp.entities.user;

import br.com.posterius.acolyteapp.entities.acolyte.Acolyte;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_user_acolyte")
public class UserAcolyte {
    @EmbeddedId
    private UserAcolyteId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("userId")
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("acolyteId")
    @JoinColumn(name = "acolyte_id", nullable = false)
    private Acolyte acolyte;

    protected UserAcolyte() {
    }

    public UserAcolyte(UserAcolyteId id, User user, Acolyte acolyte) {
		this.id = id;
		this.user = user;
		this.acolyte = acolyte;
	}
    
	public UserAcolyte(User user, Acolyte acolyte) {
		this.user = user;
		this.acolyte = acolyte;
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