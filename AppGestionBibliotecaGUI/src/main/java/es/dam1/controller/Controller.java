package es.dam1.controller;

import java.util.List;

import es.dam1.app.Biblioteca;
import es.dam1.dao.GestionLibros;
import es.dam1.model.Libro;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Paint;

public class Controller {

	@FXML
	private Label resultado;
	@FXML
	private Label listaLibros;
	@FXML
	private Button siguientesLibros;

	public void initialize() {
		resultado.setText(Biblioteca.numeroLibrosRecuperados + " libros recuperados\n" + Biblioteca.numeroPrestamosRecuperados + " préstamos recuperados");
	}

	@FXML
	public void addLibro() {
		if (ServiceController.getDataAndAddLibro()) {
			resultado.setText("Libro añadido");
			resultado.setTextFill(Paint.valueOf("black"));
		} else {
			resultado.setText("Ese ISBN ya existe, no se pudo añadir el libro");
			resultado.setTextFill(Paint.valueOf("red"));
		}
	}

	@FXML
	public void mostrarPrimerosLibros() {
		siguientesLibros.setDisable(true);
		List<Libro> listadoLibros = ServiceController.listadoPrimerosLibros();
		if (listadoLibros != null) {
			String lista = "";
			for (Libro l : listadoLibros) {
				lista += l + "\n";
			}
			if (GestionLibros.listadoLibros().size() > ServiceController.sizeListado) {
				siguientesLibros.setDisable(false);
			}
			listaLibros.setText(lista);
		}
	}

	@FXML
	public void mostrarSiguientesLibros() {
		List<Libro> listadoLibros = ServiceController.listadoSiguientesLibros();
		String lista = "";
		for (Libro l : listadoLibros) {
			lista += l + "\n";
		}
		listaLibros.setText(lista);
	}
	
	@FXML
	public void eliminarLibro() {
		siguientesLibros.setDisable(true);
		if (ServiceController.eliminarLibro()) {
			resultado.setText("Libro eliminado correctamente");
			resultado.setTextFill(Paint.valueOf("black"));
		} else {
			resultado.setText("No se encontró el libro a eliminar");
			resultado.setTextFill(Paint.valueOf("red"));
		}
	}
	
	@FXML
	public void mostrarLibrosPorNombre() {
		siguientesLibros.setDisable(true);
		List<Libro> librosNombre = ServiceController.buscarLibrosPorNombre();
		if (librosNombre != null) {
			String result = "Listado libros por nombre\n";
			for (Libro l : librosNombre) {
				result += l + "\n";
			}
			listaLibros.setText(result);
		} else {
			resultado.setText("No hay libros con ese nombre");
			resultado.setTextFill(Paint.valueOf("red"));
		}
	}
	
	@FXML
	public void mostrarLibrosPorCategoria() {
		siguientesLibros.setDisable(true);
		List<Libro> librosCategoria = ServiceController.buscarLibrosPorCategoria();
		if (librosCategoria != null) {
			String result = "Listado libros por categoría\n";
			for (Libro l : librosCategoria) {
				result += l + "\n";
			}
			listaLibros.setText(result);
		} else {
			resultado.setText("No hay libros con esa categoría");
			resultado.setTextFill(Paint.valueOf("red"));
		}
	}
	
}
