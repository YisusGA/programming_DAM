package es.dam1.controller;

import es.dam1.data.GestionPaises;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

public class Controller {
	GestionPaises data = new GestionPaises();
	ObservableList<String> listaPaises;
	
	@FXML
	ComboBox<String> comboBoxPaises;
	
	@FXML
	TextArea result;
	
	
	@FXML
	public void getHabitantes() {
		long numHabitantes = data.getPaises().get(comboBoxPaises.getValue());
		result.setText("El número de habitantes de " + comboBoxPaises.getValue() + " es " + numHabitantes);
	}
	
	@FXML
	public void initialize() {
		listaPaises = FXCollections.observableArrayList(data.getPaises().keySet());
		comboBoxPaises.setItems(listaPaises);		
	}

}
