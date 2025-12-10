# Dockerfile
FROM eclipse-temurin:17-jdk-jammy

#Crea directorio de trabajo
WORKDIR /app


# Copiar el archivo de tareas completadas al directorio de trabajo
COPY tareas_completas.json ./
COPY target/TareasCompletadas-1.0.0.jar app.jar

# Exponer puerto
EXPOSE 8081

#Cinabdi oara ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]