package br.com.posterius.acolyteapp.repositories.user;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.posterius.acolyteapp.entities.user.UserAcolyte;
import br.com.posterius.acolyteapp.entities.user.UserAcolyteId;

public interface UserAcolyteRepository extends JpaRepository<UserAcolyte, UserAcolyteId>{

}
