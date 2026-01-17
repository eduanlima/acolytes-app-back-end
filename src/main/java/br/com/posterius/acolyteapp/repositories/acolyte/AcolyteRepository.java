package br.com.posterius.acolyteapp.repositories.acolyte;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.posterius.acolyteapp.entities.acolyte.Acolyte;

@Repository
public interface AcolyteRepository extends JpaRepository<Acolyte, UUID> {

}
