package es.dam1.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import es.dam1.app.Biblioteca;
import es.dam1.dao.GestionLibros;
import es.dam1.data.Inventario;
import es.dam1.model.Libro;
import es.dam1.model.Movimiento;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class Controller {
	// En este controlador mezclo cosas, para trabajar con una lista no observable
	// de libros (obtenida a partir de un Map) que se muestra en un TextArea y para
	// trabajar con una lista observable de préstamos que se muestra en una
	// TableView. El objetivo de hacer esta mezcla es practicar varias cosas. Lo
	// ideal en una app final sería unificar todo en un diseño común

	@FXML
	private Label resultadoLibro;
	@FXML
	private Label listaLibros;
	@FXML
	private Button siguientesLibros;
	@FXML
	private TableView<Movimiento> tablaMovimientos;
	@FXML
	private TableColumn<Movimiento, String> colLibro;
	@FXML
	private TableColumn<Movimiento, LocalDate> colFecha;

	public void initialize() {
		resultadoLibro.setText(Biblioteca.numeroLibrosRecuperados + " libros recuperados\n"
				+ Biblioteca.numeroPrestamosRecuperados + " préstamos recuperados");

		colLibro.setCellValueFactory(new PropertyValueFactory<>("nombreLibro"));
		colFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
		tablaMovimientos.setItems(Inventario.movimientos);
	}

	@FXML
	public void addLibro() {
		if (ServiceController.getDataAndAddLibro()) {
			resultadoLibro.setText("Libro añadido");
			resultadoLibro.setTextFill(Paint.valueOf("black"));
		} else {
			resultadoLibro.setText("Ese ISBN ya existe, no se pudo añadir el libro");
			resultadoLibro.setTextFill(Paint.valueOf("red"));
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
			resultadoLibro.setText("Libro eliminado correctamente");
			resultadoLibro.setTextFill(Paint.valueOf("black"));
		} else {
			resultadoLibro.setText("No se encontró el libro a eliminar");
			resultadoLibro.setTextFill(Paint.valueOf("red"));
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
			resultadoLibro.setText("No hay libros con ese nombre");
			resultadoLibro.setTextFill(Paint.valueOf("red"));
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
			resultadoLibro.setText("No hay libros con esa categoría");
			resultadoLibro.setTextFill(Paint.valueOf("red"));
		}
	}

	@FXML
	public void registrarMovimiento(ActionEvent event) {
		Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUINewMovimiento.fxml"));
		try {
			Scene scene = new Scene(loader.load());
			stage.setScene(scene);
		} catch (IOException e) {
			// TODO
			e.printStackTrace();
		}
	}

	public void clicksRaton(MouseEvent event) {
		int numberClicks = event.getClickCount();
		if (numberClicks == 2) {
			mostrarMovimiento();
		}
	}

	@FXML
	public void mostrarMovimiento() {
		Movimiento movimientoSeleccionado = tablaMovimientos.getSelectionModel().getSelectedItem();

		if (movimientoSeleccionado != null) {
			// Alerta de JavaFX
			// 1. Crear la instancia definiendo el tipo (CONFIRMATION, ERROR, INFORMATION,
			// NONE, WARNING)
			Alert alerta = new Alert(Alert.AlertType.INFORMATION);
			// 2. Configurar los textos
			alerta.setTitle("DATOS PRÉSTAMO");
			alerta.setHeaderText(null);
			String mensaje = String.format("""
					ID: %d
					Nombre libro: %s
					Num copias: %d
					Fecha: %s
					Tipo: %s
					""", movimientoSeleccionado.getIdMovimiento(), movimientoSeleccionado.getLibro().getNombre(),
					movimientoSeleccionado.getCantidad(), movimientoSeleccionado.getFecha().toString(),
					movimientoSeleccionado.getTipoMovimiento().name());
			alerta.setContentText(mensaje);
			alerta.setResizable(true);

			// 3. Mostrar y esperar respuesta
			alerta.showAndWait();
			// Deseleccionamos la tarea
			tablaMovimientos.getSelectionModel().clearSelection();
		}
	}

}
