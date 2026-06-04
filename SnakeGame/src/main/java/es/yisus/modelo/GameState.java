package es.yisus.modelo;

import java.util.Random;

public class GameState {
	private int boardWidth;
	private int boardHeight;
	private Point food;
	private Snake snake;
	private Game game;

	public GameState(int width, int height) {
		this.boardWidth = width;
		this.boardHeight = height;
		this.snake = new Snake();
		this.food = new Point(0, 0);
	}

	public GameState(int width, int height, Snake snake, Point food) {
		this.boardWidth = width;
		this.boardHeight = height;
		this.snake = snake;
		this.food = food;
	}

	public GameState(int boardWidth, int boardHeight, Point food, Snake snake, Game game) {
		this.boardWidth = boardWidth;
		this.boardHeight = boardHeight;
		this.food = food;
		this.snake = snake;
		this.game = game;
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

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
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

	@Override
	public String toString() {
		return this.game.getUser().getNickname() + " | " + this.game.getScore() + " | "
				+ this.game.getDateTime().toString();
	}

}
