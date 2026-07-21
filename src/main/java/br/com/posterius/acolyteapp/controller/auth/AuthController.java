package br.com.posterius.acolyteapp.controller.auth;

import org.springframework.web.bind.annotation.RestController;

import br.com.posterius.acolyteapp.controller.user.UserDTO;
import br.com.posterius.acolyteapp.security.Authentication;
import br.com.posterius.acolyteapp.services.UserService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final Authentication authentication;
	private final AuthenticationManager authenticationManager;

    public AuthController(Authentication authentication, AuthenticationManager authenticationManager) {
		this.authentication = authentication;
		this.authenticationManager = authenticationManager;
	}

	@PostMapping
	public ResponseEntity<AuthTokenDTO> auth(@RequestBody AuthDTO authDTO) {
		var token = new UsernamePasswordAuthenticationToken(authDTO.login(), authDTO.password());
		authenticationManager.authenticate(token);

		AuthTokenDTO userTokenDTO = authentication.login(authDTO);
		return ResponseEntity.ok(userTokenDTO);
	}
}
