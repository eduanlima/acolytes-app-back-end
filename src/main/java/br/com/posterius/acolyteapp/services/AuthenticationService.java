package br.com.posterius.acolyteapp.services;

import org.springframework.security.core.userdetails.UserDetailsService;

import br.com.posterius.acolyteapp.controller.auth.AuthDTO;
import br.com.posterius.acolyteapp.controller.auth.AuthRefreshTokenDTO;
import br.com.posterius.acolyteapp.controller.auth.AuthTokenDTO;

public interface AuthenticationService extends UserDetailsService {
    public AuthTokenDTO generateToken(AuthDTO authDTO);
    public String validateToken(String token);
    public AuthTokenDTO generateTokenByRefreshToken(AuthRefreshTokenDTO authRefreshTokenDTO);
}