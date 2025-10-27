package com.solangelish.MediPlanner.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class UserInfoController {
    @GetMapping("/user/me")
    public Map<String,Object> me(Authentication auth) {
        return Map.of(
                "username", auth.getName(),
                "roles", auth.getAuthorities().stream()
                        .map(GrantedAuthority::getAuthority)
                        .collect(Collectors.toList())
        );
    }
}