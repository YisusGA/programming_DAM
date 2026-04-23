package es.dam1.controller;

import java.util.List;

import es.dam1.dao.GestionLibros;
import es.dam1.data.PersistenciaDatos;
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
		resultado.setText(PersistenciaDatos.recuperarLibros() + " libros recuperados\n" + PersistenciaDatos.recuperarPrestamos() + " préstamos recuperados");
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
}
