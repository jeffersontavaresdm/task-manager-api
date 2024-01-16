package tma.auth.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import tma.auth.dto.TokenResponse;
import tma.auth.service.AuthenticationService;

@RestController
public class AuthtenticationController {

    private final AuthenticationService authenticationService;

    public AuthtenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<TokenResponse> authenticate(Authentication authentication) {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(authenticationService.authenticate(authentication));
    }
}
