package br.com.posterius.acolyteapp.controller.acolyte;

import java.util.List;
import java.util.UUID;

public record AcolyteRequestDTO(UUID acolyteId, List<AcolytePositionRequestDTO> positionsId) {

}
