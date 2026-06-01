package es.yisus.app;

import es.yisus.engine.GameEngine;
import es.yisus.modelo.User;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;

public class SnakeGame extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		// 1. Creamos un usuario de prueba (en el futuro se elegirá en un menú o vendrá de la BD)
        User testUser = new User(1, "Player_1");

        // 2. Definimos las dimensiones lógicas del tablero (columnas y filas de la cuadrícula)
        int boardWidth = 30;
        int boardHeight = 20;

        // 3. Creamos el componente Canvas donde el GameEngine pintará los gráficos
        Canvas gameCanvas = new Canvas();

        // 4. Instanciamos el GameEngine pasándole el canvas y la configuración
        // Recuerda que el constructor del motor ajustará automáticamente el ancho y alto real del Canvas
        GameEngine gameEngine = new GameEngine(gameCanvas, testUser, boardWidth, boardHeight);

        // 5. Creamos el contenedor raíz de JavaFX y le añadimos el lienzo
        Group root = new Group(gameCanvas);

        // 6. Creamos la escena pasándole el contenedor principal
        Scene scene = new Scene(root);

        // 7. CAPTURA DE TECLADO (Punto Crítico):
        // Escuchamos las pulsaciones en toda la escena y redirigimos el evento al método handleInput del motor
        scene.setOnKeyPressed(event -> gameEngine.handleInput(event));

        // 8. Configuración de la ventana principal (Stage)
        stage.setTitle("Snake Game - JavaFX");
        stage.setScene(scene);
        
        // Deshabilitamos la redimensión para que el usuario no estire la ventana y descuadre el Canvas
        stage.setResizable(false); 
        
        // Mostramos la ventana en pantalla
        stage.show();

        // 9. ¡Arrancamos el bucle del juego! La serpiente empezará a moverse sola
        gameEngine.startGame();
		
	}

}
