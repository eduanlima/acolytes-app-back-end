package br.com.posterius.acolyteapp.repositories.position;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.posterius.acolyteapp.entities.position.PositionEntity;

public interface PositionRepository extends JpaRepository<PositionEntity, UUID> {
	List<PositionEntity> findAllByIdIn(Collection<UUID> ids);
}
