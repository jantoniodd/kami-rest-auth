package com.jadd.kamirestauth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain filter(ServerHttpSecurity http) {

        return http.authorizeExchange().anyExchange().authenticated().and().httpBasic().and().csrf().disable().build();
    }

}
