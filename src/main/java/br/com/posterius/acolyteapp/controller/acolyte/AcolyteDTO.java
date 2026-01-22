package br.com.posterius.acolyteapp.controller.acolyte;

import java.util.List;
import java.util.UUID;

import br.com.posterius.acolyteapp.controller.person.PersonDTO;
import br.com.posterius.acolyteapp.controller.position.PositionDTO;

public record AcolyteDTO(UUID id, List<PositionDTO> positions, PersonDTO person, UUID creatorId) {
	public AcolyteDTO(UUID id, AcolyteDTO acolyteRequestDTO) {
		this (id, acolyteRequestDTO.positions(), acolyteRequestDTO.person(), acolyteRequestDTO.creatorId());
	}
	
	public AcolyteDTO(AcolyteDTO acolyteRequestDTO, PersonDTO person) {
		this (acolyteRequestDTO.id(), acolyteRequestDTO.positions(), person, acolyteRequestDTO.creatorId());
	}
}
