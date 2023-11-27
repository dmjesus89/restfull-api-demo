package com.kn.apim.restfulldemo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.server.resource.web.BearerTokenResolver;
import org.springframework.security.oauth2.server.resource.web.HeaderBearerTokenResolver;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class JWTSecurityConfig {
    @Value("${knite.jwt.authTokenHeaderName}")
    private String authTokenHeaderName;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                authorize -> authorize.requestMatchers("/actuator/**").permitAll().anyRequest().authenticated());

        http.oauth2ResourceServer(server -> server.jwt(jwtConfigurer -> {}));

        return http.build();
    }

    @Bean
    BearerTokenResolver bearerTokenResolver() {
        return new HeaderBearerTokenResolver(this.authTokenHeaderName);
    }

}
