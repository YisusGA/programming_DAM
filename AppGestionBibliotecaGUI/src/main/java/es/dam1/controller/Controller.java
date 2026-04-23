package es.dam1.controller;

import java.util.List;
import es.dam1.dao.GestionApp;
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
		if (GestionApp.getDataAndAddLibro()) {
			resultado.setText("Libro añadido");
			resultado.setTextFill(Paint.valueOf("black"));
		} else {
			resultado.setText("Ese ISBN ya existe, no se pudo añadir el libro");
			resultado.setTextFill(Paint.valueOf("red"));
		}
	}

	@FXML
	public void mostrar10PrimerosLibros() {
		siguientesLibros.setDisable(true);
		List<Libro> listadoLibros = GestionApp.listado10PrimerosLibros();
		if (listadoLibros != null) {
			String lista = "";
			for (Libro l : listadoLibros) {
				lista += l + "\n";
			}
			if (GestionLibros.listadoLibros().size() > 10) {
				siguientesLibros.setDisable(false);
			}
			listaLibros.setText(lista);
		}
	}

	@FXML
	public void mostrarSiguientesLibros() {
		List<Libro> listadoLibros = GestionApp.listadoSiguientesLibros();
		String lista = "";
		for (Libro l : listadoLibros) {
			lista += l + "\n";
		}
		listaLibros.setText(lista);
	}
}
