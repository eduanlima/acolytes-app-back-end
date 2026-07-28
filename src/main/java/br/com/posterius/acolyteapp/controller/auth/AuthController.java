package br.com.posterius.acolyteapp.controller.auth;

import org.springframework.web.bind.annotation.RestController;

import br.com.posterius.acolyteapp.services.AuthenticationService;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/auth")
public class AuthController {
	private final AuthenticationManager authenticationManager;
	private final AuthenticationService authenticationService;

    public AuthController(AuthenticationManager authenticationManager, AuthenticationService authenticationService) {
		this.authenticationManager = authenticationManager;
		this.authenticationService = authenticationService;
	}

	@PostMapping("/login")
	public ResponseEntity<AuthTokenDTO> auth(@RequestBody AuthDTO authTokenDTO) {
		var token = new UsernamePasswordAuthenticationToken(authTokenDTO.login(), authTokenDTO.password());
		authenticationManager.authenticate(token);

		AuthTokenDTO userTokenDTO = authenticationService.generateToken(authTokenDTO);
		return ResponseEntity.ok(userTokenDTO);
	}

	@PostMapping("/refresh-token")
	public ResponseEntity<AuthTokenDTO> refreshToken(@RequestBody AuthRefreshTokenDTO authRefreshTokenDTO) {
		AuthTokenDTO userTokenDTO = authenticationService.generateTokenByRefreshToken(authRefreshTokenDTO);
		return ResponseEntity.ok(userTokenDTO);
	}
}
