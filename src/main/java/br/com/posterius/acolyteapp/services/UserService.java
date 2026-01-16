package br.com.posterius.acolyteapp.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import br.com.posterius.acolyteapp.controller.acolyte.AcolytePositionRequestDTO;
import br.com.posterius.acolyteapp.controller.user.UserAcolyteResponseDTO;
import br.com.posterius.acolyteapp.controller.user.UserDTO;
import br.com.posterius.acolyteapp.entities.user.User;
import br.com.posterius.acolyteapp.repositories.UserRepository;
import br.com.posterius.acolyteapp.repositories.acolyte.AcolytePositionRepository;
import br.com.posterius.acolyteapp.repositories.acolyte.AcolyteRepository;
import br.com.posterius.acolyteapp.repositories.position.PositionRepository;

@Service 
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AcolyteRepository acolyteRepository;
	
	@Autowired
	private PositionRepository positionRepository;
	
	@Autowired
	private AcolytePositionRepository acolytePositionRepository;
	
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
	
	public void createAcolyteByUser(UUID userId, AcolytePositionRequestDTO acolyteDto) {
		
	}
}
