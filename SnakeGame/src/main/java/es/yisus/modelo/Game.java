package es.yisus.modelo;

import java.time.LocalDateTime;
import java.util.Objects;

public class Game {
	private int id;
	private User user;
	private int score;
	private LocalDateTime dateTime;
	private boolean finished; // El conector de jdbc de sqlite traduce el true a 1 y el false a 0 (y
								// viceversa)
	// Relación de composición: si la partida se guarda "en curso",
	// tendrá esta instancia poblada. Si se finaliza, puede quedar en null.
	private GameState gameState;

	public Game(User user) {
		this.user = user;
		this.score = 0;
		this.dateTime = LocalDateTime.now();
		this.finished = false;
		this.gameState = null;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}

	public boolean isFinished() {
		return finished;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
	}

	public GameState getGameState() {
		return gameState;
	}

	public void setGameState(GameState gameState) {
		this.gameState = gameState;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Game other = (Game) obj;
		return id == other.id;
	}

}
