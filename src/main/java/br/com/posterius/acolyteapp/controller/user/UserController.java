package br.com.posterius.acolyteapp.controller.user;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.posterius.acolyteapp.controller.acolyte.AcolyteRequestDTO;
import br.com.posterius.acolyteapp.services.UserService;

@RestController	
@RequestMapping(value = "/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping
	public List<UserDTO> finAll() {
		return userService.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> findById(@PathVariable UUID id) {
		UserDTO dto = userService.findById(id);
		return ResponseEntity.ok(dto);
	}
	
	@GetMapping("/{idUser}/acolytes")
	public ResponseEntity<List<UserAcolyteResponseDTO>> findAllAccountAcolyte(@PathVariable UUID idUser){
		var acolytes = userService.findAllAccountAcolyte(idUser);
		return ResponseEntity.ok(acolytes);
	}
	
	@PostMapping("/{userId}/acolyte")
	public ResponseEntity<Void> createAcolyteByUser(@PathVariable UUID userId, @RequestBody AcolyteRequestDTO acolyteDto){
		userService.createAcolyteByUser(userId, acolyteDto);
		return ResponseEntity.ok().build();
	}
}
