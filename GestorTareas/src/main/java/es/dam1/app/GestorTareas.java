package es.dam1.app;

import es.dam1.data.PersistenciaDatos;
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
		System.out.println("Recuperando tareas desde el fichero");
		PersistenciaDatos.recuperarTareas();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUITareas.fxml"));
		Scene scene = new Scene(loader.load());
		stage.setTitle("Gestor de tareas");
		stage.setScene(scene);
		stage.show();
	}
	
	@Override
	public void stop() {
		System.out.println("Guardando tareas en el fichero");
		PersistenciaDatos.guardarTareas();
	}

}
