package es.dam1.controller;

import es.dam1.model.Album;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class GUIController {
	
	@FXML
	private ComboBox<String> comboGenero;
	@FXML
	private TextField txtNombre;
	@FXML
	private TextField txtArtista;
	@FXML
	private TextArea areaNotas;
	@FXML
	ListView<String> listaAlbumes;
	
	@FXML
	public void initialize() {
		cargaGeneros();
		cargaAlbumes();
	}
	
	@FXML
	public void addAlbum() {
		boolean added = false;
		String nombre = txtNombre.getText().trim();
		String artista = txtArtista.getText().trim();
		String genero = comboGenero.getValue();
		String notas = areaNotas.getText().trim();
		if (genero != null) {
			genero.trim();
			added = ServiceController.addAlbum(nombre, artista, genero, notas);
			cargaAlbumes();
		}
	}
	
	public void cargaGeneros() {
		ServiceController.listaGeneros.add("Rock");
		ServiceController.listaGeneros.add("Pop");
		comboGenero.setItems(ServiceController.listaGeneros);
	}
	
	public void cargaAlbumes() {
		listaAlbumes.setItems(ServiceController.listaAlbumes);
	}

}
