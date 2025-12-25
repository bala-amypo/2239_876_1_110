package com.example.demo.controller;

import com.example.demo.security.JwtUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Map<String, String> credentials) {
        String email = credentials.get("email");
        String role = credentials.getOrDefault("role", "USER");
        Long userId = Long.valueOf(credentials.getOrDefault("userId", "1"));
        
        String token = jwtUtil.generateToken(userId, email, role);
        return Map.of("token", token);
    }

    @PostMapping("/validate")
    public Map<String, Object> validate(@RequestBody Map<String, String> request) {
        String token = request.get("token");
        var claims = jwtUtil.parseClaims(token);
        return Map.of(
            "valid", true,
            "email", claims.getSubject(),
            "role", claims.get("role"),
            "userId", claims.get("userId")
        );
    }
}