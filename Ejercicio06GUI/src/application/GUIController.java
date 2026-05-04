package application;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class GUIController {

	@FXML
	Label coordenadasTxt;
	@FXML
	Pane panel;

	public void mostrarCoordenadas(MouseEvent event) {
		Double x = event.getX();
		Double y = event.getY();
		if (x != null && y != null) {
			coordenadasTxt.setText("" + x + ", " + y);
		}
	}
	
	public void addButton(MouseEvent eventM, KeyEvent eventK) {
		Double x = eventM.getX();
		Double y = eventM.getY();
		if (x != null && y != null) {
			Button boton = new Button("X");
//			panel = (Pane) eventK.getSource();
			System.out.println(eventK.getSource());
		}
	}
}
