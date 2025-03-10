package com.caregiver.Caregiver.Tracker.System.config;

import com.caregiver.Caregiver.Tracker.System.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                        .requestMatchers("/css/**", "/js/**", "/images/**", "/login", "/", "/register").permitAll()  // Public access
                        .requestMatchers("/caregivers/profile/**").hasRole("CAREGIVER")  // Caregiver hub
                        .requestMatchers("/patients/profile/**").hasRole("PATIENT")   // Patient task hub
                        .requestMatchers("/caregivers/**", "/patients/**", "/register").hasRole("ADMIN")  // Admin access for managing employees and uploading tasks
                        .anyRequest().authenticated())  // All other requests require authentication

                .formLogin(formLogin -> formLogin
                        .loginPage("/login")
                        .permitAll()
                        .successHandler((request, response, authentication) -> {
                            authentication.getAuthorities().forEach(grantedAuthority -> {
                                String role = grantedAuthority.getAuthority();
                                try {
                                    if (role.equals("ROLE_ADMIN")) {
                                        response.sendRedirect("/");  // Admin redirect
                                    } else if (role.equals("ROLE_CAREGIVER")) {
                                        response.sendRedirect("/caregivers/profile");  // Employee redirect
                                    }else if (role.equals("ROLE_PATIENT")) {
                                        response.sendRedirect("/patients/profile");  // Employee redirect
                                    }
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            });
                        }))
                .logout(logout -> logout.logoutSuccessUrl("/login").permitAll())
                .userDetailsService(userDetailsService);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}