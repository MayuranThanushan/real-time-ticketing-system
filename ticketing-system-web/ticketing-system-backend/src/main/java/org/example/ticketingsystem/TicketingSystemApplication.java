package org.example.ticketingsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication  // Indicates that this is a Spring Boot application
public class TicketingSystemApplication {

    // Main method to run the Spring Boot application
    public static void main(String[] args) {
        SpringApplication.run(TicketingSystemApplication.class, args);  // Starts the Spring Boot application
    }

    // Bean definition for configuring Cross-Origin Resource Sharing (CORS) settings
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                // Configure CORS mappings for API endpoints
                registry.addMapping("/api/**")  // Apply CORS settings to all API endpoints under /api/*
                        .allowedOrigins("http://localhost:3000")  // Allow requests from localhost:3000 (typically for development)
                        .allowedMethods("GET", "POST", "PUT", "DELETE")  // Allow specific HTTP methods
                        .allowCredentials(true);  // Allow cookies and authentication credentials in CORS requests
            }
        };
    }
}
