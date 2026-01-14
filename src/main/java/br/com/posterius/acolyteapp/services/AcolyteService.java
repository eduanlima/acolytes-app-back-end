package br.com.posterius.acolyteapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.posterius.acolyteapp.dto.acolyte.AcolytePositionDTO;
import br.com.posterius.acolyteapp.dto.acolyte.AcolyteResponseDTO;
import br.com.posterius.acolyteapp.repositories.AcolyteRepository;

@Service
public class AcolyteService {
	@Autowired
	private AcolyteRepository acolyteRepository;

	public List<AcolyteResponseDTO> findAll() {
		return acolyteRepository.findAll().stream()
				.map(a -> new AcolyteResponseDTO(a.getId(), a.getFirstName(),
						a.getAcolytePositions().stream()
								.map(p -> new AcolytePositionDTO(p.getPosition().getId(), p.getPosition().getCode(),
										p.getPosition().getName(), p.getPosition().getDescription()))
								.toList()))
				.toList();
	}
}
