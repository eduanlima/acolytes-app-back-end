package br.com.posterius.acolyteapp.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import br.com.posterius.acolyteapp.controller.acolyte.AcolyteDTO;
import br.com.posterius.acolyteapp.controller.user.UserAcolyteResponseDTO;
import br.com.posterius.acolyteapp.controller.user.UserDTO;
import br.com.posterius.acolyteapp.entities.acolyte.AcolyteEntity;
import br.com.posterius.acolyteapp.entities.acolyte.AcolytePositionEntity;
import br.com.posterius.acolyteapp.entities.acolyte.AcolytePositionId;
import br.com.posterius.acolyteapp.entities.person.PersonEntity;
import br.com.posterius.acolyteapp.entities.position.Position;
import br.com.posterius.acolyteapp.entities.user.User;
import br.com.posterius.acolyteapp.entities.user.UserAcolyte;
import br.com.posterius.acolyteapp.entities.user.UserAcolyteId;
import br.com.posterius.acolyteapp.repositories.UserRepository;
import br.com.posterius.acolyteapp.repositories.acolyte.AcolyteRepository;
import br.com.posterius.acolyteapp.repositories.position.PositionRepository;

@Service 
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PositionRepository positionRepository;
	
	@Autowired
	private AcolyteRepository acolyteRepository;
	
	@Autowired
	private PersonService personService;
	
	public User validateUser(UUID userId) {
		return userRepository.findById(userId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}
	
	private void copyRecordToEntity(UserDTO userDTO, User user) {
		user.setLogin(userDTO.login());
		user.setPassword(userDTO.password());
		user.setIsBlocked(userDTO.isBlocked());
		user.setRole(userDTO.role());
	}
	
	@Transactional(readOnly = true)
	public List<UserDTO> findAll() {
		return userRepository.findAll().stream().map(e -> new UserDTO(e)).toList();
	}
	
	@Transactional(readOnly = true)
	public UserDTO findById(UUID id) {
		Optional<User> optional = userRepository.findById(id);
		User entity = optional.get();
		return new UserDTO(entity);
	}
	
	@Transactional(readOnly = true)
	public List<UserAcolyteResponseDTO> findAllAccountAcolyte(UUID id) {
		User user = userRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
		return user.getUserAcolytes().stream().map(a -> new UserAcolyteResponseDTO(a.getAcolyte().getPerson().getId(), a.getAcolyte().getPerson().getFirstName())).toList();
	}
	
	private User save(UserDTO userDto) {
		User user = new User();
		
		if (userDto.id() != null) {
			Optional<User> optionalUser = userRepository.findById(userDto.id());
			user = optionalUser != null ? optionalUser.get() : user;
		}

		PersonEntity person = personService.save(userDto.person());
		user.setPerson(person);
		
		copyRecordToEntity(userDto, user);
		user = userRepository.save(user);		
		return user;
	}
	
	public UserDTO create(UserDTO userDTO) {
		return new UserDTO(save(userDTO));
	}
	
	public UserDTO update(UUID id, UserDTO userDTO) {
		return new UserDTO(save(new UserDTO(id, userDTO)));
	}
	
	@Transactional
	public void createAcolyteByUser(UUID userId, AcolyteDTO acolyteDto) {
		User user = validateUser(userId);
		PersonEntity person = user.getPerson();
		
		List<Position> positions = positionRepository.findAllByIdIn(acolyteDto.positions().stream().map(p -> p.id()).toList());
		AcolyteEntity acolyte = new AcolyteEntity();
		acolyte.setPerson(person);
		acolyte = acolyteRepository.saveAndFlush(acolyte);
		
		for (Position position: positions) {
			AcolytePositionId acolytePositionId = new AcolytePositionId(person.getId(), position.getId());
			AcolytePositionEntity acolytePosition = new AcolytePositionEntity();
			acolytePosition.setId(acolytePositionId);
			acolytePosition.setAcolyte(acolyte);
			acolytePosition.setPosition(position);
			
	        acolyte.getAcolytePositions().add(acolytePosition);
		}
		
		acolyte = acolyteRepository.save(acolyte);
		
		UserAcolyteId userAcolyteId = new UserAcolyteId(user.getId(), acolyte.getId());
		UserAcolyte userAcolyte = new UserAcolyte(userAcolyteId, user, acolyte);
		
		user.getUserAcolytes().add(userAcolyte);
		userRepository.save(user);
	}
}
