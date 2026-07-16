package br.com.posterius.acolyteapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.csrf((csrf) -> {
            csrf.disable();
        })
        .authorizeHttpRequests((auth) -> {
            auth.requestMatchers(new AntPathRequestMatcher("/acolyte","GET")).permitAll()
            .requestMatchers(new AntPathRequestMatcher("/user", "POST")).permitAll()
            .requestMatchers(HttpMethod.POST, "/user/login").permitAll()
            .anyRequest().authenticated();
        })
        .addFilterBefore(new AuthFilter(), UsernamePasswordAuthenticationFilter.class);

        return httpSecurity.build();
    }

}
