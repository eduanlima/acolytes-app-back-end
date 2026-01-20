package br.com.posterius.acolyteapp.controller.acolyte;

import java.util.List;
import java.util.UUID;

import br.com.posterius.acolyteapp.controller.person.PersonRequestDTO;
import br.com.posterius.acolyteapp.controller.position.PositionDTO;

public record AcolyteDTO(UUID id, List<PositionDTO> positions, PersonRequestDTO person, UUID creatorId) {
	public AcolyteDTO(UUID id, AcolyteDTO acolyteRequestDTO) {
		this (id, acolyteRequestDTO.positions(), acolyteRequestDTO.person(), acolyteRequestDTO.creatorId());
	}
}
