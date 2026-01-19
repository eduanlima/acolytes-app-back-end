package br.com.posterius.acolyteapp.controller.position;

import java.util.UUID;

import br.com.posterius.acolyteapp.entities.position.Position;

public record PositionDTO(UUID id, Integer code, String name, String description) {
	public PositionDTO(Position position) {
		this(position.getId(), position.getCode(), position.getName(), position.getDescription());
	}
}
