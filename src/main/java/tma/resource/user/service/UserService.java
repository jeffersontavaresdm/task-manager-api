package tma.resource.user.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import tma.resource.user.dto.UserDTO;
import tma.resource.user.dto.UserPayload;
import tma.resource.user.entity.User;
import tma.resource.user.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserDTO create(UserPayload userPayload) {
        if (userRepository.findByUsername(userPayload.username()).isPresent()) {
            throw new RuntimeException();
        }

        Optional<User> user = userRepository.createUser(
            userPayload.username(),
            passwordEncoder.encode(userPayload.password())
        );

        if (user.isEmpty()) {
            throw new RuntimeException();
        }

        return user.get().toDTO();
    }
}
