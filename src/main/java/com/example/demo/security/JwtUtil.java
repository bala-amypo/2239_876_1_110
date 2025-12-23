package com.example.demo.security;

public class JwtUtil {

    private String secret;
    private int expiration;

    public JwtUtil() {
    }

    public JwtUtil(String secret) {
        this.secret = secret;
    }

    public JwtUtil(String secret, int expiration) {
        this.secret = secret;
        this.expiration = expiration;
    }
}
