package com.solangelish.MediPlanner.security;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class KeycloakRealmRoleConverter implements Converter<Jwt, Collection<GrantedAuthority>> {

    @Override
    @SuppressWarnings("unchecked")
    public Collection<GrantedAuthority> convert(Jwt jwt) {
        Map<String, Object> realmAccess = (Map<String, Object>) jwt.getClaims().get("realm_access");
        if (realmAccess == null) return List.of();

        Object rolesObj = realmAccess.get("roles");
        if (!(rolesObj instanceof List<?> roles)) return List.of();

        return roles.stream()
                .filter(String.class::isInstance)
                .map(String.class::cast)
                .map(r -> "ROLE_" + r)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
}