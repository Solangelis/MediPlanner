package com.solangelish.MediPlanner.config;

import com.solangelish.MediPlanner.model.User;
import com.solangelish.MediPlanner.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Set;

@Configuration
public class InitData {

    @Bean
    CommandLineRunner seedUsers(UserRepository repo) {
        BCryptPasswordEncoder enc = new BCryptPasswordEncoder();

        return args -> {
            if (!repo.existsByUsername("admin")) {
                repo.save(User.builder()
                        .username("admin")
                        .password(enc.encode("admin123"))
                        .roles(Set.of("ROLE_ADMIN","ROLE_USER"))
                        .build());
            }
            if (!repo.existsByUsername("recep1")) {
                repo.save(User.builder()
                        .username("recep1")
                        .password(enc.encode("123456"))
                        .roles(Set.of("ROLE_RECEPCION"))
                        .build());
            }
            if (!repo.existsByUsername("medico1")) {
                repo.save(User.builder()
                        .username("medico1")
                        .password(enc.encode("123456"))
                        .roles(Set.of("ROLE_MEDICO"))
                        .build());
            }
        };
    }
}
