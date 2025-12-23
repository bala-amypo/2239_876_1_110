package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    public JwtUtil() {
    }

    public String generateToken(String username) {
        return "dummy-token";
    }

    public String extractUsername(String token) {
        return "user";
    }
}
