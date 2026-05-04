package application;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;

public class GUIController {
	
	@FXML
	TextArea textArea;
	@FXML
	MenuBar menuBar;
	@FXML
	TextField rutaFichero;
	@FXML
	Label result;
	@FXML
	TabPane tabPane;
	@FXML
	Tab tabTexto;
	@FXML
	Tab tabIO;
	
	@FXML
	public void cargarFichero() {
		String ruta = rutaFichero.getText().trim();
		String texto = ServiceController.cargarDesdeFichero(ruta);
		if (texto != null) {
			textArea.setText(texto);
			result.setText("Contenido del fichero cargado con éxito");
			result.setTextFill(Paint.valueOf("black"));
			rutaFichero.clear();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			tabPane.getSelectionModel().select(tabTexto);
		} else {
			result.setText("No se pudo cargar el contenido del fichero");
			result.setTextFill(Paint.valueOf("red"));
			rutaFichero.clear();
		}
	}
	
	@FXML
	public void guardarFichero() {
		String ruta = rutaFichero.getText().trim();
		String texto = textArea.getText();
		if (!texto.isBlank()) {
			String output = ServiceController.guardarEnFichero(ruta, texto);
			if (output != null) {
				result.setText(output);
				result.setTextFill(Paint.valueOf("black"));
				rutaFichero.clear();
			} else {
				result.setText("No se pudo guardar el contenido en el fichero");
				result.setTextFill(Paint.valueOf("red"));
			}
		} else {
			result.setText("El área de texto está vacía");
			result.setTextFill(Paint.valueOf("red"));
		}
	}
	
	@FXML
	public void clearTextArea() {
		textArea.clear();
	}
}
