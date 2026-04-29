package es.dam1.controller;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import es.dam1.dao.GestionLibros;
import es.dam1.dao.GestorMovimientos;
import es.dam1.model.Libro;
import es.dam1.other.TipoMovimiento;
import javafx.scene.control.TextInputDialog;

public class ServiceController {
	// En este controlador mezclo cosas, para trabajar con una lista no observable
	// de libros (obtenida a partir de un Map) que se muestra en un TextArea y para
	// trabajar con una lista observable de préstamos que se muestra en una
	// TableView. El objetivo de hacer esta mezcla es practicar varias cosas. Lo
	// ideal en una app final sería unificar todo en un diseño común
	
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
	
	/**
	 * Método auxiliar para parsear todos los datos leídos desde los TextField de la escena de añadir movimientos
	 * @param isbnTxt el isbn del libro
	 * @param numCopiasTxt el número de copias que se devuelven/prestan del libro
	 * @param fechaTxt la fecha del movimiento
	 * @param tipoMovimientoTxt el tipo de movimiento (Prestamo/Devolucion)
	 * @return true si se pudo registrar el movimiento, false si hubo algún problema
	 */
	public static boolean registrarMovimiento(String isbnTxt, String numCopiasTxt, String fechaTxt, String tipoMovimientoTxt) {
		int isbn = parsearNumero(isbnTxt);
		int numCopias = parsearNumero(numCopiasTxt);
		LocalDate fecha = parsearFecha(fechaTxt);
		TipoMovimiento tipo = TipoMovimiento.leerTipo(tipoMovimientoTxt);
		boolean registrado = GestorMovimientos.registrarMovimiento(isbn, numCopias, fecha, tipo);
		
		return registrado;
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

	public static LocalDate parsearFecha(String fecha) {
		LocalDate fechaResult = null;
			try {
				fechaResult = LocalDate.parse(fecha);
			} catch (DateTimeParseException e) {
				System.err.println("Fecha no válida");
			}
		return fechaResult;
	}
	
	public static Integer parsearNumero(String num) {
		Integer result = null;
			try {
				result = Integer.parseInt(num);
			} catch (DateTimeParseException e) {
				System.err.println("Fecha no válida");
			}
		return result;
	}

}
