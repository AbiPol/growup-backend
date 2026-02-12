package com.growup.backend.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO: Implementar búsqueda real en base de datos.
        // Por ahora devolvemos un usuario dummy para que el servidor arranque y
        // compile.
        if ("teacher@gmail.com".equals(username) || "admin@gmail.com".equals(username)
                || "student@gmail.com".equals(username)) {
            return new User(username, "$2a$10$XXXXXXXXXXXXXXXXXXXXXX", new ArrayList<>()); // Hash falso
        }
        // Fallback for verification
        return new User("user", "password", new ArrayList<>());
    }
}
