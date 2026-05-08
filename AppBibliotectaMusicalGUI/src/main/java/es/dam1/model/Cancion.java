package es.dam1.model;

import java.util.Objects;

public class Cancion {
	private String titulo;
	private String duracion;

	public Cancion(String titulo, String duracion) {
		this.titulo = titulo;
		this.duracion = duracion;
	}

	public Cancion() {
	}

	// Getters y Setters
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDuracion() {
		return duracion;
	}

	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}

	@Override
	public String toString() {
		return titulo + " - " + duracion;
	}

	@Override
	public int hashCode() {
		return Objects.hash(duracion, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cancion other = (Cancion) obj;
		return Objects.equals(duracion, other.duracion) && Objects.equals(titulo, other.titulo);
	}

}
