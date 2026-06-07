package es.yisus.engine;

import java.sql.SQLException;

import es.yisus.modelo.Game;
import es.yisus.modelo.GameState;
import es.yisus.modelo.Point;
import es.yisus.modelo.Snake;
import es.yisus.modelo.User;
import es.yisus.service.GameService;
import es.yisus.utils.Direction;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class GameEngine {
	// Size of each screen blocl: 20 x 20 pixels
	private static final int BLOCK_SIZE = 20;

	// Speed control: 150 miliseconds per frame
	// A lower value will increase speed
	private static long FRAME_TIME_NANO = 150_000_000L; // Las _ son eliminadas por el compilador y no afectan
														// negativamente, pero sirven de ayuda visual para la
														// persona que lee el número

	private final Canvas canvas;
	private final GraphicsContext gc;

	private Game gameSession;
	private GameState gameState;
	private AnimationTimer gameLoop;
	private long lastTick = 0;
	private static boolean isPaused; // boolean to determine if the game is paused or not

	// Constructor for New Game
	public GameEngine(Canvas canvas, User user, int boardWidth, int boardHeight) {

		this.canvas = canvas;
		this.gc = canvas.getGraphicsContext2D();

		// Canvas dimensions calculation
		this.canvas.setWidth(boardWidth * BLOCK_SIZE);
		this.canvas.setHeight(boardHeight * BLOCK_SIZE);

		// Game and GameState are instanced
		this.gameSession = new Game(user);
		this.gameState = new GameState(boardWidth, boardHeight);
		this.gameSession.setGameState(gameState);
		isPaused = false;

		initGame();
	}

	// Constructor for loaded game
	public GameEngine(Canvas canvas, Game loadedGame) {
		this.canvas = canvas;
		this.gc = canvas.getGraphicsContext2D();

		this.gameSession = loadedGame;
		this.gameState = loadedGame.getGameState();

		// Canvas dimensions are calculated according to size of saved board dimensions
		this.canvas.setWidth(gameState.getBoardWidth() * BLOCK_SIZE);
		this.canvas.setHeight(gameState.getBoardHeight() * BLOCK_SIZE);
		isPaused = false;

		initLoadedGame();
	}

	// Method to initialize new game
	private void initGame() {
		// Snake's head will start in the center
		int startX = gameState.getBoardWidth() / 2;
		int startY = gameState.getBoardHeight() / 2;
		gameState.getSnake().getBody().add(new Point(startX, startY));

		// First food is generated
		gameState.generateRandomFood();

		// Main gameloop is created
		gameLoopCreation();
	}

	private void initLoadedGame() {
		// Main gameloop is created
		gameLoopCreation();
	}

	// Main gameloop
	private void gameLoopCreation() {
		this.gameLoop = new AnimationTimer() {
			@Override
			public void handle(long now) {
				if (gameSession.isFinished()) {
					stopGame();
					return;
				}
				if (lastTick == 0 || now - lastTick >= FRAME_TIME_NANO) {
					lastTick = now;
					if (!isPaused) {
						update();
						render();
					}
				}
			}
		};
	}

	public void startGame() {
		gameLoop.start();
	}

	public void stopGame() {
		gameLoop.stop();
		renderGameOver();
	}

	public void handleInput(KeyEvent event) {
		KeyCode code = event.getCode();
		switch (code) {
		case UP, W -> gameState.getSnake().changeDirection(Direction.UP);
		case DOWN, S -> gameState.getSnake().changeDirection(Direction.DOWN);
		case LEFT, A -> gameState.getSnake().changeDirection(Direction.LEFT);
		case RIGHT, D -> gameState.getSnake().changeDirection(Direction.RIGHT);

		case ESCAPE -> {
			// If Game Over), ESC is ignored
			if (gameSession.isFinished())
				return;

			isPaused = !isPaused;

			if (isPaused) {
				// Pause screen is rendered just once
				renderPauseScreen();
			}

			// If !isPaused, nothing is done. Gameloop will execute render() on next frame
			// and this pause screen will be deleted
		}

		case G -> {
			if (isPaused) {
				try {
					// Game and GameState are saved
					boolean guardadoOk = GameService.saveGame(this.gameSession);
					if (guardadoOk) {
						System.out.println("Saved state created. Game ID: " + gameSession.getId());
					}
				} catch (SQLException e) {
					System.err.println("An error happened saving game state to DB");
					e.printStackTrace();
				}
			}
		}

		default -> {
			// Any other key is ignored
		}
		}
	}

	// Physic and rule logic
	private void update() {
		Snake snake = gameState.getSnake();
		Point nextHead = snake.calculateNextHead();

		// Collision calculations
		if (gameState.isWallCollision(nextHead) || snake.containsPoint(nextHead)) {
			gameSession.setFinished(true);
			// If game over, Game is saved, but not GameState
			try {
				GameService.saveGame(this.gameSession);
				System.out.println("Finished game score was registered");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return;
		}

		// Food eating logic
		if (nextHead.equals(gameState.getFood())) {
			snake.grow(nextHead); // Snake grows
			gameState.generateRandomFood(); // New food generation
			gameSession.setScore(gameSession.getScore() + 10); // Score is increased by 10
			// Speed is increased every 100 points
			if (gameSession.getScore() % 100 == 0) {
				long newSpeed = (long) (FRAME_TIME_NANO - FRAME_TIME_NANO * 0.10);
				if (newSpeed < 50_000_000L) {
					newSpeed = 50_000_000L;
				}
				FRAME_TIME_NANO = newSpeed;
			}
		} else {
			// Snake movement if no food is eaten
			snake.move(nextHead);
		}
	}

	// Graphical interface rendering
	private void render() {
		// Black background
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

		// Food painting
		gc.setFill(Color.RED);
		Point food = gameState.getFood();
		gc.fillOval(food.getX() * BLOCK_SIZE, food.getY() * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);

		// Snake painting
		Snake snake = gameState.getSnake();
		for (int i = 0; i < snake.getBody().size(); i++) {
			Point segment = snake.getBody().get(i);

			// Visual differentiation between head and rest of Snake's body
			if (i == 0) {
				gc.setFill(Color.GREENYELLOW);
			} else {
				gc.setFill(Color.GREEN);
			}

			// Small black space between Snake's segments
			gc.fillRect(segment.getX() * BLOCK_SIZE, segment.getY() * BLOCK_SIZE, BLOCK_SIZE - 1, BLOCK_SIZE - 1);
		}

		// HUD painting for username
		gc.setFill(Color.WHITE);
		gc.setFont(new Font("Arial", 14));
		gc.fillText(gameSession.getUser().getNickname(), 10, 20);

		// HUD painting for score
		gc.setFill(Color.WHITE);
		gc.setFont(new Font("Arial", 14));
		gc.fillText("Score: " + gameSession.getScore(), 10, 35);

		// HUD painting for message of how to pause game
		gc.setFill(Color.WHITE);
		gc.setFont(new Font("Arial", 14));
		gc.fillText("Press ESC key to pause game", canvas.getWidth() / 2 - 100, 20);
	}

	// Pause screen rendering method
	private void renderPauseScreen() {
		// Capa negra semitransparente
		gc.setFill(Color.color(0, 0, 0, 0.75));
		gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

		// Título
		gc.setFont(new Font("Arial Bold", 30));
		gc.setFill(Color.WHITE);
		gc.fillText("PAUSE", canvas.getWidth() / 2 - 55, canvas.getHeight() / 2 - 20);

		// Instrucciones
		gc.setFont(new Font("Arial", 16));
		gc.fillText("Press ESC key to resume", canvas.getWidth() / 2 - 95, canvas.getHeight() / 2 + 5);

		// Aprovechamos para recordarle lo del guardado
		gc.setFill(Color.LIGHTGRAY);
		gc.setFont(new Font("Arial", 14));
		gc.fillText("Press G to save game", canvas.getWidth() / 2 - 75, canvas.getHeight() / 2 + 50);
		gc.setFill(Color.LIGHTGRAY);
		gc.setFont(new Font("Arial", 14));
		gc.fillText("Only one saved game per user is allowed.", canvas.getWidth() / 2 - 130,
				canvas.getHeight() / 2 + 70);
		gc.setFill(Color.LIGHTGRAY);
		gc.setFont(new Font("Arial", 14));
		gc.fillText("Subsequent saved games will overwrite previous ones.", canvas.getWidth() / 2 - 170,
				canvas.getHeight() / 2 + 90);
	}

	// Game Over screen rendering method
	private void renderGameOver() {
		// Oscurecemos el fondo aplicando una capa negra con transparencia alfa
		gc.setFill(Color.color(0, 0, 0, 0.75));
		gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

		gc.setFont(new Font("Arial Bold", 30));
		gc.setFill(Color.RED);
		gc.fillText("GAME OVER", canvas.getWidth() / 2 - 90, canvas.getHeight() / 2 - 10);

		gc.setFont(new Font("Arial", 16));
		gc.setFill(Color.WHITE);
		gc.fillText(gameSession.getUser().getNickname(), canvas.getWidth() / 2 - 25, canvas.getHeight() / 2 + 20);

		gc.setFont(new Font("Arial", 16));
		gc.setFill(Color.WHITE);
		gc.fillText("Final Score: " + gameSession.getScore(), canvas.getWidth() / 2 - 50, canvas.getHeight() / 2 + 40);
	}
}
