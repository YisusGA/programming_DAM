package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class Main extends Application {
	private GUIController controller = new GUIController();

	@Override
	public void start(Stage stage) {
		try {
			// Creamos el panel y le damos la propiedad de tener el foco
			Pane pane = new Pane();
			pane.setFocusTraversable(true);
			// Creamos la etiqueta donde vamos a ir imprimiendo las coordenadas del ratón,
			// le damos una posición y se la añadimos al Pane
			Label coordenadas = new Label();
			coordenadas.setLayoutX(630);
			coordenadas.setLayoutY(54);
			pane.getChildren().add(coordenadas);
			// Etiqueta para mostrar "Coordenadas: "
			Label nameCoordenadas = new Label("Coordenadas:");
			nameCoordenadas.setLayoutX(550);
			nameCoordenadas.setLayoutY(54);
			pane.getChildren().add(nameCoordenadas);
			// Le añadimos al Pane la capacidad generación de un evento cada vez que se
			// mueva el ratón por él, y hacemos que el evento lance el método que tenemos en
			// la clase del controlador. Esto es programación funcional, y lo que estamos
			// haciendo es usar la interface EventHandler, le pasamos un MouseEvent, lo
			// gestiona con su método abstracto handle() y se lo pasa al método al que yo
			// llamo de GUIController. A la derecha de la flecha también podría pasarle las
			// instrucciones que he metido en el método, en lugar de haber hecho un método
			// aparte en otra clase. Pero quedaría más feo.
			pane.setOnMouseMoved(event -> controller.mostrarCoordenadas(event));
			// Le añadimos al Pane la capacidad de generación de un evento cada vez que se
			// pulse una tecla, y hacemos que el evento lance el método que tenemos en la
			// clase del controlador
			pane.setOnKeyPressed(event -> controller.addButton(event));
			// Usamos el setter de la clase del controlador para inicializar su propiedad
			// Pane con el Pane que hemos creado aquí
			controller.setPane(pane);
			// Usamos el setter de la clase del controlador para inicializar su propiedad
			// Label con el Label que hemos creado aquí
			controller.setCoordenadasTxt(coordenadas);
			// Creamos una Scene y la alimentamos con el Pane que creamos antes
			Scene scene = new Scene(pane, 1280, 720);
			// Por si queremos añadir un css para estilos
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			// Le pasamos la escena al stage
			stage.setScene(scene);
			// Hacemos que se muestre el stage
			stage.show();
			// Le damos la posibilidad al Pane de que pueda tener el foco, pues un Pane de
			// normal no puede tener foco. Y necesitamos que pueda tener el foco, para que
			// pueda desencadenar los eventos de movimiento de ratón y pulsación de teclas
			pane.requestFocus();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
