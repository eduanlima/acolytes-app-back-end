package br.com.posterius.acolyteapp.security;

import java.util.Collections;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import jakarta.servlet.http.HttpServletRequest;

public class TokenUtil {
    public static Authentication decode(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        if (header == null)
            return null;

        String token = header.replace("Bearer ","");
        if (!token.equals("security123"))
            return null;

        return new UsernamePasswordAuthenticationToken("valid", null, Collections.emptyList());
    }
}
