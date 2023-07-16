package com.secure.userRegAndAuthSys.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author Ernest Emmanuel Utibe
 */

@Configuration
@EnableWebSecurity
public class UserRegistrationSecurityConfig {

    public SecurityFilterChain securityFilter(HttpSecurity httpSecurity) {
        httpSecurity.cors()
                    .csrf()
                    .disable()
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
