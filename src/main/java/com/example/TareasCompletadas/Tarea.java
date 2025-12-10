package com.example.TareasCompletadas;
// Clase que representa una tarea
public class Tarea {
    private String nombreTarea;
    private String fechaEntrega;
    private String materia;
    private String descripcion;

    // Constructor sin parametros
    public Tarea() {}
    
    // Constructor
    public Tarea(String nombreTarea, String fechaEntrega, String materia, String descripcion) {
        this.nombreTarea = nombreTarea;
        this.fechaEntrega = fechaEntrega;
        this.materia = materia;
        this.descripcion = descripcion;
    }

    // Getters y Setters
    public String getNombreTarea() { return nombreTarea; }
    public void setNombreTarea(String nombreTarea) { this.nombreTarea = nombreTarea; }

    public String getFechaEntrega() { return fechaEntrega; }
    public void setFechaEntrega(String fechaEntrega) { this.fechaEntrega = fechaEntrega; }

    public String getMateria() { return materia; }
    public void setMateria(String materia) { this.materia = materia; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}
