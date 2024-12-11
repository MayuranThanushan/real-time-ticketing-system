package org.example.ticketingsystem.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration  // Indicates this class contains Spring configuration
public class SecurityConfig {

    // Define a SecurityFilterChain bean that configures HTTP security for the application
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())  // Disable CSRF protection for APIs (typically needed for stateless APIs)
                .authorizeHttpRequests(auth -> auth
                        // Secure the /api/tickets/** endpoints by requiring authentication
                        .requestMatchers("/api/tickets/**").authenticated()
                        // Allow all other endpoints without authentication
                        .anyRequest().permitAll()
                )
                .httpBasic(httpBasic -> {});  // Enable HTTP Basic Authentication (for simplicity)

        // Build and return the security filter chain with the defined configurations
        return http.build();
    }
}
