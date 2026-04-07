package es.dam1.app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import es.dam1.RespuestaClickBoton;

public class PrimeraVentana extends Application {

	@Override
	public void start(Stage Stage) throws Exception {

		// Creamos un panel
		BorderPane panel = new BorderPane();

		// Creamos una escena y la vinculamos al panel
		Scene escena = new Scene(panel, 400, 400);

		// Creamos un botón y le agregamos elementos como texto y estilos
		Button boton = new Button();
		boton.setBorder(Border.stroke(Paint.valueOf("cyan")));
		boton.setText("SOY UN BOTÓN");
		boton.setBackground(Background.fill(Paint.valueOf("crimson")));

		// El método setOnAction toma como evento la acción por defecto del elemento.
		// Que en el caso del botón, es un mouse click. Y metemos entre paréntesis lo
		// que queremos que se ejecute al recibir el evento. Si empezamos escribiendo
		// boton.setOn..., nos saldrán los distintos eventos, siendo uno de ellos el
		// setOnMouseClicked. Aunque en este caso, como se ha comentado, el setOnAction
		// resuelve el asunto
		boton.setOnAction(new RespuestaClickBoton()); // Metemos entre paréntesis una clase con mi código

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
