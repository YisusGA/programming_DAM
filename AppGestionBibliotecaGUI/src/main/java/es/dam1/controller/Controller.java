package es.dam1.controller;

import java.util.Optional;

import es.dam1.dao.GestionLibros;
import es.dam1.data.PersistenciaDatos;
import javafx.fxml.FXML;
import javafx.scene.control.TextInputDialog;

public class Controller {
	
	@FXML
	public void addLibro() {
		String nombre = "";
		TextInputDialog dialog = new TextInputDialog();
		boolean valid = false;
		while (!valid) {
			dialog.setTitle("Añadir libro");
			dialog.setHeaderText(" ");
			dialog.setContentText("Por favor, introduce nombre libro:");
			Optional<String> result = dialog.showAndWait();
			if (result.isPresent()) {
				nombre = result.get().trim();
				if (!nombre.isBlank()) {
					valid = true;
				} else {
					System.err.println("Nombre no valido");
				}
			}
		}
		//TODO
		GestionLibros.addLibro(0, nombre, null, null, 0);
	}
	
	public void initialize() {
		PersistenciaDatos.recuperarLibros();
		PersistenciaDatos.recuperarPrestamos();
	}

}
