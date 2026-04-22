package es.dam1.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;

import es.dam1.dao.GestionLibros;
import es.dam1.data.PersistenciaDatos;
import es.dam1.model.Libro;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.paint.Paint;

public class Controller {
	private static int contador = 0;
	
	@FXML
	Label resultado;
	@FXML
	Label listaLibros;
	
	public void initialize() {
		PersistenciaDatos.recuperarLibros();
		PersistenciaDatos.recuperarPrestamos();
	}
	
	@FXML
	public void addLibro() {
		int isbn = 0;
		String nombre = "";
		String descripcion = "";
		String categoria = "";
		int stock = 0;
		TextInputDialog dialog = new TextInputDialog();
		dialog.setTitle("Añadir libro");
		dialog.setHeaderText(" ");
		boolean valid = false;
		while (!valid) {
			dialog.setContentText("Por favor, introduce ISBN del libro:");
			Optional<String> result = dialog.showAndWait();
			String isbnAux = result.get().trim();
			try {
				isbn = Integer.parseInt(isbnAux);
				valid = true;
			} catch (NumberFormatException e) {
				System.err.println("Numero no valido");
			}
		} 
		valid = false;
		while (!valid) {
			dialog.setContentText("Por favor, introduce nombre del libro:");
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
		valid = false;
		while (!valid) {
			dialog.setContentText("Por favor, introduce descripción del libro:");
			Optional<String> result = dialog.showAndWait();
			if (result.isPresent()) {
				descripcion = result.get().trim();
				if (!descripcion.isBlank()) {
					valid = true;
				} else {
					System.err.println("Descripción no valida");
				}
			}
		}
		valid = false;
		while (!valid) {
			dialog.setContentText("Por favor, introduce categoría del libro:");
			Optional<String> result = dialog.showAndWait();
			if (result.isPresent()) {
				categoria = result.get().trim();
				if (!categoria.isBlank()) {
					valid = true;
				} else {
					System.err.println("Categoria no valida");
				}
			}
		}
		valid = false;
		while (!valid) {
			dialog.setContentText("Por favor, introduce stock del libro:");
			Optional<String> result = dialog.showAndWait();
			String stockAux = result.get().trim();
			try {
				stock = Integer.parseInt(stockAux);
				valid = true;
			} catch (NumberFormatException e) {
				System.err.println("Numero no valido");
			}
		}
		if (GestionLibros.addLibro(isbn, nombre, descripcion, categoria, stock)) {
			resultado.setText("Libro añadido");
			resultado.setTextFill(Paint.valueOf("black"));
		} else {
			resultado.setText("Ese ISBN ya existe, no se pudo añadir el libro");
			resultado.setTextFill(Paint.valueOf("red"));
		}
	}
	
	public void listarLibros() {
		// NO FUNCIONA DEL TODO BIEN AÚN
		List<Libro> listadoLibros = new ArrayList<>();
		listadoLibros.addAll(GestionLibros.listadoLibros());
		if (listadoLibros != null) {
			String lista = "";
			for (int i = 0; i < 10 && i < listadoLibros.size() && contador < listadoLibros.size(); i++, contador++) {
				if (contador == listadoLibros.size() -1) {
					contador = 0;
				}
				lista += listadoLibros.get(contador).toString() + "\n";
			}
			listaLibros.setText(lista);
		}
	}
}
