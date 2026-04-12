package model;

import java.io.Serializable;
import java.util.Objects;

public class Libro implements Serializable, Comparable<Libro> {

	private static final long serialVersionUID = 1L;

	private int isbn;
	private String nombre;
	private String descripcion;
	private String categoria;
	private int stock;

	public Libro(int isbn, String nombre, String descripcion, String categoria, int stock) {
		this.isbn = isbn;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.categoria = categoria;
		this.stock = stock;
	}

	public Libro() {
	}

	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}

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
		return Objects.hash(isbn);
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
		return isbn == other.isbn;
	}

	@Override
	public int compareTo(Libro o) {		
		return this.nombre.compareToIgnoreCase(o.getNombre());
	}
	
	

}
