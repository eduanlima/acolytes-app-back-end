package br.com.posterius.acolyteapp.services.impl;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

import br.com.posterius.acolyteapp.controller.auth.AuthDTO;
import br.com.posterius.acolyteapp.controller.auth.AuthTokenDTO;
import br.com.posterius.acolyteapp.entities.user.UserEntity;
import br.com.posterius.acolyteapp.repositories.user.UserRepository;
import br.com.posterius.acolyteapp.services.AuthenticationService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    public static final String ISSUER = "https://posterius.com.br";
    private final UserRepository userRepository;

    public AuthenticationServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByLogin(login)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return user;
    }

    @Override
    public AuthTokenDTO generateToken(AuthDTO authDTO) {
        UserEntity user = userRepository.findByLogin(authDTO.login())
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        return new AuthTokenDTO(generateToken(user));
    }

    private Algorithm getAlgorithm() {
        return Algorithm.HMAC256("my-scret");
    }

    private String generateToken(UserEntity userEntity) {
        try {
            return JWT.create()
                .withIssuer(ISSUER)
                .withSubject(userEntity.getLogin())
                .withExpiresAt(generateExpiration())
                .sign(getAlgorithm());
        }
        catch(JWTCreationException error){
            throw new RuntimeException("Error generating the token." + error.getMessage());
        }
    }

    private Instant generateExpiration() {
        return LocalDateTime.now().plusHours(1).toInstant(ZoneOffset.of("-03:00"));
    }

    @Override
    public String validateToken(String token) {
        try {
            return JWT.require(getAlgorithm())
                .withIssuer(ISSUER)
                .build()
                .verify(token)
                .getSubject();
        }
        catch (JWTVerificationException error) {
            return null;
        }
    }
}
