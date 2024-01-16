package tma.resource.user.dto;

import org.springframework.security.crypto.password.PasswordEncoder;
import tma.resource.user.entity.User;

public record UserPayload(String username, String password) {
    public User toEntity() {
        return new User(
            this.username(),
            this.password()
        );
    }

    public User toEntity(PasswordEncoder passwordEncoder) {
        return new User(
            this.username(),
            passwordEncoder.encode(this.password())
        );
    }
}