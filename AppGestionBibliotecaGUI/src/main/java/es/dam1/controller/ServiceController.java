package es.dam1.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import es.dam1.dao.GestionLibros;
import es.dam1.model.Libro;
import javafx.scene.control.TextInputDialog;

public class ServiceController {
	private static int contador = 0;
	private static TextInputDialog dialog;
	static int sizeListado = 5;

	public static void setSizeListado(int sizeListado) {
		ServiceController.sizeListado = sizeListado;
	}

	public static List<Libro> listadoPrimerosLibros() {
		contador = 0;
		dialog = new TextInputDialog();
		dialog.setTitle("Tamaño vista de lista");
		dialog.setHeaderText(" ");
		dialog.setContentText("Por favor, introduce tamaño vista lista:");
		sizeListado = readIntFromTextInput();
		List<Libro> listadoLibros = GestionLibros.listadoLibros();
		List<Libro> listadoPrimerosLibros = null;
		if (listadoLibros != null) {
			listadoPrimerosLibros = new ArrayList<>();
			for (int i = 0; i < listadoLibros.size() && i < sizeListado; i++, contador++) {
				listadoPrimerosLibros.add(listadoLibros.get(i));
			}
		}
		return listadoPrimerosLibros;
	}

	public static List<Libro> listadoSiguientesLibros() {
		List<Libro> listadoLibros = GestionLibros.listadoLibros();
		List<Libro> listadoSiguientesLibros = new ArrayList<>();
		for (int i = 0; contador < listadoLibros.size() && i < sizeListado; i++, contador++) {
			listadoSiguientesLibros.add(listadoLibros.get(contador));
		}
		if (contador == listadoLibros.size()) {
			contador = 0;
		}
		return listadoSiguientesLibros;
	}

	public static boolean getDataAndAddLibro() {
		boolean added = false;

		dialog = new TextInputDialog();
		dialog.setTitle("Añadir libro");
		dialog.setHeaderText(" ");

		dialog.setContentText("Por favor, introduce ISBN del libro:");
		int isbn = readIntFromTextInput();

		dialog.setContentText("Por favor, introduce nombre del libro:");
		String nombre = readTextFromTextInput();

		dialog.setContentText("Por favor, introduce descripción del libro:");
		String descripcion = readTextFromTextInput();

		dialog.setContentText("Por favor, introduce categoría del libro:");
		String categoria = readTextFromTextInput();
		
		dialog.setContentText("Por favor, introduce stock del libro:");
		int stock = readIntFromTextInput();

		if (GestionLibros.addLibro(isbn, nombre, descripcion, categoria, stock)) {
			added = true;
		}
		return added;
	}
	
	public static boolean eliminarLibro() {
		dialog = new TextInputDialog();
		dialog.setTitle("Eliminar libro");
		dialog.setHeaderText(" ");
		
		dialog.setContentText("Por favor, introduce nombre del libro:");
		String nombre = readTextFromTextInput();
		
		boolean removed = GestionLibros.eliminarLibro(nombre);
		return removed;
	}
	
	public static List<Libro> buscarLibrosPorNombre() {
		dialog = new TextInputDialog();
		dialog.setTitle("Buscar libro por nombre");
		dialog.setHeaderText(" ");
		
		dialog.setContentText("Por favor, introduce nombre del libro:");
		String nombre = readTextFromTextInput();
		List<Libro> librosNombre = GestionLibros.buscarLibrosPorNombre(nombre);
		return librosNombre;
	}
	
	public static List<Libro> buscarLibrosPorCategoria() {
		dialog = new TextInputDialog();
		dialog.setTitle("Buscar libro por categoría");
		dialog.setHeaderText(" ");
		
		dialog.setContentText("Por favor, introduce categoría del libro:");
		String categoria = readTextFromTextInput();
		List<Libro> librosCategoria = GestionLibros.buscarLibrosPorCategoria(categoria);
		return librosCategoria;
	}

	public static String readTextFromTextInput() {
		String result = "";
		boolean valid = false;
		while (!valid) {
			dialog.getEditor().clear();
			Optional<String> input = dialog.showAndWait();
			if (input.isPresent()) {
				result = input.get().trim();
				if (!result.isBlank()) {
					valid = true;
				} else {
					System.err.println("Nombre no valido");
				}
			}
		}
		return result;
	}

	public static int readIntFromTextInput() {
		int result = 0;
		boolean valid = false;
		while (!valid) {
			dialog.getEditor().clear();
			Optional<String> input = dialog.showAndWait();
			try {
				result = Integer.parseInt(input.get().trim());
				valid = true;
			} catch (NumberFormatException e) {
				System.err.println("Numero no valido");
			}
		}
		return result;
	}

}
