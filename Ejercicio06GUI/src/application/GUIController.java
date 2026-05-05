package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class GUIController {
	private Double x;
	private Double y;

	@FXML
	Label coordenadasTxt;
	@FXML
	Pane mainPane;

	@FXML
	public void mostrarCoordenadas(MouseEvent event) {
		x = event.getX();
		y = event.getY();
		coordenadasTxt.setText("" + x + ", " + y);
	}

	@FXML
	public void addButton(KeyEvent event) {
		// IMPORTANTE: El evento que debemos poner en el FXML sobre el panel para lanzar
		// este método es On Key Pressed, pues On Key Typed suele dar más problemas
		if (x != null && y != null) {
			Button boton = new Button(event.getCode().toString());
			boton.setLayoutX(x);
			boton.setLayoutY(y);
			// IMPORTANTE: Para añadir un botón a un panel, debemos primero pillar sus hijos
			// y luego añadirlo sobre eso
			mainPane.getChildren().add(boton);
		}
	}

}
