package es.dam1.app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import es.dam1.RespuestaClickBoton;

public class PrimeraVentana extends Application {

	@Override
	public void start(Stage Stage) throws Exception {

		// Creamos un panel
		BorderPane panel = new BorderPane();

		// Creamos una escena y la vinculamos al panel
		Scene escena = new Scene(panel, 400, 400);

		// Creamos un botón
		Button boton = new Button();
		boton.setBorder(Border.EMPTY);
		boton.setText("SOY UN BOTÓN");
		boton.setBackground(Background.EMPTY);

		// El método setOnAction toma como evento la acción por defecto del elemento.
		// Que en el caso del botón, es un mouse click. Y metemos entre paréntesis lo
		// que queremos que se ejecute al recibir el evento
		boton.setOnAction(new RespuestaClickBoton());

		// Situamos el botón en el panel
		panel.setLeft(boton);

		// Asociamos la escena al Stage
		Stage.setScene(escena);
		Stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
