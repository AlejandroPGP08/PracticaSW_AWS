// Define el paquete donde se encuentra la clase
package com.example.TareasCompletadas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Anotación que marca esta clase como la clase principal de una aplicación Spring Boot
@SpringBootApplication
public class MicroServicio2 {
    public static void main(String[] args) {
        // Inicia la aplicación Spring Boot con esta clase y los argumentos
        SpringApplication.run(MicroServicio2.class, args);
    }
}