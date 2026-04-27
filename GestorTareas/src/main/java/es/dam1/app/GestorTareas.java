package es.dam1.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GestorTareas extends Application {

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage stage) throws Exception { // Este objeto Stage que recibe el método start(Stage stage) lo
														// crea automáticamente JavaFX Runtime (el motor de la
														// plataforma) al arrancar la app
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUITareas.fxml"));
		Scene scene = new Scene(loader.load());
		stage.setTitle("Gestor de tareas");
		stage.setScene(scene);
		stage.show();
	}

}
