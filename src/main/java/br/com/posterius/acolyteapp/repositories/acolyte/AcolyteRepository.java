package br.com.posterius.acolyteapp.repositories.acolyte;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.posterius.acolyteapp.entities.acolyte.Acolyte;

@Repository
public interface AcolyteRepository extends JpaRepository<Acolyte, UUID> {
	@Query("SELECT acolyte FROM Acolyte acolyte WHERE acolyte.person.deleted = false")
	List<Acolyte> findAllNotDeleted();
}
