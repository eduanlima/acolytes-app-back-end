package br.com.posterius.acolyteapp.controller.position;

import java.util.UUID;

public record PositionDTO(UUID id, Integer code, String name, String description) {

}
