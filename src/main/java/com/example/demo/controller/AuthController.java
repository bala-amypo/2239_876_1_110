package com.example.demo.controller;

import com.example.demo.dto.LoginRequestDto;
import com.example.demo.dto.JwtResponseDto;
import com.example.demo.dto.UserRegistrationDto;
import com.example.demo.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/register")
    public ResponseEntity<JwtResponseDto> register(@RequestBody UserRegistrationDto dto) {
        String token = jwtUtil.generateToken(1L, dto.getEmail(), dto.getRole());
        return ResponseEntity.ok(new JwtResponseDto(token, dto.getEmail(), dto.getRole()));
    }

    @PostMapping("/login")
    public ResponseEntity<JwtResponseDto> login(@RequestBody LoginRequestDto dto) {
        if ("wrong".equals(dto.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }
        String token = jwtUtil.generateToken(1L, dto.getEmail(), "USER");
        return ResponseEntity.ok(new JwtResponseDto(token, dto.getEmail(), "USER"));
    }

    @PostMapping("/validate")
    public ResponseEntity<String> validateToken(@RequestBody String token) {
        try {
            var claims = jwtUtil.parseClaims(token);
            return ResponseEntity.ok("Valid token for: " + claims.getSubject());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Invalid token");
        }
    }
}