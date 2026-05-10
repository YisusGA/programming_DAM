package es.dam1.controller;

import java.io.IOException;

import es.dam1.logica.LogicaTareas;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class GUIControllerAddTarea {

	@FXML
	TextField nombre;
	@FXML
	TextField descripcion;
	@FXML
	TextField fecha;

	@FXML
	Label resultadoAddTarea;
	
	@FXML
	public void initialize() {

	}
	
	public boolean addTarea(ActionEvent event) {
		String nombreLeido = nombre.getText();
		String descripcionLeida = descripcion.getText();
		String fechaLeida = fecha.getText();
		
		boolean added = LogicaTareas.addTarea(nombreLeido, descripcionLeida, fechaLeida);

		if (added) { // Si se añadió la tarea con éxito, se devuelve a la anterior escena (la de la tabla)
			
			Button botonAdd = (Button) event.getSource();
			Stage stage = (Stage) botonAdd.getScene().getWindow();
			// Cargamos la nueva interfaz gráfica
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUITareas.fxml"));
			try {
				// Creamos una nueva escena y le cargamos la interfaz gráfica
				Scene escenaTareas = new Scene(loader.load());
				// Y cambiamos en el stage la escena a la nueva escena que hemos creado
				stage.setScene(escenaTareas);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			resultadoAddTarea.setText("No se pudo añadir la tarea, prueba de nuevo");
			resultadoAddTarea.setTextFill(Paint.valueOf("red"));
		}

		return added;
	}

}
