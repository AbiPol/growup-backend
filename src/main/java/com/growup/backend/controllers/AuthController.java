package com.growup.backend.controllers;

import com.growup.backend.api.AutenticacinApi;
import com.growup.backend.model.*;
import com.growup.backend.security.JwtProvider;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
public class AuthController implements AutenticacinApi {

    private final JwtProvider jwtProvider;

    public AuthController(JwtProvider jwtProvider) {
        this.jwtProvider = jwtProvider;
    }

    @Override
    public ResponseEntity<AuthResponse> authLoginPost(LoginRequest loginRequest) {
        // TODO: Validar credenciales reales con AuthenticationManager

        // Mock Response para probar la integración
        String token = jwtProvider.generateToken(loginRequest.getEmail());

        User user = new User();
        user.setId(java.util.UUID.randomUUID());
        user.setEmail(loginRequest.getEmail());
        user.setName("Mock User");
        user.setRole(Role.STUDENT); // Default mock role
        user.setIsActive(true);

        AuthResponse response = new AuthResponse();
        response.setToken(token);
        response.setUser(user);

        return ResponseEntity.ok(response);
    }
}
