package br.com.posterius.acolyteapp.repositories.acolyte;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.posterius.acolyteapp.entities.acolyte.AcolytePosition;
import br.com.posterius.acolyteapp.entities.acolyte.AcolytePositionId;

public interface AcolytePositionRepository extends JpaRepository<AcolytePosition, AcolytePositionId>{

}
