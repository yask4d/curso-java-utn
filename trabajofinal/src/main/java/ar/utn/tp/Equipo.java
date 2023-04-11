package ar.utn.tp;

public class Equipo {

    // Atributos nombre y descripcion
    private String nombre;
    private String descripcion;

    // Constructor
    public Equipo(String nombre) {
        this.nombre = nombre;        
    }
    
    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    
}
