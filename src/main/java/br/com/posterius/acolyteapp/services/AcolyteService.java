package br.com.posterius.acolyteapp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.posterius.acolyteapp.controller.acolyte.AcolyteRequestDTO;
import br.com.posterius.acolyteapp.controller.acolyte.AcolyteResponseDTO;
import br.com.posterius.acolyteapp.controller.person.PersonRequestDTO;
import br.com.posterius.acolyteapp.controller.position.PositionDTO;
import br.com.posterius.acolyteapp.entities.acolyte.Acolyte;
import br.com.posterius.acolyteapp.entities.acolyte.AcolytePosition;
import br.com.posterius.acolyteapp.entities.acolyte.AcolytePositionId;
import br.com.posterius.acolyteapp.entities.person.PersonEntity;
import br.com.posterius.acolyteapp.entities.position.Position;
import br.com.posterius.acolyteapp.entities.user.User;
import br.com.posterius.acolyteapp.repositories.acolyte.AcolyteRepository;
import br.com.posterius.acolyteapp.repositories.position.PositionRepository;

@Service
public class AcolyteService {
	@Autowired
	private AcolyteRepository acolyteRepository;
	
	@Autowired
	private PositionRepository positionRepository;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PersonService personService;
	
	public List<AcolyteResponseDTO> findAll() {
		return acolyteRepository.findAll().stream()
				.map(a -> new AcolyteResponseDTO(a.getId(), new PersonRequestDTO(a.getPerson()),
						a.getAcolytePositions().stream()
								.map(p -> new PositionDTO(p.getPosition().getId(), p.getPosition().getCode(),
										p.getPosition().getName(), p.getPosition().getDescription()))
								.toList()))
				.toList();
	}
	
	@Transactional
	private Acolyte saveAcolyte(User user, AcolyteRequestDTO acolyteDto) {
		Acolyte acolyte = new Acolyte();
		
		if (acolyteDto.acolyteId() != null) {
			Optional<Acolyte> optionalAcolyte = acolyteRepository.findById(acolyteDto.acolyteId());
			acolyte = optionalAcolyte != null ? optionalAcolyte.get() : acolyte;
		}
		
		if (acolyte.getId() != null)
			acolyte.setAcolytePositions(new ArrayList<>());

		PersonEntity person = personService.save(acolyteDto.personDto());
		acolyte.setPerson(person);
		
		acolyte = acolyteRepository.saveAndFlush(acolyte);
		
		List<Position> positions = positionRepository.findAllByIdIn(acolyteDto.positionsId().stream().map(p -> p.positionId()).toList());
		
		for (Position position: positions) {
			AcolytePositionId acolytePositionId = new AcolytePositionId(person.getId(), position.getId());
			AcolytePosition acolytePosition = new AcolytePosition();
			acolytePosition.setId(acolytePositionId);
			acolytePosition.setAcolyte(acolyte);
			acolytePosition.setPosition(position);
	        acolyte.getAcolytePositions().add(acolytePosition);
		}
		
		acolyte = acolyteRepository.save(acolyte);		
		return acolyte;
	}
	
	public AcolyteResponseDTO saveAcolyte(AcolyteRequestDTO acolyteDto) {
		User user = userService.validateUser(acolyteDto.creatorId());
		Acolyte acolyte = saveAcolyte(user, acolyteDto);
		AcolyteResponseDTO acolyteResponseDTO = new AcolyteResponseDTO(acolyte.getId(), new PersonRequestDTO(acolyte.getPerson()), acolyte.getAcolytePositions().stream().map(p -> new PositionDTO(p.getPosition())).toList());
		return acolyteResponseDTO;
	}
}
