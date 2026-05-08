package es.dam1.controller;

import es.dam1.model.Album;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ServiceController {
	public static ObservableList<String> listaGeneros = FXCollections.observableArrayList();
	public static ObservableList<Album> listaAlbumes = FXCollections.observableArrayList();;
	
	public static boolean addAlbum(String nombre, String artista, String genero, String notas) {
		boolean added = false;
		if (!nombre.isBlank() && !artista.isBlank() && !genero.isBlank()) {
			Album album = new Album();
			album.setNombre(nombre);
			album.setArtista(artista);
			album.setGenero(genero);
			album.setNotas(notas);
			listaAlbumes.add(album);
			added =  true;
		}
		return added;
		
	}

}
