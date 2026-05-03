package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Paint;

public class GUIController {

	ObservableList<String> provincias = FXCollections.observableArrayList();

	@FXML
	TextField nombreTxt;
	@FXML
	TextField apellidosTxt;
	@FXML
	ComboBox<String> provinciaTxt;
	@FXML
	ToggleGroup generoTxt;
	@FXML
	Label result;

	@FXML
	public void initialize() {
		provincias.add("Madrid");
		provincias.add("Barcelona");
		provinciaTxt.setItems(provincias);
	}

	@FXML
	public void validarFormulario() {
		String nombre = "";
		String apellidos = "";
		String provincia = provinciaTxt.getValue();
		RadioButton selectedGenre = (RadioButton) generoTxt.getSelectedToggle();
		String genero = null;
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		if (selectedGenre != null && !(nombre = nombreTxt.getText().trim()).isBlank()
				&& !(apellidos = apellidosTxt.getText().trim()).isBlank() && provincia != null) {
			result.setText("");
			genero = selectedGenre.getText();
			String mensaje = String.format("""
					Nombre: %s
					Apellidos: %s
					Provincia: %s
					Género: %s
					""", nombre, apellidos, provincia, genero);
			ServiceController.guardarDatos(nombre, apellidos, provincia, genero);
			alert.setTitle("Formulario completo");
			alert.setHeaderText("Datos introducidos");
			alert.setContentText(mensaje);
			alert.showAndWait();
			nombreTxt.clear();
			apellidosTxt.clear();
			provinciaTxt.setValue(null);
			generoTxt.selectToggle(null);
		} else {
			result.setText("Debes rellenar todos los campos");
			result.setTextFill(Paint.valueOf("red"));
		}
	}
}
