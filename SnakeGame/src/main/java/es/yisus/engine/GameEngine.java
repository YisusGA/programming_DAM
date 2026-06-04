package es.yisus.engine;

import java.sql.SQLException;

import es.yisus.dao.GameDAO;
import es.yisus.modelo.Game;
import es.yisus.modelo.GameState;
import es.yisus.modelo.Point;
import es.yisus.modelo.Snake;
import es.yisus.modelo.User;
import es.yisus.utils.Direction;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class GameEngine {
	// Cada celda de la cuadrícula medirá 20x20 píxeles en pantalla
	private static final int BLOCK_SIZE = 20;

	// Control de velocidad: 150.000.000 nanosegundos = 150 milisegundos por frame.
	// Reducir para que vaya más rápido
	private static long FRAME_TIME_NANO = 150_000_000L; // Las _ son eliminadas por el compilador y no afectan
														// negativamente, pero sirven de ayuda visual para la
														// persona que lee el número

	private final Canvas canvas;
	private final GraphicsContext gc;

	private Game gameSession;
	private GameState gameState;
	private AnimationTimer gameLoop;
	private long lastTick = 0;

	public GameEngine(Canvas canvas, User user, int boardWidth, int boardHeight) {

		this.canvas = canvas;
		this.gc = canvas.getGraphicsContext2D();

		// Ajustamos las dimensiones reales del lienzo según el tamaño del tablero
		this.canvas.setWidth(boardWidth * BLOCK_SIZE);
		this.canvas.setHeight(boardHeight * BLOCK_SIZE);

		// Instanciamos el modelo de sesión y el estado de la partida
		this.gameSession = new Game(user);
		this.gameState = new GameState(boardWidth, boardHeight);
		this.gameSession.setGameState(gameState);

		initGame();
	}

	

	// CONSTRUCTOR PARA PARTIDAS CARGADAS
	public GameEngine(Canvas canvas, Game loadedGame) {
	    this.canvas = canvas;
	    this.gc = canvas.getGraphicsContext2D();

	    this.gameSession = loadedGame;
	    this.gameState = loadedGame.getGameState();

	    // Ajustamos el lienzo a las dimensiones que tenía el mapa al guardarse
	    this.canvas.setWidth(gameState.getBoardWidth() * BLOCK_SIZE);
	    this.canvas.setHeight(gameState.getBoardHeight() * BLOCK_SIZE);

	    initLoadedGame();
	}

	// INICIALIZADOR SIN REINICIAR LA SERPIENTE NI LA COMIDA
	private void initLoadedGame() {
	    this.gameLoop = new AnimationTimer() {
	        @Override
	        public void handle(long now) {
	            if (gameSession.isFinished()) {
	                stopGame();
	                return;
	            }
	            if (lastTick == 0 || now - lastTick >= FRAME_TIME_NANO) {
	                lastTick = now;
	                update();
	                render();
	            }
	        }
	    };
	}



	private void initGame() {
		// Colocamos la cabeza en el centro del escenario para empezar
		int startX = gameState.getBoardWidth() / 2;
		int startY = gameState.getBoardHeight() / 2;
		gameState.getSnake().getBody().add(new Point(startX, startY));

		// Colocamos la primera comida en el tablero
		gameState.generateRandomFood();

		// Construimos el bucle principal del juego
		this.gameLoop = new AnimationTimer() {
			@Override
			public void handle(long now) {
				if (gameSession.isFinished()) {
					stopGame();
					return;
				}

				// Throttling: El AnimationTimer va a 60fps+, limitamos la ejecución al delay
				// deseado
				if (lastTick == 0 || now - lastTick >= FRAME_TIME_NANO) {
					lastTick = now;
					update();
					render();
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

	// Vincula este método al evento OnKeyPressed de tu escena o Stage principal
	public void handleInput(KeyEvent event) {
		KeyCode code = event.getCode();
		switch (code) {
		case UP, W -> gameState.getSnake().changeDirection(Direction.UP);
		case DOWN, S -> gameState.getSnake().changeDirection(Direction.DOWN);
		case LEFT, A -> gameState.getSnake().changeDirection(Direction.LEFT);
		case RIGHT, D -> gameState.getSnake().changeDirection(Direction.RIGHT);

		// Guardado de emergencia rápido para probar
		case G -> {
			try {
				// Le pasamos el objeto gameSession que el motor actualiza constantemente
				boolean guardadoOk = GameDAO.saveGame(this.gameSession);
				if (guardadoOk) {
					System.out.println("Partida guardada con exito! ID de Partida: " + gameSession.getId());
				}
			} catch (SQLException e) {
				System.err.println("Error al guardar la partida en la BD.");
				e.printStackTrace();
			}
		}

		default -> {
			// Ignoramos cualquier otra tecla
		}
		}
	}

	// Lógica de físicas y reglas
	private void update() {
		Snake snake = gameState.getSnake();
		Point nextHead = snake.calculateNextHead();

		// Control de colisiones fatales (Muros o chocarse consigo misma)
		if (gameState.isWallCollision(nextHead) || snake.containsPoint(nextHead)) {
			gameSession.setFinished(true);
			// Si el jugador pierde, se guarda automáticamente el Game (no el GameState),
			// para así poder almacenar la puntuación, entre otras cosas
			try {
				GameDAO.saveGame(this.gameSession);
				System.out.println("Partida finalizada registrada en el historial.");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return;
		}

		// Control de objetivos (si alcanza la comida)
		if (nextHead.equals(gameState.getFood())) {
			snake.grow(nextHead); // Añade la cabeza pero no corta la cola
			gameState.generateRandomFood(); // El escenario calcula la nueva posición libre
			gameSession.setScore(gameSession.getScore() + 10); // Incrementa puntuación
			if (gameSession.getScore() % 100 == 0) {
				long newSpeed = (long) (FRAME_TIME_NANO - FRAME_TIME_NANO * 0.10);
				if (newSpeed < 50_000_000L) {
					newSpeed = 50_000_000L;
				}
				FRAME_TIME_NANO = newSpeed;
			}
		} else {
			// Movimiento ordinario en el espacio en blanco
			snake.move(nextHead);
		}
	}

	// CAPA GRÁFICA (Pintado del Lienzo)
	private void render() {
		// Limpiamos la pantalla con fondo negro
		gc.setFill(Color.BLACK);
		gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

		// Pintamos la comida (un círculo rojo)
		gc.setFill(Color.RED);
		Point food = gameState.getFood();
		gc.fillOval(food.getX() * BLOCK_SIZE, food.getY() * BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE);

		// Pintamos la serpiente
		Snake snake = gameState.getSnake();
		for (int i = 0; i < snake.getBody().size(); i++) {
			Point segment = snake.getBody().get(i);

			// Diferenciamos visualmente la cabeza del cuerpo
			if (i == 0) {
				gc.setFill(Color.GREENYELLOW);
			} else {
				gc.setFill(Color.GREEN);
			}

			// BLOCK_SIZE - 1 genera un pequeño borde de separación negro entre los
			// segmentos de la serpiente
			gc.fillRect(segment.getX() * BLOCK_SIZE, segment.getY() * BLOCK_SIZE, BLOCK_SIZE - 1, BLOCK_SIZE - 1);
		}

		// Dibujamos el HUD de la puntuación en la esquina superior izquierda
		gc.setFill(Color.WHITE);
		gc.setFont(new Font("Arial", 14));
		gc.fillText(gameSession.getUser().getNickname(), 10, 20); 
		gc.setFill(Color.WHITE);
		gc.setFont(new Font("Arial", 14));
		gc.fillText("Score: " + gameSession.getScore(), 10, 35);
	}

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
