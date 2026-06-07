package es.yisus.modelo;

import java.util.Random;

public class GameState {
	private int gameId;
	private int boardWidth;
	private int boardHeight;
	private Point food;
	private Snake snake;

	public GameState(int width, int height) {
		this.boardWidth = width;
		this.boardHeight = height;
		this.snake = new Snake();
		this.food = new Point(0, 0);
	}

	public GameState(int id, int width, int height, Snake snake, Point food) {
		this.boardWidth = width;
		this.boardHeight = height;
		this.snake = snake;
		this.food = food;
		this.gameId = id;
	}

	public GameState() {
	}

	public int getBoardWidth() {
		return boardWidth;
	}

	public void setBoardWidth(int boardWidth) {
		this.boardWidth = boardWidth;
	}

	public int getBoardHeight() {
		return boardHeight;
	}

	public void setBoardHeight(int boardHeight) {
		this.boardHeight = boardHeight;
	}

	public Point getFood() {
		return food;
	}

	public void setFood(Point food) {
		this.food = food;
	}

	public Snake getSnake() {
		return snake;
	}

	public void setSnake(Snake snake) {
		this.snake = snake;
	}

	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	// Spawns food at a random coordinate, ensuring it doesn't land on the snake
	public void generateRandomFood() {
		Random random = new Random();
		int x, y;
		Point potentialFood;

		do {
			x = random.nextInt(boardWidth);
			y = random.nextInt(boardHeight);
			potentialFood = new Point(x, y);
		} while (snake.containsPoint(potentialFood));

		this.food = potentialFood;
	}

	// Checks if the predicted head position hits any of the board boundaries
	public boolean isWallCollision(Point point) {
		boolean collision = point.getX() < 0 || point.getX() >= boardWidth || point.getY() < 0
				|| point.getY() >= boardHeight;
		return collision;
	}

}
