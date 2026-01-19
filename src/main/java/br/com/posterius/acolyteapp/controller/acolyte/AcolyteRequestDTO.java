package br.com.posterius.acolyteapp.controller.acolyte;

import java.util.List;
import java.util.UUID;

import br.com.posterius.acolyteapp.controller.person.PersonRequestDTO;

public record AcolyteRequestDTO(UUID acolyteId, List<AcolytePositionRequestDTO> positionsId, PersonRequestDTO personDto, UUID creatorId) {

}
