package model;

import java.io.Serializable;
import java.util.Objects;

public class Libro implements Serializable {
    
    private static final long serialVersionUID = 1L; // Buena práctica para la serialización
    
    private String nombre;
    private String descripcion;
    private String categoria;
    private int stock; // Representa la cantidad de copias actual

    // Constructor vacío
    public Libro() {
    }

    // Constructor con parámetros
    public Libro(String nombre, String descripcion, String categoria, int stock) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
        this.stock = stock;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		return Objects.equals(nombre, other.nombre);
	}
    
}