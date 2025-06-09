package br.com.posterius.acolyteapp.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.posterius.acolyteapp.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

}
