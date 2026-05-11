package es.dam1.app;

import java.io.IOException;

import es.dam1.controller.GUIController;
import es.dam1.controller.ServiceController;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;

public class EditorTxt extends Application {
	@Override
	public void start(Stage stage) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI.fxml"));
		Scene scene = null;
		try {
			scene = new Scene(loader.load());
		} catch (IOException e) {
			System.err.println("Error al cargar el fichero fxml");
			// e.printStackTrace();
		}
		// Cargamos el controlador que JavaFX está mostrando en pantalla
		GUIController controller = loader.getController();
		// Y se lo damos a la clase ServiceController
		ServiceController.setController(controller);
		stage.setTitle("Editor de texto");
		stage.setScene(scene);
		stage.show();
		// El método setOnCloseRequest de Stage trabaja con un EventHandler. El
		// EventHandler es una interface funcional que recibe un evento, y ese evento se
		// lo pasa a la lista de instrucciones/método que nosotros pongamos a la derecha
		// de la flecha. En este caso, el EventHandler le pasa el evento a mi método
		// ServiceController.confirmarSalida(event), que necesita en concreto un
		// WindowEvent para funcionar. Como llamamos a este método a través de un
		// WindowEvent, nos aseguramos de que efectivamente va a ser eso
		stage.setOnCloseRequest(event -> ServiceController.confirmarSalida(event));
	}

	public static void main(String[] args) {
		launch(args);
	}
}
