package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
        @SuppressWarnings("removal")
        @Bean
        public AuthenticationManager authenticationManager(HttpSecurity http,
                        BCryptPasswordEncoder bCryptPasswordEncoder, UserDetailsService userDetailsService)
                        throws Exception {
                return http.getSharedObject(AuthenticationManagerBuilder.class)
                                .userDetailsService(userDetailsService)
                                .passwordEncoder(bCryptPasswordEncoder)
                                .and()
                                .build();
        }

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
                http.csrf(AbstractHttpConfigurer::disable)
                                .authorizeHttpRequests(
                                                authorizationManagerRequestMatcherRegistry -> authorizationManagerRequestMatcherRegistry
                                                                .requestMatchers(HttpMethod.DELETE).hasRole("ADMIN")
                                                                .requestMatchers("/api/v1/student/**")
                                                                .hasAnyRole("ADMIN")
                                                                .requestMatchers("/api/v1/users/**")
                                                                .hasAnyRole("ADMIN")
                                                                .requestMatchers("/login/**").permitAll()
                                                                .anyRequest().authenticated())
                                .formLogin(Customizer.withDefaults())
                                .httpBasic(Customizer.withDefaults());

                return http.build();
        }

        @Bean
        public BCryptPasswordEncoder encoder() {
                return new BCryptPasswordEncoder();
        }

}