package com.growup.backend.infrastructure.security;

import com.growup.backend.domain.model.User;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
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
        if (secret == null || secret.length() < 32) {
            log.warn("GrowUp-Log: JwtProvider - Secret is missing or too short, generating random key.");
            key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        } else {
            log.info("GrowUp-Log: JwtProvider - Using stable secret key.");
            key = Keys.hmacShaKeyFor(secret.getBytes());
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
    public String generateToken(User user) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + expiration);

        return Jwts.builder()
                .setSubject(user.getId().toString()) // Usamos el UUID como Subject
                .claim("email", user.getEmail()) // El email lo guardamos como un claim extra
                .claim("role", user.getRole().name()) // ¡Incluso el rol!
                .claim("name", user.getName()) // ¡Incluso el rol!
                .claim("isActive", user.getIsActive()) // ¡Incluso el rol!
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public String getEmailFromToken(String token) {
        Claims claims = getAllClaims(token);
        return claims.get("email", String.class);
    }

    public String getSubjectFromToken(String token) {
        return getAllClaims(token).getSubject();
    }

    private Claims getAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean validateToken(String token) {
        try {
            // System.out.println("GrowUp-Log: JwtProvider - Validando token: " + token);
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (JwtException e) {
            log.error("GrowUp-Log: JwtProvider - Error al validar el token: {}", e.getMessage());
            return false;
        }
    }
}
