package es.dam1.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Ventana extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI.fxml"));
		// A diferencia de lo que vi con Stefano, en el que creábamos un objeto Parent
		// (superclase de todos los nodos) y luego le dábamos ese nodo raíz a la escena,
		// en este caso lo que hacemos es alimentar la escena con el nodo raíz que
		// cargue automáticamente desde el fichero fxml. Y en el fxml, el nodo raíz será
		// el que hayamos creado con SceneBuilder. De esta forma, nos ahorramos tener
		// que meter en el código el tipo de nodo raíz (Parent, BorderPane, AnchorPane,
		// etc.) que queremos usar, pues lo carga automáticamente desde el fxml
		Scene scene = new Scene(loader.load());
		stage.setTitle("App de saludo");
		stage.setScene(scene);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);

	}

}
