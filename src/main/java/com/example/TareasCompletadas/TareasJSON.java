package com.example.TareasCompletadas;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.stereotype.Component;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Marca esta clase como un componente de Spring (se puede inyectar)
@Component
public class TareasJSON {
    // Constante con el nombre del archivo JSON
    private static final String ARCHIVO_JSON = "tareas_completas.json";
    // Objeto para convertir entre Java y JSON
    private ObjectMapper objectMapper;
    // Lista que almacena las tareas
    private List<Tarea> tareas;
    // Constructor
    public TareasJSON() {
        //Crea un nuevo ObjectMapper
        this.objectMapper = new ObjectMapper();
        // Hace que el JSON generado sea más legible
        this.objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        // Carga las tareas desde el archivo
        this.tareas = cargarTareasDesdeArchivo();
    }
    // Método para cargar tareas desde archivo JSON
    private List<Tarea> cargarTareasDesdeArchivo() {
        try {
            // Crea objeto File con el nombre del archivo
            File archivo = new File(ARCHIVO_JSON);
            // Si el archivo existe
            if (archivo.exists()) {
                //Lee el archivo JSON y convierte a array de tareas
                Tarea[] tareasArray = objectMapper.readValue(archivo, Tarea[].class);
                // Convierte el array a ArrayList y lo retorna
                return new ArrayList<>(Arrays.asList(tareasArray));
            }
        } catch (IOException e) {
            System.err.println("Error al cargar tareas desde archivo: " + e.getMessage());
        }
        
        // Si no existe el archivo o hay error, retornar lista por defecto
        return new ArrayList<>(Arrays.asList(
            new Tarea("Ejercicios de matematicas", "20/10/2025", "Ecuaciones diferenciales", "Terminar los ejercicios de la pagina 202"),
            new Tarea("Investigacion de señales", "23/10/2025", "Señales", "Investigar que son las series de Fourier"),
            new Tarea("Terminar programa tiendita", "28/10/2025", "Paradigmas", "Terminar el programa tiendita utilizando POO")
        ));
    }
    // Método para guardar tareas en archivo JSON
    public void guardarTareasEnArchivo() {
        try {
            // Escribe la lista de tareas en el archivo JSON
            objectMapper.writeValue(new File(ARCHIVO_JSON), tareas);
        } catch (IOException e) {
            System.err.println("Error al guardar tareas en archivo: " + e.getMessage());
        }
    }
    // Retorna una copia de la lista de tareas
    public List<Tarea> obtenerTodasLasTareas() {
        return new ArrayList<>(tareas);
    }
    
    public void agregarTarea(Tarea tarea) {
        // Agrega una tarea a la lista
        tareas.add(tarea);
        // Guarda los cambios en el archivo
        guardarTareasEnArchivo();
    }
    
    public void eliminarTarea(int indice) {
        // Verifica que el índice sea válido
        if (indice >= 0 && indice < tareas.size()) {
            // Elimina la tarea en el índice especificado
            tareas.remove(indice);
            // Guarda los cambios en el archivo
            guardarTareasEnArchivo();
        }
    }
    
    public Tarea obtenerTarea(int indice) {
        // Verifica que el índice sea válido
        if (indice >= 0 && indice < tareas.size()) {
            // Retorna la tarea en el índice especificado
            return tareas.get(indice);
        }
        // Retorna null si el índice no es válido
        return null;
    }
}
