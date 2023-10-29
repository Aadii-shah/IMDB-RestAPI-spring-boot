package com.movieapp.movie.config;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class MovieConfig {
        @Bean
        public RestTemplate getTemplate()
        {
                return new RestTemplate();
        }

        @Bean
        public WebMvcConfigurer corsConfigurer() {
                return new WebMvcConfigurer() {
                        public void addCorsMappings(CorsRegistry registry) {
                                registry.addMapping("/movies/**")
                                        .allowedOrigins("http://localhost:3000")
                                        .allowedMethods("GET", "POST");
                        }
                };
        }

}
