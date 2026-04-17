package es.dam1.app;



import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Ventana extends Application {

	

	@Override
	public void start(Stage stage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI.fxml"));
		Scene scene = new Scene(loader.load());
		stage.setTitle("App de saludo");
		stage.setScene(scene);
		stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);

	}

}
