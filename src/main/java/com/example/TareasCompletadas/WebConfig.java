package com.example.TareasCompletadas;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// Marca esta clase como clase de configuración
@Configuration
public class WebConfig {
    // Define un bean de configuración
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        // Crea una implementación anónima de WebMvcConfigurer
        return new WebMvcConfigurer() {
            // Sobrescribe el método para configurar CORS
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                // Aplica a todas las rutas
                registry.addMapping("/**")
                        // Permite requests desde localhost:8000
                        .allowedOrigins("http://localhost","http://localhost:8000")
                        //.allowedOrigins("*")
                        // Métodos HTTP permitidos
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        //.allowedMethods("*")
                        // Todos los headers permitidos
                        .allowedHeaders("*")
                        // Permite enviar cookies/credenciales
                        .allowCredentials(true);
            }
        };
    }
}
