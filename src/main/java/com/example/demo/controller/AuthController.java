package com.example.demo.controller;

import com.example.demo.dto.ApiResponse;
import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.util.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthController(UserService userService, JwtUtil jwtUtil, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    // 1. User Registration
    @PostMapping("/register")
    public ApiResponse registerUser(@RequestBody User user) {
        User createdUser = userService.registerUser(user);
        return new ApiResponse("User registered successfully with id: " + createdUser.getId());
    }

    // 2. User Login
    @PostMapping("/login")
    public AuthResponse loginUser(@RequestBody AuthRequest authRequest) {
        // Find user by email
        User user = userService.getAllUsers().stream()
                .filter(u -> u.getEmail().equals(authRequest.getEmail()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));

        // Verify password
        if (!passwordEncoder.matches(authRequest.getPassword(), user.getPassword())) {
            throw new RuntimeException("Invalid email or password");
        }

        // Generate JWT token
        String token = jwtUtil.generateToken(user.getEmail());

        return new AuthResponse(token);
    }
}
