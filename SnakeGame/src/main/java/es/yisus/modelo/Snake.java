package es.yisus.modelo;

import java.util.ArrayList;
import java.util.List;

import es.yisus.utils.Direction;

public class Snake {
	private List<Point> body;
	private Direction direction;

	public Snake() {
		this.body = new ArrayList<>();
		this.direction = Direction.RIGHT; // Dirección por defecto
	}

	public Snake(List<Point> body, Direction direction) {
		this.body = body;
		this.direction = direction;
	}

	public Snake(List<Point> body) {
		this.body = body;
	}

	public List<Point> getBody() {
		return body;
	}

	public void setBody(List<Point> body) {
		this.body = body;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public Point getHead() {
		return body.isEmpty() ? null : body.get(0);
	}

	// Predicts where the head will be in the next frame
	public Point calculateNextHead() {
		Point currentHead = getHead();
		int x = currentHead.getX();
		int y = currentHead.getY();

		switch (direction) {
		case UP -> y--;
		case DOWN -> y++;
		case LEFT -> x--;
		case RIGHT -> x++;
		}
		return new Point(x, y);
	}

	// Standard movement: add new head, drop the tail tip
	public void move(Point nextHead) {
		body.add(0, nextHead); // Insert new head at index 0
		body.remove(body.size() - 1); // Remove the last element (tail)
	}

	// Growth movement: add new head, keep the tail
	public void grow(Point nextHead) {
		body.add(0, nextHead); // The list expands naturally
	}

	// Updates direction preventing instant 180-degree suicide turns
	public void changeDirection(Direction newDirection) {
		if (direction == Direction.UP && newDirection == Direction.DOWN)
			return;
		if (direction == Direction.DOWN && newDirection == Direction.UP)
			return;
		if (direction == Direction.LEFT && newDirection == Direction.RIGHT)
			return;
		if (direction == Direction.RIGHT && newDirection == Direction.LEFT)
			return;

		this.direction = newDirection;
	}

	// Checks if a specific point overlaps with the snake's body (for self-collision
	// purpose)
	public boolean containsPoint(Point point) {
		return body.contains(point); // Works perfectly thanks to Point's equals() override
	}

}
