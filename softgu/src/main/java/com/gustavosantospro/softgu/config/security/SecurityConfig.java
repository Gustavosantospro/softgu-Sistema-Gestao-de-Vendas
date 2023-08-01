package com.gustavosantospro.softgu.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http
                .csrf().disable() //desabilitando configuração padrão Spring security
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // definindo que a sessão não irá armazenar estado
                .and()
                .authorizeHttpRequests().antMatchers(HttpMethod.POST, "/product").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .build();
    }

}
