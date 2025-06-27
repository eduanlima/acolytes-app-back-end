package br.com.posterius.acolyteapp.entities;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class AcolytePosition {
	private UUID id;
	private Acolyte acolyte;
	private Position position;
}
