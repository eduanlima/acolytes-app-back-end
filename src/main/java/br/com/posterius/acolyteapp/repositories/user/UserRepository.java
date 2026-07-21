package br.com.posterius.acolyteapp.repositories.user;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.posterius.acolyteapp.entities.user.UserEntity;
public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    Optional<UserEntity> findByLogin(String login);
}
