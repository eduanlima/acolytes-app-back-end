package br.com.posterius.acolyteapp.security;

import java.security.Key;
import java.util.Collections;
import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import br.com.posterius.acolyteapp.entities.user.UserEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;

public class TokenUtil {
    public static final String ISSUER = "https://posterius.com.br";
    public static final long EXPIRATION = 60 * 60 * 1000;
    public static final String SECRET_KEY = "0123456789012345678901234567890123456789";

    public static String encode(UserEntity userEntity) {
        try {
            Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
            return Jwts.builder()
                    .subject(userEntity.getPerson().getFirstName())
                    .expiration(new Date(System.currentTimeMillis() + EXPIRATION))
                    .issuer(ISSUER)
                    .signWith(key)
                    .compact();
        } catch (Exception error) {
            error.printStackTrace();
            return null;
        }
    }

    public static Authentication decode(HttpServletRequest request) {
        try {
            String header = request.getHeader("Authorization");
            if (header == null)
                return null;

            String token = header.replace("Bearer ", "");
            SecretKey secretKey = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
            JwtParser jwtParser = Jwts.parser().verifyWith(secretKey).build();
            Claims claims = (Claims) jwtParser.parse(token).getPayload();
            
            String subject = claims.getSubject();
            String issuer = claims.getIssuer();
            Date expiration = claims.getExpiration();

            if (!issuer.equals(ISSUER) || subject == null || subject.isBlank() || expiration.before(new Date(System.currentTimeMillis())))
                return null;

            return new UsernamePasswordAuthenticationToken("valid", null, Collections.emptyList());

        } catch (Exception error) {
            error.printStackTrace();
            return null;
        }
    }
}
