package br.com.posterius.acolyteapp.entities;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@AllArgsConstructor
@Data
public class AcolytePosition {
	@EqualsAndHashCode.Include
	private UUID id;
	private Acolyte acolyte;
	private Position position;
}
