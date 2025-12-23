package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    public JwtUtil() {}

    public JwtUtil(String secret) {}

    public String generateToken(String username) {
        return "dummy-token";
    }
}
