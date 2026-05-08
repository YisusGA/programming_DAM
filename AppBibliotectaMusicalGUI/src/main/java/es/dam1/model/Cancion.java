package es.dam1.model;

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

}
