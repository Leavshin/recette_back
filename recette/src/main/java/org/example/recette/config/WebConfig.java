package org.example.recette.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Bean
    public WebMvcConfigurer corsConfigurer()
    {
        String[] allowDomains = new String[3];
        allowDomains[0] = "http://localhost:4200";
        allowDomains[1] = "http://localhost:4201";
        allowDomains[2] = "http://localhost:8080";

        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins(allowDomains);
            }
        };
    }
}
