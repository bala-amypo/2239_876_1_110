package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    public String generateToken(String email) {
        return "dummy-jwt-token";
    }

    public boolean validateToken(String token) {
        return true;
    }

    public String extractUsername(String token) {
        return "dummy@email.com";
    }
}
