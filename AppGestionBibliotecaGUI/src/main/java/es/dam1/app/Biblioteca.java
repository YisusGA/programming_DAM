package es.dam1.app;

import es.dam1.data.PersistenciaDatos;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Biblioteca extends Application {
	public static int numeroLibrosRecuperados;
	public static int numeroPrestamosRecuperados;

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage stage) throws Exception {
		numeroLibrosRecuperados = PersistenciaDatos.recuperarLibros();
		numeroPrestamosRecuperados = PersistenciaDatos.recuperarPrestamos();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/GUI.fxml"));
		Scene scene = new Scene(loader.load());
		stage.setTitle("Biblioteca");
		stage.setScene(scene);
		stage.show();
	}
	
	@Override
	public void stop() {
		System.out.println("Guardando datos y finalizando aplicacion...");
		PersistenciaDatos.guardarLibros();
		PersistenciaDatos.guardarPrestamos();
	}

}
