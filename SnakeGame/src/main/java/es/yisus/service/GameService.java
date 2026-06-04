package es.yisus.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import es.yisus.dao.GameDAO;
import es.yisus.dao.SnakeDAO;
import es.yisus.dbcontext.DBContext;
import es.yisus.modelo.Game;
import es.yisus.modelo.GameState;
import es.yisus.modelo.Point;
import es.yisus.modelo.Snake;
import es.yisus.modelo.User;
import es.yisus.utils.Direction;
import es.yisus.utils.Leaderboard;

public class GameService {

	public static List<Leaderboard> getLeaderBoard() throws SQLException {
		List<Leaderboard> preLeaderboard = new ArrayList<>();
		List<Game> games = GameDAO.getGames();
		for (int i = 0; i < games.size(); i++) {
			Game g = games.get(i);
			preLeaderboard.add(new Leaderboard(g.getUser().getNickname(), g.getScore()));
		}
		preLeaderboard.sort(null);
		preLeaderboard = preLeaderboard.reversed();
		List<Leaderboard> leaderboard = new ArrayList<>();
		for (int i = 0; i < preLeaderboard.size() && i < 10; i++) {
			leaderboard.add(preLeaderboard.get(i));
		}

		return leaderboard;
	}

	public static List<Game> getGamesByUser(User user) throws SQLException {
		List<Game> allGames = GameDAO.getGames();
		List<Game> filteredGames = new ArrayList<>();
		if (allGames.size() > 0) {
			filteredGames.addAll(allGames.stream().filter(g -> g.getUser().equals(user)).toList());
		}
		return filteredGames;
	}

	public static List<Game> getUnfinishedGamesByUser(User user) throws SQLException {
		List<Game> allGames = getGamesByUser(user);
		List<Game> filteredGames = new ArrayList<>();
		if (allGames.size() > 0) {
			filteredGames.addAll(allGames.stream().filter(g -> !g.isFinished()).toList());
		}
		return filteredGames;
	}

	public static Game loadGame(int gameId, User user) throws SQLException {
		String sqlState = "SELECT * FROM game_states WHERE game_id = ?";

		try (Connection con = DBContext.getConnection()) {
			Game game = getGameByIdWithUser(gameId, user, con);
			// Si el juego existe y no está finalizado, leemos el GameState
			if (game != null && !game.isFinished()) {
				readGameState(gameId, sqlState, con, game);
			}
			return game;
		}
	}

	private static Game getGameByIdWithUser(int gameId, User user, Connection con) throws SQLException {
		String sqlGame = "SELECT * FROM games WHERE id = ?";
		Game game = null;
		// Primero leemos de la tabla 'games'
		try (PreparedStatement psGame = con.prepareStatement(sqlGame)) {
			psGame.setInt(1, gameId);
			try (ResultSet rsGame = psGame.executeQuery()) {
				if (rsGame.next()) {
					game = new Game(user);
					game.setId(rsGame.getInt("id"));
					game.setScore(rsGame.getInt("score"));
					game.setFinished(rsGame.getInt("finished") == 1);

					String dateTime = rsGame.getString("date_time");
					if (dateTime != null) {
						try {
							game.setDateTime(LocalDateTime.parse(dateTime.replace(" ", "T")));
						} catch (DateTimeParseException e) {
							System.err
									.println("Error parsing date and time. Current date and time will be used instead");
							game.setDateTime(LocalDateTime.now());
						}
					}
				}
			}
		}

		return game;
	}

	public static void readGameState(int gameId, String sqlState, Connection con, Game game) throws SQLException {
		try (PreparedStatement psState = con.prepareStatement(sqlState)) {
			psState.setInt(1, gameId);
			try (ResultSet rsState = psState.executeQuery()) {
				if (rsState.next()) {
					int width = rsState.getInt("board_width");
					int height = rsState.getInt("board_height");
					int foodX = rsState.getInt("food_x");
					int foodY = rsState.getInt("food_y");
					Direction dir = Direction.valueOf(rsState.getString("current_direction"));

					// Reconstruction of snake body
					List<Point> body = SnakeDAO.getSnakeBody(gameId, con);

					Snake snake = new Snake(body, dir);
					Point food = new Point(foodX, foodY);
					GameState gameState = new GameState(width, height, snake, food);

					game.setGameState(gameState);
				}
			}
		}
	}

	public static boolean saveGame(Game game) throws SQLException {
		String sqlSaveState = "INSERT OR REPLACE INTO game_states(game_id, board_width, board_height, food_x, food_y, current_direction) VALUES (?, ?, ?, ?, ?, ?)";
		String sqlDeleteSaveStates = "DELETE FROM game_states WHERE game_id = ?";
		String sqlDeleteSegments = "DELETE FROM snake_segments WHERE game_id = ?";
	
		try (Connection con = DBContext.getConnection()) {
			// Desactivamos auto-commit para manejar la transacción de forma manual
			con.setAutoCommit(false);
	
			try {
				// Save Game in games table
				if (game.getId() == 0) {
					// It's a new Game, it will be inserted into DB
					GameDAO.insertGame(game, con);
				} else {
					// Game exists, their properties will be updated
					GameDAO.updateGame(game, con);
				}
				// Save GameState in game_states (if game isn't finished)
				if (game.getGameState() != null && !game.isFinished()) {
					GameState state = game.getGameState();
	
					try (PreparedStatement psState = con.prepareStatement(sqlSaveState)) {
						psState.setInt(1, game.getId());
						psState.setInt(2, state.getBoardWidth());
						psState.setInt(3, state.getBoardHeight());
						psState.setInt(4, state.getFood().getX());
						psState.setInt(5, state.getFood().getY());
						psState.setString(6, state.getSnake().getDirection().name());
						psState.executeUpdate();
					}
	
					// Guardar los segmentos de la serpiente en la tabla snake_segments
					// Primero borramos los segmentos previos de esta partida para evitar duplicados
					// accidentales
					try (PreparedStatement psDel = con.prepareStatement(sqlDeleteSegments)) {
						psDel.setInt(1, game.getId());
						psDel.executeUpdate();
					}
	
					// Usamos el SnakeDAO, reutilizando la misma conexión abierta
					SnakeDAO.saveSnakeBody(game.getId(), con, state.getSnake());
					// Si se ha terminado el juego, se borran todos los estados guardados asociados
				} else if (game.isFinished()) {
					try (PreparedStatement psState = con.prepareStatement(sqlDeleteSaveStates)) {
						psState.setInt(1, game.getId());
						psState.executeUpdate();
					}
				}
	
				// Si todo ha ido bien, consolidamos los cambios en la Base de Datos
				con.commit();
				return true;
	
			} catch (SQLException e) {
				// Si algo falla en cualquier punto, deshacemos todo para mantener la integridad
				con.rollback();
				throw e;
			} finally {
				// Volvemos a activar el autocommit
				con.setAutoCommit(true);
			}
		}
	}
}
