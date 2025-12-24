package com.example.demo.config;

import com.example.demo.security.JwtUtil;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.List;

@Configuration
public class OpenApiConfig {
    
    @Bean
    public JwtUtil jwtUtil() {
        return new JwtUtil("test-secret-key-that-is-long-enough-1234", 3600000);
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .servers(List.of(
                        new Server().url("https://9129.32procr.amypo.ai")
                ));
    }
}