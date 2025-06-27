package br.com.posterius.acolyteapp.entities;

import java.util.UUID;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Position {
	private UUID id;
	private Integer code;
	private String name;
	private String description;
}
