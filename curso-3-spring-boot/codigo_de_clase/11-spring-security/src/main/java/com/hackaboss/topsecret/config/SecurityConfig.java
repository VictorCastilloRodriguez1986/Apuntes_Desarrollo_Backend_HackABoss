package com.hackaboss.topsecret.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(AbstractHttpConfigurer::disable)                                          // desactiva CSRF para APIs REST
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/archivos/desclasificados").permitAll()
                        .requestMatchers("/archivos/**").authenticated()                //cualquier ruta que empiece con /archivos/ sin importar lo que venga después.
                )
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }
}