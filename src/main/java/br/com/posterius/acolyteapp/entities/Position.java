package br.com.posterius.acolyteapp.entities;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Position {
	@EqualsAndHashCode.Include
	private UUID id;
	private Integer code;
	private String name;
	private String description;
}
