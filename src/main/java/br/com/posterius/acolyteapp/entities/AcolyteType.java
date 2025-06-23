package br.com.posterius.acolyteapp.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum AcolyteType {
	ACOLYTE_ONE("ACOLYTE_ONE"),
	ACOLYTE_TWO("ACOLYTE_TWO");
	
	@Getter
	private String description;	
}
