package br.com.posterius.acolyteapp.entities.user;

import br.com.posterius.acolyteapp.entities.acolyte.AcolyteEntity;
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
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("acolyteId")
    @JoinColumn(name = "acolyte_id", nullable = false)
    private AcolyteEntity acolyte;

    protected UserAcolyte() {
    }

    public UserAcolyte(UserAcolyteId id, UserEntity user, AcolyteEntity acolyte) {
		this.id = id;
		this.user = user;
		this.acolyte = acolyte;
	}
    
	public UserAcolyte(UserEntity user, AcolyteEntity acolyte) {
		this.user = user;
		this.acolyte = acolyte;
	}

	public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public AcolyteEntity getAcolyte() {
        return acolyte;
    }

    public void setAcolyte(AcolyteEntity acolyte) {
        this.acolyte = acolyte;
    }
}