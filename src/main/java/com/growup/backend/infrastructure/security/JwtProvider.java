package com.growup.backend.infrastructure.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;

import java.security.Key;
import java.util.Date;
import java.util.Base64;

@Component
@Slf4j
public class JwtProvider {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private int expiration;

    private Key key;

    @PostConstruct
    protected void init() {
        // Si el secreto es corto, lo rellenamos o usamos uno seguro generado si no se
        // provee
        // Para este ejemplo básico, usaremos Keys.secretKeyFor si el string es muy
        // corto,
        // pero idealmente decodificamos el secret del properties
        if (secret.length() < 32) {
            key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        } else {
            byte[] keyBytes = Base64.getEncoder().encode(secret.getBytes());
            key = Keys.hmacShaKeyFor(keyBytes);
        }
    }

    // public String generateToken(Authentication authentication) {
    // // En un caso real, aquí extraemos el UserDetails
    // String username = authentication.getName();

    // Date now = new Date();
    // Date expiryDate = new Date(now.getTime() + expiration);

    // return Jwts.builder()
    // .setId(authentication.getPrincipal().toString())
    // .setSubject(username)
    // .setIssuedAt(now)
    // .setExpiration(expiryDate)
    // .signWith(key, SignatureAlgorithm.HS256)
    // .compact();
    // }

    // Sobrecarga para generar token desde username directamente (útil para login
    // manual)
    public String generateToken(String email) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + expiration);

        return Jwts.builder()
                .setId(email)
                .setSubject(email)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public String getEmailFromToken(String token) {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();

        return claims.getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (JwtException e) {
            log.error("GrowUp-Log: JwtProvider - Error al validar el token: {}", e.getMessage());
            return false;
        }
    }
}
