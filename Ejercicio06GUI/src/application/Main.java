package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.fxml.FXMLLoader;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("GUI.fxml"));
			// Es fundamental que el Pane se cree aquí, para poder hacer el requestFocus()
			// tras mostrar el primaryStage
			Pane root = loader.load();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
			// Un Pane por defecto, no tiene capacidad de tener el foco. Hay que usar sobre
			// él el método requestFocus(), en el método start() de la clase principal y
			// tras lanzar primaryStage.show(), para que realmente funcione lo de que el
			// Pane tenga el foco
			root.requestFocus();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
