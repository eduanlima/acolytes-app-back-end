package br.com.posterius.acolyteapp.repositories.acolyte;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.posterius.acolyteapp.entities.acolyte.AcolytePosition;
import br.com.posterius.acolyteapp.entities.acolyte.AcolytePositionId;

@Repository
public interface AcolytePositionRepository extends JpaRepository<AcolytePosition, AcolytePositionId>{

}
