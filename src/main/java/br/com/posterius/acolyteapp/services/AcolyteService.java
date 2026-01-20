package br.com.posterius.acolyteapp.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import br.com.posterius.acolyteapp.controller.acolyte.AcolyteDTO;
import br.com.posterius.acolyteapp.controller.person.PersonDTO;
import br.com.posterius.acolyteapp.controller.position.PositionDTO;
import br.com.posterius.acolyteapp.entities.acolyte.AcolyteEntity;
import br.com.posterius.acolyteapp.entities.acolyte.AcolytePositionEntity;
import br.com.posterius.acolyteapp.entities.acolyte.AcolytePositionId;
import br.com.posterius.acolyteapp.entities.person.PersonEntity;
import br.com.posterius.acolyteapp.entities.position.PositionEntity;
import br.com.posterius.acolyteapp.entities.user.UserEntity;
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
	
	public AcolyteEntity validateAcolyte(UUID acolyteId) {
		return acolyteRepository.findById(acolyteId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	public List<AcolyteDTO> findAll() {
		return acolyteRepository.findAllNotDeleted().stream()
				.map(a -> new AcolyteDTO(a.getId(),
						a.getAcolytePositions().stream()
								.map(p -> new PositionDTO(p.getPosition()))
								.toList(), new PersonDTO(a.getPerson()), null))
				.toList();
	}
	
	public AcolyteDTO findById(UUID acolyteId) {
		AcolyteEntity acolyte = acolyteRepository.findById(acolyteId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		
		if (acolyte.getPerson().getDeleted())
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		
		AcolyteDTO acolyteDTO = new AcolyteDTO(acolyte.getId(), acolyte.getAcolytePositions().stream().map(p -> new PositionDTO(p.getPosition())).toList(), new PersonDTO(acolyte.getPerson()), null);
		return acolyteDTO;
	}
	
	@Transactional
	private AcolyteEntity save(UserEntity user, AcolyteDTO acolyteDto) {
		AcolyteEntity acolyte = new AcolyteEntity();
		
		if (acolyteDto.id() != null) {
			Optional<AcolyteEntity> optionalAcolyte = acolyteRepository.findById(acolyteDto.id());
			acolyte = optionalAcolyte != null ? optionalAcolyte.get() : acolyte;
		}
		
		if (acolyte.getId() != null)
			acolyte.setAcolytePositions(new ArrayList<>());

		PersonEntity person = personService.save(acolyteDto.person());
		acolyte.setPerson(person);
		
		acolyte = acolyteRepository.saveAndFlush(acolyte);
		
		List<PositionEntity> positions = positionRepository.findAllByIdIn(acolyteDto.positions().stream().map(p -> p.id()).toList());
		
		for (PositionEntity position: positions) {
			AcolytePositionId acolytePositionId = new AcolytePositionId(person.getId(), position.getId());
			AcolytePositionEntity acolytePosition = new AcolytePositionEntity();
			acolytePosition.setId(acolytePositionId);
			acolytePosition.setAcolyte(acolyte);
			acolytePosition.setPosition(position);
	        acolyte.getAcolytePositions().add(acolytePosition);
		}
		
		acolyte = acolyteRepository.save(acolyte);		
		return acolyte;
	}
	
	public AcolyteDTO save(AcolyteDTO acolyteDto) {
		UserEntity user = userService.validateUser(acolyteDto.creatorId());		
		AcolyteEntity acolyte = save(user, acolyteDto);
		acolyteDto = new AcolyteDTO(acolyte.getId(), acolyte.getAcolytePositions().stream().map(p -> new PositionDTO(p.getPosition())).toList(), new PersonDTO(acolyte.getPerson()), null);
		return acolyteDto;
	}
	
	public AcolyteDTO create(AcolyteDTO acolyteDto) {
		return save(acolyteDto);
	}
	
	public AcolyteDTO update(UUID acolyteId, AcolyteDTO acolyteDto) {
		return save(new AcolyteDTO(acolyteId, acolyteDto));
	}
	
	public void delete(UUID acolyteId) {
		AcolyteEntity acolyte = validateAcolyte(acolyteId);
		personService.delete(acolyte.getPerson().getId());
	}
}
