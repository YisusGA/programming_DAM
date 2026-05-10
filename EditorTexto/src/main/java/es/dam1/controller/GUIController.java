package es.dam1.controller;

import java.io.File;
import java.util.Optional;

import es.dam1.logica.GestorFicheros;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Paint;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class GUIController {

	private GestorFicheros gestor = new GestorFicheros();

	@FXML
	TextArea textArea;
	@FXML
	Label panelMensajes;
	@FXML
	MenuBar menuBar;

	public void openFile() {
		// Crear el selector de archivos
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Buscar archivo de texto");
		// Agregar un filtro para archivos .txt
		fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Archivos de Texto", "*.txt"));
		// Mostrar el diálogo de "Abrir"
//		File selectedFile = fileChooser.showOpenDialog(null);
		Optional<File> selectedFile = Optional.of(fileChooser.showOpenDialog(null)); // Si lo hacemos con un Optional,
																						// evitamos null
		// Verificar si el usuario seleccionó algo
		if (selectedFile.isPresent()) {
			gestor.setFile(selectedFile.get());
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
	public void save() {
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

	@FXML
	public void saveAs() {
		String text = textArea.getText();
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

	@FXML
	public boolean saveOnExit() {
		boolean guardado = false;
		String text = textArea.getText();
		if (gestor.isOpened()) {
			if (gestor.write(text)) {
				guardado = true;
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
				guardado = true;
			}
		}
		return guardado;
	}

	@FXML
	public void salir() {
		// Este método vendría a simular que hemos hecho click en la x de la ventana,
		// permitiéndonos así lanzar la ventana de confirmación de guardado

		// No podemos asignar un id a un MenuItem, que es lo que es el File>Salir, pues
		// un MenuItem no es un Node. En su lugar, la estrategia que debemos seguir es
		// poner un On Action al MenuItem Salir que conecte con este método salir(). Y
		// asignar un id al MenuBar para poder acceder a él y conseguir el Stage al que
		// pertenece, para así poder simular el click en la x de cierre
		Stage stage = (Stage) menuBar.getScene().getWindow();
		stage.fireEvent(new WindowEvent(stage, WindowEvent.WINDOW_CLOSE_REQUEST));
	}

	@FXML
	public void toLowerCase() {
		String text = textArea.getText().toLowerCase();
		textArea.setText(text);
	}

	@FXML
	public void toUpperCase() {
		String text = textArea.getText().toUpperCase();
		textArea.setText(text);
	}

	@FXML
	public void firstCharOfEachWordToUpperCase() {
		String text = textArea.getText();
		textArea.setText("");
		String result = ServiceController.firstCharOfEachWordToUpperCase(text);
		if (result != null) {
			textArea.setText(result);
		}
	}

	@FXML
	public void mostrarInfo() {
		panelMensajes.setText("Yisus TextEditor v0.8");
	}

}
