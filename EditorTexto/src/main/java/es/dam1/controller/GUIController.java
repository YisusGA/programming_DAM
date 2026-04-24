package es.dam1.controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

public class GUIController {
	private File file;
	private boolean opened = false;

	@FXML
	TextArea textArea;

	public void openFile() {
		// 1. Crear el selector de archivos
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Buscar archivo de texto");

		// 2. Agregar un filtro para archivos .txt
		fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Archivos de Texto", "*.txt"));

		// 3. Mostrar el diálogo de "Abrir"
		File selectedFile = fileChooser.showOpenDialog(null);

		// 4. Verificar si el usuario seleccionó algo
		if (selectedFile != null) {
			try {
				// Leer todo el contenido del archivo
				file = new File(selectedFile.toPath().toString());
				String contenido = Files.readString(selectedFile.toPath());

				// 5. Cargar el contenido en el TextArea
				textArea.setText(contenido);

				opened = true;

			} catch (IOException e) {
				System.err.println("Error al leer el archivo: " + e.getMessage());
			}
		} else {
			System.out.println("Operación cancelada por el usuario.");
		}

	}

	@FXML
	private void save() {
		String text = textArea.getText();
		if (opened) {
			File temp = new File(file.getParent() + "temp.txt");
			try (FileWriter fw = new FileWriter(temp)) {
				fw.write(text);
			} catch (IOException e) {
				System.out.println("Error de escritura");
				e.printStackTrace();
			}
			file.delete();
			temp.renameTo(file);
			opened = false;
		} else {
			FileChooser fileChooser = new FileChooser();
			fileChooser.setTitle("Guardar archivo de texto");

			// 2. Agregar un filtro para archivos .txt
			fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Archivos de Texto", "*.txt"));

			// 3. Mostrar el diálogo de "Guardar"
			File selectedFile = fileChooser.showSaveDialog(null);
			
			if (selectedFile != null) {
				try (FileWriter fw = new FileWriter(selectedFile)) {
					fw.write(text);
				} catch (IOException e) {
					System.out.println("Error de escritura");
					e.printStackTrace();
				}
			}
			
		}
	}

}
