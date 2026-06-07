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
	// Dimensions of the game board, defined in number of blocks (block size in
	// pixels is defined in GameEngine class
	private static final int defaultBoardWidth = 30;
	private static final int defaultBoardHeight = 20;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {

		stage.setTitle("Snake Game");
		// Window resize is disabled
		stage.setResizable(false);
		// Welcome screen
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/WelcomeScreen.fxml"));
			Scene welcomeScreen = new Scene(loader.load());
			stage.setScene(welcomeScreen);
			stage.show();
		} catch (IOException e) {
			System.err.println("Error loading welcome screen, starting new game with random user");
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

		// Canvas is created, so that GameEngine can render graphic on it
		Canvas gameCanvas = new Canvas();

		// A new instance of GameEngine is created. GameEngine will create the actual
		// size of Canvas based provided boardWidth and boardHeight
		GameEngine gameEngine = new GameEngine(gameCanvas, user, defaultBoardWidth, defaultBoardHeight);

		// JavaFX's root container is created and fed with Canvas
		Group root = new Group(gameCanvas);

		// A new Scene is created and fed with root container
		Scene scene = new Scene(root);

		// Keyboard listener
		// It will fed the keyevent to handleInput method that lives in GameEngine
		scene.setOnKeyPressed(event -> gameEngine.handleInput(event));

		// Created Scene is set to Stage
		stage.setScene(scene);

		// Stage is displayed
		stage.show();

		// Game Engine starts game
		gameEngine.startGame();
	}

	public static void playLoadedGame(Stage stage, Game loadedGame) {
		// Loaded Canvas is reused
		Canvas gameCanvas = new Canvas();
		// A GameEngine constructor specifically designed for loaded games
		GameEngine gameEngine = new GameEngine(gameCanvas, loadedGame);
		Group root = new Group(gameCanvas);
		Scene scene = new Scene(root);
		scene.setOnKeyPressed(event -> gameEngine.handleInput(event));
		stage.setScene(scene);
		stage.show();
		gameEngine.startGame();
	}

}

// For debugging, uncomment the following  lines. Right click on SnakeGame project and Debug as Java Application
//class SnakeGameLauncher {
//	public static void main(String[] args) {
//		SnakeGame.main(args);
//	}
//}
