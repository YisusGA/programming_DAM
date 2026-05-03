package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Parent;


public class Main extends Application {
	@Override
	public void start(Stage stage) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("GUI.fxml"));
		Parent root;
		try {
			root = loader.load();
			Scene scene = new Scene(root, 640, 480);
			stage.setTitle("Gestor de alumnos");
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			// TODO
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
