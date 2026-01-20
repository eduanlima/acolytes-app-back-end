package br.com.posterius.acolyteapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.posterius.acolyteapp.controller.position.PositionDTO;
import br.com.posterius.acolyteapp.repositories.position.PositionRepository;

@Service
public class PositionService {
	@Autowired
	private PositionRepository positionRepository;
	
	public List<PositionDTO> findAll() {
		return positionRepository.findAll().stream().map(p -> new PositionDTO(p)).toList();
	}
}
