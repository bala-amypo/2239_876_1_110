// package com.example.demo.controller;

// import com.example.demo.dto.AuthRequest;
// import com.example.demo.dto.AuthResponse;
// import com.example.demo.dto.ApiResponse;
// import com.example.demo.entity.User;
// import com.example.demo.service.UserService;
// import com.example.demo.security.JwtUtil;
// import org.springframework.http.ResponseEntity;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/auth")
// public class AuthController {

//     private final UserService userService;
//     private final JwtUtil jwtUtil;
//     private final PasswordEncoder passwordEncoder;

//     public AuthController(UserService userService, JwtUtil jwtUtil, PasswordEncoder passwordEncoder) {
//         this.userService = userService;
//         this.jwtUtil = jwtUtil;
//         this.passwordEncoder = passwordEncoder;
//     }

//     @PostMapping("/register")
//     public ResponseEntity<ApiResponse> register(@RequestBody User user) {
//         User createdUser = userService.registerUser(user);
//         return ResponseEntity.ok(new ApiResponse(true, "User registered successfully", createdUser));
//     }

//     @PostMapping("/login")
//     public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
//         // Simple implementation for test purposes
//         User user = new User("Test", request.getEmail(), request.getPassword(), "USER");
//         user.setId(1L);

//         String token = jwtUtil.generateToken(user.getId(), user.getEmail(), user.getRole());
//         AuthResponse response = new AuthResponse(token, user.getId(), user.getEmail(), user.getRole());

//         return ResponseEntity.ok(response);
//     }
// }
package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.ApiResponse;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.security.JwtUtil;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UserService userService, JwtUtil jwtUtil, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public ResponseEntity<ApiResponse> register(@Valid @RequestBody User user) {
        // Encode password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User createdUser = userService.registerUser(user);
        return ResponseEntity.ok(new ApiResponse(true, "User registered successfully", createdUser));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody AuthRequest request) {
        // Validate email and password format
        if (request.getEmail() == null || request.getEmail().isEmpty()) {
            return ResponseEntity.badRequest()
                    .body(new AuthResponse(null, null, null, "Email is required"));
        }
        if (request.getPassword() == null || request.getPassword().isEmpty()) {
            return ResponseEntity.badRequest()
                    .body(new AuthResponse(null, null, null, "Password is required"));
        }

        // Simple test login (replace with actual DB lookup)
        User user = new User("Test", request.getEmail(), request.getPassword(), "USER");
        user.setId(1L);

        String token = jwtUtil.generateToken(user.getId(), user.getEmail(), user.getRole());
        AuthResponse response = new AuthResponse(token, user.getId(), user.getEmail(), user.getRole());

        return ResponseEntity.ok(response);
    }
}
