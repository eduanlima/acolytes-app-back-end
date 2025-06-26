package br.com.posterius.acolyteapp.entities;

import java.util.UUID;

import lombok.Data;

@Data
public class AcolytePosition {
	private UUID id;
	private Acolyte acolyte;
	private Position position;
}
