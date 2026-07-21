package br.com.posterius.acolyteapp.security;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.server.ResponseStatusException;

import br.com.posterius.acolyteapp.controller.auth.AuthDTO;
import br.com.posterius.acolyteapp.controller.auth.AuthTokenDTO;
import br.com.posterius.acolyteapp.entities.user.UserEntity;
import br.com.posterius.acolyteapp.repositories.user.UserRepository;
public class Authentication implements UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public Authentication(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByLogin(login).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return user;
    }

    public AuthTokenDTO login(AuthDTO authDTO) {
		UserEntity user = userRepository.findByLogin(authDTO.login()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

		if (!passwordEncoder.matches(authDTO.password(), user.getPassword()))
			new ResponseStatusException(HttpStatus.NOT_FOUND);

		return new AuthTokenDTO(TokenUtil.encode(user));
	}
}
