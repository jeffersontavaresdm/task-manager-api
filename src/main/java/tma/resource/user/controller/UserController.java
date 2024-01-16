package tma.resource.user.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tma.resource.user.dto.UserDTO;
import tma.resource.user.dto.UserPayload;
import tma.resource.user.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody UserPayload userPayload) {
        UserDTO user = userService.create(userPayload);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
}
