package es.dam1.controller;

import es.dam1.model.Album;
import es.dam1.model.Cancion;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ServiceController {
	private static ObservableList<String> listaGeneros = FXCollections.observableArrayList();
	private static ObservableList<Album> listaAlbumes = FXCollections.observableArrayList();

	public static ObservableList<String> getListaGeneros() {
		return listaGeneros;
	}

	public static void setListaGeneros(ObservableList<String> listaGeneros) {
		ServiceController.listaGeneros = listaGeneros;
	}

	public static ObservableList<Album> getListaAlbumes() {
		return listaAlbumes;
	}

	public static void setListaAlbumes(ObservableList<Album> listaAlbumes) {
		ServiceController.listaAlbumes = listaAlbumes;
	}

	public static boolean addAlbum(String nombre, String artista, String genero, String notas) {
		boolean added = false;
		if (!nombre.isBlank() && !artista.isBlank() && !genero.isBlank()) {
			Album album = new Album();
			album.setNombre(nombre);
			album.setArtista(artista);
			album.setGenero(genero);
			album.setNotas(notas);
			listaAlbumes.add(album);
			added = true;
		}
		return added;
	}

	public static boolean addSongToAlbum(Album album, String nombre, String duracion) {
		boolean added = false;
		if (!nombre.isBlank() && !duracion.isBlank()) {
			Cancion cancion = new Cancion(nombre, duracion);
			listaAlbumes.stream().filter(x -> x.equals(album)).findFirst()
					.ifPresent(x -> x.getCanciones().add(cancion));
			added = true;
		}
		return added;
	}

	public static boolean eliminarAlbum(Album album) {
		boolean eliminado = false;
		eliminado = listaAlbumes.removeIf(x -> x.equals(album));
		return eliminado;
	}
}
