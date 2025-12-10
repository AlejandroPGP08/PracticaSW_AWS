package com.example.TareasCompletadas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import java.util.List;
// Marca esta clase como un controlador REST
@RestController
public class TareasCompletas {
    // Inyecta automáticamente la dependencia de RestTemplate
    @Autowired
    private RestTemplate restTemplate;
     // Inyecta automáticamente la dependencia de TareasJSON
    @Autowired
    private TareasJSON tareasJSON;
    // Nuevo endpoint para pasar tarea a completadas
    @GetMapping("/pasarTareaAPendiente")
    public String pasarTareaAPendiente(@RequestParam int indice) {
        Tarea tarea = tareasJSON.obtenerTarea(indice);
        if (tarea != null) {
            // Configurar headers para JSON
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            // Crear entidad HTTP con la tarea
            HttpEntity<Tarea> request = new HttpEntity<>(tarea, headers);
            // Enviar tarea al microservicio de tareas pendientes (usar puerto interno)
            String respuesta = restTemplate.postForObject(
                "http://tareas-pendientes:8080/agregarTareaPendiente",
                request,
                String.class
            );
            // Eliminar la tarea de pendientes
            tareasJSON.eliminarTarea(indice);
            return "Tarea movida a pendientes: " + respuesta;
        } else {
            return "Índice inválido";
        }
    }
    // Endpoint para obtener todas las tareas completadas
    @GetMapping("/TareasCompletas")
    public List<Tarea> TareasCompletadas() {
        // Retorna la lista de todas las tareas
        return tareasJSON.obtenerTodasLasTareas();
    }

    // Endpoint para agregar una tarea completa (POST)
    @PostMapping("/agregarTareaCompleta")
    // @RequestBody convierte el JSON recibido en un objeto Tarea
    public String agregarTareaCompleta(@RequestBody Tarea tarea) {
        // Agrega la tarea al listado
        tareasJSON.agregarTarea(tarea);
        return "Tarea agregada exitosamente";
    }
    // Endpoint para eliminar una tarea completada
    @GetMapping("/eliminarTareaCompletada")
    // @RequestParam extrae el parámetro 'i' de la URL
    public String eliminarTareaCompletada(@RequestParam int i) {
        // Elimina la tarea en el índice especificado
        tareasJSON.eliminarTarea(i);
        return "Tarea eliminada exitosamente";
    }
}
