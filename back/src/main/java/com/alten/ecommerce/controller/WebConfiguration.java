package com.alten.ecommerce.controller;

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;
@Configuration
@ConditionalOnWebApplication
public class WebConfiguration {

    @Bean
    @ConditionalOnWebApplication
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(false);
        config.addAllowedOrigin("*");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("DELETE");
        config.addAllowedMethod("PATCH");
        config.addAllowedMethod("HEAD");
        config.addAllowedMethod("OPTIONS");
        config.setMaxAge(3600L); // cache pre-flight response for 1h

        config.addAllowedHeader("*");
        config.setExposedHeaders(Arrays.asList("Location", "Upload-Offset", "Upload-Length", "Allow"));

        source.registerCorsConfiguration("/api/**", config);

        return new CorsFilter(source);
    }
}
