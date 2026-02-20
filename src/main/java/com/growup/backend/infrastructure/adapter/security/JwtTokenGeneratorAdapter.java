package com.growup.backend.infrastructure.adapter.security;

import com.growup.backend.domain.port.out.TokenGeneratorPort;
import com.growup.backend.domain.model.User;
import com.growup.backend.infrastructure.security.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Adaptador para la generación de tokens JWT.
 * Implementa el puerto de salida TokenGeneratorPort usando JwtProvider.
 */
@Component
@RequiredArgsConstructor
public class JwtTokenGeneratorAdapter implements TokenGeneratorPort {

    private final JwtProvider jwtProvider;

    @Override
    public String generateToken(User user) {
        return jwtProvider.generateToken(user.getEmail());
    }
}
