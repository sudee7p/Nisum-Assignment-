package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class SecurityConfig {

    // Define in-memory users
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("1234")
                .roles("USER")
                .build();

        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("admin123")
                .roles("ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);
    }

    // Define security filter chain
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/login", "/css/**").permitAll() // allow login page and static resources
                        .requestMatchers("/api/admin/**").hasRole("ADMIN") // only admin can access
                        .requestMatchers("/api/user/**").hasAnyRole("USER", "ADMIN") // both user and admin can access
                        .requestMatchers("/api/**").authenticated() // general API endpoint needs auth
                        .anyRequest().permitAll() // other requests allowed
                )
                .formLogin(form -> form
                        .loginPage("/login") // custom login page
                        .loginProcessingUrl("/doLogin") // login form action
                        .defaultSuccessUrl("/api/welcome", true) // redirect after successful login
                        .permitAll()
                )
                .logout(logout -> logout
                        .logoutUrl("/doLogout")
                        .logoutSuccessUrl("/login?logout")
                        .permitAll()
                );

        return http.build();
    }
}
