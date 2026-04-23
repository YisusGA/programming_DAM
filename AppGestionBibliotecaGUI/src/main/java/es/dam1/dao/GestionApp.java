package es.dam1.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import es.dam1.model.Libro;
import javafx.scene.control.TextInputDialog;

public class GestionApp {
	private static int contador = 0;
	private static TextInputDialog dialog;

	public static List<Libro> listado10PrimerosLibros() {
		contador = 0;
		List<Libro> listadoLibros = GestionLibros.listadoLibros();
		List<Libro> listado10Libros = null;
		if (listadoLibros != null) {
			listado10Libros = new ArrayList<>();
			for (int i = 0; i < listadoLibros.size() && i < 10; i++, contador++) {
				listado10Libros.add(listadoLibros.get(i));
			}
		}
		return listado10Libros;
	}

	public static List<Libro> listadoSiguientesLibros() {
		List<Libro> listadoLibros = GestionLibros.listadoLibros();
		List<Libro> listadoSiguientesLibros = new ArrayList<>();
		for (int i = 0; contador < listadoLibros.size() && i < 10; i++, contador++) {
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

		dialog.setContentText("Por favor, introduce stock del libro:");
		int stock = readIntFromTextInput();

		dialog.setContentText("Por favor, introduce nombre del libro:");
		String nombre = readTextFromTextInput();

		dialog.setContentText("Por favor, introduce descripción del libro:");
		String descripcion = readTextFromTextInput();

		dialog.setContentText("Por favor, introduce categoría del libro:");
		String categoria = readTextFromTextInput();

		if (GestionLibros.addLibro(isbn, nombre, descripcion, categoria, stock)) {
			added = true;
		}
		return added;
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
