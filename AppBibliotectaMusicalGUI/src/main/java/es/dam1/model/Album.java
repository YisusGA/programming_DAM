package es.dam1.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Album implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String nombre;
	private String artista;
	private String genero;
	private String notas;
	private List<Cancion> canciones; // Colección de canciones

	public Album(String nombre, String artista, String genero) {
		this.nombre = nombre;
		this.artista = artista;
		this.genero = genero;
		this.notas = "";
		this.canciones = new ArrayList<>(); // Inicialización de la lista
	}

	public Album() {
		this.canciones = new ArrayList<>();
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
		Album other = (Album) obj;
		return Objects.equals(nombre, other.nombre);
	}

	public String infoCompleta() {
		String txtCanciones = "";
		for (Cancion c : canciones) {
			txtCanciones += c + ", ";
		}
		String result = String.format("""
				Nombre: %s
				Artista: %s
				Género: %s
				Notas: %s
				Canciones(%d): %s
				""", this.nombre, this.artista, this.genero, this.notas, canciones.size(), txtCanciones);
		return result;
	}

	public String obtenerStringListaCanciones() {
		String txtCanciones = "";
		if (this.canciones != null) {
			for (Cancion c : canciones) {
				txtCanciones += c + "\n";
			}
		}
		return txtCanciones;
	}

}
