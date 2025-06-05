package br.com.posterius.acolyteapp.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.posterius.acolyteapp.entities.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, UUID> {
	@Query("SELECT MAX(p.code) FROM person p")
	Integer findMaxCode();
}
