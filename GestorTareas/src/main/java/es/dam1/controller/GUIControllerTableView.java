package es.dam1.controller;

import java.io.IOException;
import java.time.LocalDate;

import es.dam1.logica.LogicaTareas;
import es.dam1.model.Tarea;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class GUIControllerTableView {

	LogicaTareas logicaTareas = new LogicaTareas();

	@FXML
	private TableView<Tarea> tabla; // El compilador nos avisa de que debemos parametrizarla

	// Columnas de la tabla
	@FXML
	private TableColumn<Tarea, String> colNombre; // Dos parámetros necesarios, la clase de los objetos de la tabla, y
	@FXML
	private TableColumn<Tarea, LocalDate> colFecha;

	@FXML
	public void initialize() {
		// Le decimos a cada columna qué propiedad de Tarea tiene que mostrar
		colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		colFecha.setCellValueFactory(new PropertyValueFactory<>("fechaLimite"));

//		// PRUEBA
//		Tarea prueba = new Tarea();
//		prueba.setId(1);
//		prueba.setNombre("Comer");
//		prueba.setDescripcion("Macarrones");
//		prueba.setFechaLimite(LocalDate.parse("2027-03-01"));
//		prueba.setCompletada(false);
//		tareas.add(prueba);
//		tabla.setItems(tareas);

	}

	// Mismo método para los 3 botones (añadir, eliminar y completar tarea).
	// Capturamos el evento para detectar el botón que se ha pulsado de los 3
	@FXML
	public void accionTarea(ActionEvent event) {
		Tarea tareaSeleccionada = tabla.getSelectionModel().getSelectedItem();
		Button button = (Button) event.getSource();
		String textoBoton = button.getText();
		switch (textoBoton) {
		case "Añadir tarea" -> {
			// Pillamos el Stage del programa
			Stage stage = (Stage) ((Node) button).getScene().getWindow(); // Se castea el botón a Nodo, y de ahí se saca
																			// su Scene, y de su Scene se saca su
																			// Window. Y esa Window se castea a Stage, y
																			// se almacena dentro de un objeto Stage
			// Cargamos la nueva interfaz gráfica
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUIControllerAddTarea.fxml"));
			// Creamos una nueva escena
			Scene escenaAddTarea = null;
			try {
				// A esa escena le cargamos la interfaz gráfica
				escenaAddTarea = loader.load();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// Y cambiamos en el stage la escena a la nueva escena que hemos creado
			stage.setScene(escenaAddTarea);

		}
		case "Completar tarea" -> {
			if (tareaSeleccionada != null) {
				logicaTareas.completarTarea(tareaSeleccionada.getId());
			}
		}
		case "Eliminar tarea" -> {
			if (tareaSeleccionada != null) {
				logicaTareas.eliminarTarea(tareaSeleccionada.getId());
			}
		}
		}
	}

	@FXML
	public void mostrarTarea() {
		Tarea tareaSeleccionada = tabla.getSelectionModel().getSelectedItem();

		// Alerta de JavaFX
		// 1. Crear la instancia definiendo el tipo (CONFIRMATION, ERROR, INFORMATION,
		// NONE, WARNING)
		Alert alerta = new Alert(Alert.AlertType.INFORMATION); // Hay varios tipos de Alert, podemos probar a poner otro
																// tipo en lugar de INFORMATION

		// 2. Configurar los textos
		alerta.setTitle("DATOS TAREA");
		alerta.setHeaderText(null);
		alerta.setContentText(tareaSeleccionada.getDescripcion() + " "
				+ (tareaSeleccionada.isCompletada() ? "Completada" : "Pendiente"));

		// 3. Mostrar y esperar respuesta
		alerta.showAndWait();
	}

}
