package es.yisus.app;

import java.io.IOException;
import es.yisus.dao.UserDAO;
import es.yisus.engine.GameEngine;
import es.yisus.modelo.Game;
import es.yisus.modelo.User;
import es.yisus.service.UserService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.stage.Stage;

public class SnakeGame extends Application {
	private static final int defaultBoardWidth = 30;
	private static final int defaultBoardHeight = 20;
//	private GUIController gc;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {

		stage.setTitle("Snake Game");
		// Deshabilitamos la redimensión para que el usuario no estire la ventana y
		// descuadre el Canvas futuro
		stage.setResizable(false);
		// Pantalla de cargado
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/WelcomeScreen.fxml"));
			Scene welcomeScreen = new Scene(loader.load());
//			gc = loader.getController();
			stage.setScene(welcomeScreen);
			System.out.println("Entre por el try");
			stage.show();
		} catch (IOException e) {
			System.err.println("Error loading welcome screen, starting new game with random user");
			System.out.println("Entre por el catch");
			e.printStackTrace();
			User randomUser = UserService.getUserByNickname("RandomUser");
			if (randomUser == null) {
				randomUser = new User("RandomUser");
				UserDAO.insertUser(randomUser);
			}
			playGame(stage, randomUser);
		}

	}

	public static void playGame(Stage stage, User user) {

		// Definimos las dimensiones lógicas del tablero (columnas y filas de la
		// cuadrícula)
		int boardWidth = defaultBoardWidth;
		int boardHeight = defaultBoardHeight;

		// Creamos el componente Canvas donde el GameEngine pintará los gráficos
		Canvas gameCanvas = new Canvas();

		// Instanciamos el GameEngine pasándole el canvas y la configuración
		// El constructor del motor ajustará automáticamente el ancho y alto real del
		// Canvas
		GameEngine gameEngine = new GameEngine(gameCanvas, user, boardWidth, boardHeight);

		// Creamos el contenedor raíz de JavaFX y le añadimos el lienzo
		Group root = new Group(gameCanvas);

		// Creamos la escena pasándole el contenedor principal
		Scene scene = new Scene(root);

		// Captura del teclado
		// Escuchamos las pulsaciones en toda la escena y redirigimos el evento al
		// método handleInput del motor
		scene.setOnKeyPressed(event -> gameEngine.handleInput(event));

		// Configuración de la ventana principal (Stage)
		stage.setScene(scene);

		// Mostramos la ventana en pantalla
		stage.show();

		// Arrancamos el bucle del juego
		gameEngine.startGame();
	}
	
	public static void playLoadedGame(Stage stage, Game loadedGame) {
	    // Reutilizamos el Canvas
	    Canvas gameCanvas = new Canvas();

	    // Usamos un constructor especial del motor (que añadiremos en el Paso 3)
	    GameEngine gameEngine = new GameEngine(gameCanvas, loadedGame);

	    Group root = new Group(gameCanvas);
	    Scene scene = new Scene(root);
	    
	    scene.setOnKeyPressed(event -> gameEngine.handleInput(event));
	    stage.setScene(scene);
	    stage.show();

	    // Arrancamos el bucle
	    gameEngine.startGame();
	}

}

// For debugging, uncomment next line. Right click on SnakeGame project and Debug as Java Application
class SnakeGameLauncher {public static void main(String[] args) {SnakeGame.main(args);}}
