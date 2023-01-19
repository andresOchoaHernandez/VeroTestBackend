package com.andresochoahernandez.testonline.service;

import com.andresochoahernandez.testonline.model.agents.User;
import com.andresochoahernandez.testonline.repository.agents.UserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.stream.Collectors;

@Service
public class TokenService {
    private final JwtEncoder jwtEncoder;
    private final UserRepository users;

    public TokenService(JwtEncoder jwtEncoder, UserRepository users) {
        this.jwtEncoder = jwtEncoder;
        this.users = users;
    }

    public String generateToken(Authentication authentication)
    {
        User usr = users.findByUsername(authentication.getName()).get();

        Instant now = Instant.now();
        String scope = authentication
                       .getAuthorities().stream()
                       .map(GrantedAuthority::getAuthority)
                       .collect(Collectors.joining(" "));
        JwtClaimsSet jwtClaimsSet = JwtClaimsSet.builder()
                .issuer("self")
                .issuedAt(now)
                .expiresAt(now.plus(3, ChronoUnit.HOURS))
                .subject(authentication.getName())
                .claim("scope", scope)
                .claim("userId",usr.getId())
                .build();

        return this.jwtEncoder.encode(JwtEncoderParameters.from(jwtClaimsSet)).getTokenValue();
    }
}
