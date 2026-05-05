package application;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class GUIController {
	private Double x;
	private Double y;
	private Label coordenadasTxt;
	private Pane pane;

	public GUIController() {
	}

	public Label getCoordenadasTxt() {
		return coordenadasTxt;
	}

	public void setCoordenadasTxt(Label coordenadasTxt) {
		this.coordenadasTxt = coordenadasTxt;
	}

	public Pane getPane() {
		return pane;
	}

	public void setPane(Pane pane) {
		this.pane = pane;
	}

	public void mostrarCoordenadas(MouseEvent event) {
		x = event.getX();
		y = event.getY();
		coordenadasTxt.setText("" + x + ", " + y);
	}

	public void addButton(KeyEvent event) {
		if (x != null && y != null) {
			Button boton = new Button(event.getCode().toString());
			boton.setLayoutX(x);
			boton.setLayoutY(y);
			pane.getChildren().add(boton);
		}
	}

}
