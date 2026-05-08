package es.dam1.model;

import java.util.ArrayList;
import java.util.List;

public class Album {

	private String nombre;
	private String artista;
	private String genero;
	private String notas;
	private List<Cancion> canciones; // Colección de canciones [cite: 6]

	public Album(String nombre, String artista, String genero) {
		this.nombre = nombre;
		this.artista = artista;
		this.genero = genero;
		this.notas = "";
		this.canciones = new ArrayList<>(); // Inicialización de la lista [cite: 6]
	}

	public Album() {
	}

	// Getters y Setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getNotas() {
		return notas;
	}

	public void setNotas(String notas) {
		this.notas = notas;
	}

	public List<Cancion> getCanciones() {
		return canciones;
	}

	public void setCanciones(List<Cancion> canciones) {
		this.canciones = canciones;
	}

	// Método para facilitar la adición de canciones
	public void añadirCancion(Cancion cancion) {
		this.canciones.add(cancion);
	}

	// El ListView usará el toString para mostrar el nombre en la interfaz [cite:
	// 13]
	@Override
	public String toString() {
		return nombre;
	}

}
