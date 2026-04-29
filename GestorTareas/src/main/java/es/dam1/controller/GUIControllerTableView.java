package es.dam1.controller;

import java.io.IOException;
import java.time.LocalDate;
import es.dam1.data.Data;
import es.dam1.logica.LogicaTareas;
import es.dam1.model.Tarea;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class GUIControllerTableView {

	@FXML
	private TableView<Tarea> tabla; // El compilador nos avisa de que debemos parametrizarla

	// Columnas de la tabla
	@FXML
	private TableColumn<Tarea, String> colNombre; // Dos parámetros necesarios, la clase de los objetos de la tabla, y el tipo de dato a mostrar en la columna
	@FXML
	private TableColumn<Tarea, LocalDate> colFecha;

	@FXML
	public void initialize() {
		// Le decimos a cada columna qué propiedad de Tarea tiene que mostrar
		colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
		colFecha.setCellValueFactory(new PropertyValueFactory<>("fechaLimite"));

		tabla.setItems(Data.tareas);

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
			Stage stage = (Stage) button.getScene().getWindow(); // Se pilla la escena de la que viene el botón, y la
																	// ventana de la que viene esa escena. Y eso se
																	// castea a Stage y se almacena en un objeto Stage.
																	// No hace falta castear button a Node, pues un
																	// botón ya es un Node
			// Cargamos la nueva interfaz gráfica
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUIAddTarea.fxml"));
			try {
				// Creamos una nueva escena y le cargamos la interfaz gráfica
				Scene escenaAddTarea = new Scene(loader.load());
				// Y cambiamos en el stage la escena a la nueva escena que hemos creado
				stage.setScene(escenaAddTarea);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		case "Cambiar estado tarea" -> {
			if (tareaSeleccionada != null) {
				LogicaTareas.cambiarEstadoTarea(tareaSeleccionada.getId());
				// TODO meter tachado de texto en tarea completada
				tabla.getSelectionModel().selectedItemProperty();
			}
		}
		case "Eliminar tarea" -> {
			if (tareaSeleccionada != null) {
				LogicaTareas.eliminarTarea(tareaSeleccionada.getId());
			}
		}
		}
	}

	public void clicksRaton(MouseEvent event) {
		int numberClicks = event.getClickCount();
		if (numberClicks == 2) {
			mostrarTarea();
		}
	}

	@FXML
	public void mostrarTarea() {
		Tarea tareaSeleccionada = tabla.getSelectionModel().getSelectedItem();

		if (tareaSeleccionada != null) {
			// Alerta de JavaFX
			// 1. Crear la instancia definiendo el tipo (CONFIRMATION, ERROR, INFORMATION,
			// NONE, WARNING)
			Alert alerta = new Alert(Alert.AlertType.INFORMATION); // Hay varios tipos de Alert, podemos probar a poner
																	// otro
																	// tipo en lugar de INFORMATION

			// 2. Configurar los textos
			alerta.setTitle("DATOS TAREA");
			alerta.setHeaderText(null);
			alerta.setContentText(tareaSeleccionada.getDescripcion() + " "
					+ (tareaSeleccionada.isCompletada() ? "Completada" : "Pendiente"));

			// 3. Mostrar y esperar respuesta
			alerta.showAndWait();
			// Deseleccionamos la tarea
			tabla.getSelectionModel().clearSelection();
		}
	}

}
