package br.com.posterius.acolyteapp.repositories.position;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.posterius.acolyteapp.entities.position.Position;

@Repository
public interface PositionRepository extends JpaRepository<Position, UUID> {
	List<Position> findAllByIdIn(Collection<UUID> ids);
}
