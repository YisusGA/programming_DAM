package es.dam1.controller;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

public class ControllerNewMovimiento {
	private ObservableList<String> tiposMovimiento = FXCollections.observableArrayList();
	
	@FXML
	private TextField isbnTxt;
	@FXML
	private TextField numCopiasTxt;
	@FXML
	private TextField fechaTxt;
	@FXML
	private ComboBox<String> tipoTxt;
	@FXML
	private Label resultadoMovimiento;
	
	@FXML
	public void initialize() {
		tiposMovimiento.add("Prestamo");
		tiposMovimiento.add("Devolucion");
		tipoTxt.setItems(tiposMovimiento);
	}
	
	@FXML
	public void registrarMovimiento(ActionEvent event) {
		String isbn = isbnTxt.getText().trim();
		String numCopias = numCopiasTxt.getText().trim();
		String fecha = fechaTxt.getText().trim();
		String tipo = tipoTxt.getValue();
		
		boolean registrado = ServiceController.registrarMovimiento(isbn, numCopias, fecha, tipo);
		
		if (!registrado) {
			resultadoMovimiento.setText("No se pudo registrar el movimiento");
			resultadoMovimiento.setTextFill(Paint.valueOf("red"));
		} else {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI.fxml"));
			Button button = (Button) event.getSource();
			Stage stage = (Stage) button.getScene().getWindow();
			try {
				Scene scene = new Scene(loader.load());
				stage.setScene(scene);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	@FXML
	public void goBack(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI.fxml"));
		Button button = (Button) event.getSource();
		Stage stage = (Stage) button.getScene().getWindow();
		try {
			Scene scene = new Scene(loader.load());
			stage.setScene(scene);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
