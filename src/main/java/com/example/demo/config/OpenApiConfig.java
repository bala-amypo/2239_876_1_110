package com.example.demo.config;

import com.example.demo.security.JwtUtil;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {
    
    @Bean
    public JwtUtil jwtUtil() {
        return new JwtUtil("test-secret-key-that-is-long-enough-1234", 3600000);
    }
    
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Resource Management API")
                        .version("1.0")
                        .description("API for managing resources and allocations"));
    }
}