package es.dam1.app;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage stage) throws Exception {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI.fxml"));
			Scene scene = new Scene(loader.load());
			stage.setTitle("Ejercicio apertura ficheros");
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			System.err.println("Error al cargar la escena");
			e.printStackTrace();
		}
	}

}
