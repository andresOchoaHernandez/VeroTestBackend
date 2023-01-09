package com.andresochoahernandez.testonline.configuration.security;

import com.andresochoahernandez.testonline.service.AgentiService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfiguration{
    private final AgentiService agentiService;

    public SecurityConfiguration(AgentiService agentiService){
        this.agentiService = agentiService;
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
    {
        return http
                .csrf(csrf -> csrf.disable()) // only for /graphiql
                .authorizeHttpRequests(auth -> auth.anyRequest().authenticated())
                .userDetailsService(agentiService)
                .formLogin(Customizer.withDefaults())
                .build();
    }

    @Bean
    PasswordEncoder passwordEncoder(){

        //modify using encoder : https://www.youtube.com/watch?v=awcCiqBO36E&t=915s min. 36:58
        return NoOpPasswordEncoder.getInstance();
    }
}