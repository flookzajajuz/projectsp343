package com.example.projectend3;  // ปรับให้ตรงกับแพ็กเกจของโปรเจกต์ของคุณ

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:5500") // หรือ * ถ้าทดสอบเท่านั้น
                        .allowedMethods("GET", "POST", "PUT", "DELETE");
            }
        };
    }
}