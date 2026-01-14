package br.com.posterius.acolyteapp.dto.acolyte;

import java.util.List;
import java.util.UUID;

public record AcolyteResponseDTO(UUID id, String firstName, List<AcolytePositionDTO> positions) {

}
