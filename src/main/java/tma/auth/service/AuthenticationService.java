package tma.auth.service;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import tma.auth.dto.TokenResponse;

@Service
public class AuthenticationService {

    private final JwtService jwtService;

    public AuthenticationService(JwtService jwtService) {
        this.jwtService = jwtService;
    }

    public TokenResponse authenticate(Authentication authentication) {
        String token = jwtService.generateToken(authentication);
        return new TokenResponse(token);
    }
}