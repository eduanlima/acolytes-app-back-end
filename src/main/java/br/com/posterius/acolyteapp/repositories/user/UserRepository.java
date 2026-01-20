package br.com.posterius.acolyteapp.repositories.user;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.posterius.acolyteapp.entities.user.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {
	
}
