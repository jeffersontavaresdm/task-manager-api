package tma.auth.service;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.stream.Collectors;

@Service
public class JwtService {
    private final JwtEncoder encoder;

    public JwtService(JwtEncoder encoder) {
        this.encoder = encoder;
    }

    public String generateToken(Authentication authentication) {
        String scopes = authentication
            .getAuthorities()
            .stream()
            .map(GrantedAuthority::getAuthority)
            .collect(Collectors.joining(" "));

        Instant now = Instant.now();
        JwtClaimsSet claims = JwtClaimsSet
            .builder()
            .issuer("task-manager-jwt")
            .issuedAt(now)
            .expiresAt(now.plusSeconds(3600 * 24))
            .subject(authentication.getName())
            .claim("scopes", scopes)
            .build();

        return encoder
            .encode(JwtEncoderParameters.from(claims))
            .getTokenValue();
    }
}