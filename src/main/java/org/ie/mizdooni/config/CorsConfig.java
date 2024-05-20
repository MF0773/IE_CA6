package org.ie.mizdooni.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@Configuration
public class CorsConfig {
    private static final Long MAX_AGE = 3600L;
    private static final int CORS_FILTER_ORDER = -102;

    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        // Allow only localhost origin
        config.setAllowedOrigins(Arrays.asList("http://localhost:8080"));

        // Allowed HTTP methods
        config.setAllowedMethods(Arrays.asList("POST", "PUT", "PATCH", "DELETE", "GET"));

        // Allowed headers
        config.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type", "Accept"));

        // Max age for preflight request
        config.setMaxAge(MAX_AGE); // 30 minutes in seconds

        // Apply CORS configuration on every path
        source.registerCorsConfiguration("/**", config);

        FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter(source));
        bean.setOrder(CORS_FILTER_ORDER); // Set the highest precedence to ensure it runs first
        return bean;
    }
}