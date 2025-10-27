package com.solangelish.MediPlanner.controller;

import com.solangelish.MediPlanner.model.User;
import com.solangelish.MediPlanner.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserRepository users;
    private final PasswordEncoder enc;

    public AuthController(UserRepository users, PasswordEncoder enc) {
        this.users = users;
        this.enc = enc;
    }

    record RegisterReq(String username, String password) {}

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterReq r) {
        if (users.existsByUsername(r.username())) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(Map.of("message", "Usuario ya existe"));
        }

        users.save(User.builder()
                .username(r.username())
                .password(enc.encode(r.password()))
                .roles(Set.of("ROLE_USER"))
                .build());

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("message", "Usuario creado"));
    }


    @PostMapping("/login")
    public ResponseEntity<?> login() {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED)
                .body(Map.of("message", "El inicio de sesión se realiza en Keycloak"));
    }
}
