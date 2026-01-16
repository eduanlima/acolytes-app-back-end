package br.com.posterius.acolyteapp.repositories.position;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<PositionRepository, UUID> {

}
