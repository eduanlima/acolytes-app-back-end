package br.com.posterius.acolyteapp.repositories.person;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.posterius.acolyteapp.entities.person.PersonEntity;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, UUID> {
	@Query("SELECT MAX(p.code) AS code FROM PersonEntity p")
	Integer findMaxCode();
	
	Optional<PersonEntity> findByIdAndDeletedFalse(UUID personId);
}
