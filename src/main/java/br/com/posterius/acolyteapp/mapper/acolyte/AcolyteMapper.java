package br.com.posterius.acolyteapp.mapper.acolyte;

import org.springframework.stereotype.Component;

import br.com.posterius.acolyteapp.controller.acolyte.AcolyteDTO;
import br.com.posterius.acolyteapp.entities.acolyte.AcolyteEntity;

@Component
public class AcolyteMapper {
	public AcolyteEntity toEntity(AcolyteDTO acolyteDto) {
		AcolyteEntity acolyte = new AcolyteEntity();
		acolyte.setId(acolyteDto.id());
		acolyte.setPerson(null);
		acolyte.setAcolytePositions(null);
		return new AcolyteEntity(); 
	}
}
