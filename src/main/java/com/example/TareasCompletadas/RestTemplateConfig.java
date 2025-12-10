package com.example.TareasCompletadas;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

// Marca esta clase como una clase de configuración de Spring
@Configuration
public class RestTemplateConfig {
    // Indica que este método produce un bean que será gestionado por Spring
    @Bean
     // Método que crea y configura un RestTemplate
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        // Construye y retorna una instancia de RestTemplate
        return builder.build();
    }
}