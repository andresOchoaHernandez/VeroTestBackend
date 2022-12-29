package com.andresochoahernandez.testonline.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.OAuth2ClientDsl;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration{

    // TODO: secure the application, ensure the authentication of studenti and professori

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
    {
        return http
                //.authorizeHttpRequests((requests) -> requests.requestMatchers("/").permitAll().anyRequest().authenticated())
                //.formLogin((form) -> form.loginPage("/login").permitAll())
                //.logout((logout) -> logout.permitAll())
                .build();
    }
}
