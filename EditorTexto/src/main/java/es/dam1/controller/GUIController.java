package es.dam1.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

import es.dam1.logica.GestorFicheros;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Paint;
import javafx.stage.FileChooser;

public class GUIController {

	GestorFicheros gestor = new GestorFicheros();

	@FXML
	TextArea textArea;
	@FXML
	Label panelMensajes;

	public void openFile() {
		// Crear el selector de archivos
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Buscar archivo de texto");
		// Agregar un filtro para archivos .txt
		fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Archivos de Texto", "*.txt"));
		// Mostrar el diálogo de "Abrir"
		File selectedFile = fileChooser.showOpenDialog(null);
		// Verificar si el usuario seleccionó algo
		if (selectedFile != null) {
			gestor.setFile(new File(selectedFile.toPath().toString()));
			// Leer todo el contenido del archivo y cargarlo en el TextArea
			String textRead = gestor.read();
			if (textRead != null) {
				textArea.setText(textRead);
				// Actualizar el booleano de que se ha abierto un fichero
				gestor.setOpened(true);
			} else {
				panelMensajes.setText("No se pudo leer el fichero");
				panelMensajes.setTextFill(Paint.valueOf("red"));
			}
		} else {
			panelMensajes.setText("Operación cancelada por el usuario");
			panelMensajes.setTextFill(Paint.valueOf("red"));
		}
	}

	@FXML
	private void save() {
		String text = textArea.getText();
		if (gestor.isOpened()) {
			if (gestor.write(text)) {
				panelMensajes.setText("Fichero guardado");
				panelMensajes.setTextFill(Paint.valueOf("black"));
			} else {
				panelMensajes.setText("No se pudo guardar el fichero");
				panelMensajes.setTextFill(Paint.valueOf("red"));
			}
		} else {
			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("Guardar archivo de texto");
			fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Archivos de Texto", "*.txt"));
			// Mostrar el diálogo de guardar
			File selectedFile = fileChooser.showSaveDialog(null);
			if (selectedFile != null) {
				gestor.setFile(selectedFile);
				gestor.write(text);
				gestor.setOpened(true);
				panelMensajes.setText("Fichero guardado");
				panelMensajes.setTextFill(Paint.valueOf("black"));
			} else {
				panelMensajes.setText("Operación cancelada por el usuario");
				panelMensajes.setTextFill(Paint.valueOf("red"));
			}

		}
	}

}
