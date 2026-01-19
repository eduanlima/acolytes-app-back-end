package br.com.posterius.acolyteapp.controller.acolyte;

import java.util.List;
import java.util.UUID;

import br.com.posterius.acolyteapp.controller.person.PersonRequestDTO;
import br.com.posterius.acolyteapp.controller.position.PositionDTO;

public record AcolyteResponseDTO(UUID id, PersonRequestDTO person, List<PositionDTO> positions) {

}
