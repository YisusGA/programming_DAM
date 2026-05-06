package es.dam1.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class GUIController {
	private ObservableList<String> meses = FXCollections.observableArrayList();
	private ObservableList<String> dias = FXCollections.observableArrayList();

	@FXML
	private ComboBox<String> comboMes;
	@FXML
	private ComboBox<Integer> comboDia;
	@FXML
	private TextField gastoTxt;

	@FXML
	public void initialize() {
		meses.addAll("Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre",
				"Noviembre", "Diciembre");
		comboMes.setItems(meses);

	}

	@FXML
	public void addGasto() {
		String mesSeleccionado = comboMes.getSelectionModel().getSelectedItem();
		if (mesSeleccionado != null) {
			
			comboDia.setDisable(false);
		}
	}

}
