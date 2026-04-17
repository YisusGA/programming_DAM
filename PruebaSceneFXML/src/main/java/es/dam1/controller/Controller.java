package es.dam1.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.paint.Paint;

public class Controller {

	@FXML
	Label mensaje;
	
	@FXML
	public void saluda() {
		mensaje.setText("HOLA");
		mensaje.setTextFill(Paint.valueOf("purple"));
	}
}
