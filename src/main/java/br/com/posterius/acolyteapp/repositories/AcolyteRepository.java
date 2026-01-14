package br.com.posterius.acolyteapp.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.posterius.acolyteapp.entities.acolyte.Acolyte;

public interface AcolyteRepository extends JpaRepository<Acolyte, UUID> {

}
