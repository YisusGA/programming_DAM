package es.yisus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import es.yisus.dbcontext.DBContext;
import es.yisus.modelo.Game;
import es.yisus.modelo.GameState;
import es.yisus.modelo.Point;
import es.yisus.modelo.Snake;
import es.yisus.modelo.User;
import es.yisus.utils.Direction;

public class GameDAO {

	public static List<Game> getGames() throws SQLException {
		List<Game> retrievedGames = new ArrayList<>();
		String sqlGame = "SELECT * FROM games";
		String sqlUser = "SELECT * FROM users WHERE id = ?";
		try (Connection con = DBContext.getConnection();
				Statement stGame = con.createStatement();
				PreparedStatement psUser = con.prepareStatement(sqlUser)) {
			try (ResultSet rsGame = stGame.executeQuery(sqlGame)) {
				while (rsGame.next()) {
					Game game = new Game();
					game.setId(rsGame.getInt("id"));
					game.setScore(rsGame.getInt("score"));
					game.setFinished(rsGame.getInt("finished") == 1);
					psUser.setInt(1, rsGame.getInt("user_id"));
					try (ResultSet rsUser = psUser.executeQuery()) {
						if (rsUser.next()) {
							User user = new User();
							user.setId(rsUser.getInt("id"));
							user.setNickname(rsUser.getString("nickname"));
							game.setUser(user);
						}
					}
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
					retrievedGames.add(game);
				}
			}
		}

		return retrievedGames;
	}

	public static Game getGame(int id) throws SQLException {
		String sqlGame = "SELECT * FROM games WHERE id = ?";
		String sqlUser = "SELECT * FROM users WHERE id = ?";
		Game game = null;
		try (Connection con = DBContext.getConnection();
				PreparedStatement psGame = con.prepareStatement(sqlGame);
				PreparedStatement psUser = con.prepareStatement(sqlUser)) {
			psGame.setInt(1, id);
			try (ResultSet rsGame = psGame.executeQuery()) {
				if (rsGame.next()) {
					game = new Game();
					game.setId(rsGame.getInt("id"));
					game.setScore(rsGame.getInt("score"));
					game.setFinished(rsGame.getInt("finished") == 1);
					psUser.setInt(1, rsGame.getInt("user_id"));
					try (ResultSet rsUser = psUser.executeQuery()) {
						if (rsUser.next()) {
							User user = new User();
							user.setId(rsUser.getInt("id"));
							user.setNickname(rsUser.getString("nickname"));
							game.setUser(user);
						}
					}
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

//	public static GameState getGameState(int gameId) throws SQLException {
//		String sqlGameState = "SELECT * FROM game_states WHERE game_id = ?";
//		GameState gs = null;
//		try (Connection con = DBContext.getConnection();
//				PreparedStatement psGameState = con.prepareStatement(sqlGameState)) {
//			psGameState.setInt(1, gameId);
//			try (ResultSet rsGameState = psGameState.executeQuery()) {
//				if (rsGameState.next()) {
//					gs = new GameState();
//					gs.setGame(getGame(gameId));
//					gs.setBoardWidth(rsGameState.getInt("board_width"));
//					gs.setBoardHeight(rsGameState.getInt("board_height"));
//					gs.setFood(new Point(rsGameState.getInt("food_x"), rsGameState.getInt("food_y")));
//					String direccion = rsGameState.getString("current_direction");
//					// TODO
//				}
//			}
//		}
//	}

	public static boolean saveGame(Game game) throws SQLException {
		String sqlInsertGame = "INSERT INTO games(user_id, score, finished) VALUES (?, ?, ?)";
		String sqlUpdateGame = "UPDATE games SET score = ?, finished = ? WHERE id = ?";
		String sqlSaveState = "INSERT OR REPLACE INTO game_states(game_id, board_width, board_height, food_x, food_y, current_direction) VALUES (?, ?, ?, ?, ?, ?)";
		String sqlDeleteSegments = "DELETE FROM snake_segments WHERE game_id = ?";

		try (Connection con = DBContext.getConnection()) {
			// Desactivamos auto-commit para manejar la transacción de forma manual
			con.setAutoCommit(false);

			try {
				// Guardar el Game en la tabla games
				if (game.getId() == 0) {
					// Es una partida nueva: hacemos INSERT y recuperamos el ID generado
					try (PreparedStatement psGame = con.prepareStatement(sqlInsertGame,
							Statement.RETURN_GENERATED_KEYS)) {
						psGame.setInt(1, game.getUser().getId());
						psGame.setInt(2, game.getScore());
						psGame.setInt(3, game.isFinished() ? 1 : 0);
						psGame.executeUpdate();

						// Recuperamos la clave que ha generado SQLite
						try (ResultSet rs = psGame.getGeneratedKeys()) {
							if (rs.next()) {
								game.setId(rs.getInt(1)); // Asignamos el ID autoincremental al objeto
							}
						}
					}
				} else {
					// La partida ya existe en la BD: actualizamos la puntuación y el estado de
					// finalización
					try (PreparedStatement psGame = con.prepareStatement(sqlUpdateGame)) {
						psGame.setInt(1, game.getScore());
						psGame.setInt(2, game.isFinished() ? 1 : 0);
						psGame.setInt(3, game.getId());
						psGame.executeUpdate();
					}
				}

				// Guardar el GameState en la tabla game_states (si la partida no ha terminado)
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
					SnakeDAO snakeDao = new SnakeDAO();
					snakeDao.saveSnakeBody(game.getId(), con, state.getSnake());
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

	public static Game loadGame(int gameId, User user) throws SQLException {
		String sqlGame = "SELECT * FROM games WHERE id = ?";
		String sqlState = "SELECT * FROM game_states WHERE game_id = ?";

		try (Connection con = DBContext.getConnection()) {
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
								System.err.println(
										"Error parsing date and time. Current date and time will be used instead");
								game.setDateTime(LocalDateTime.now());
							}
						}
					}
				}
			}

			// Si el juego existe y no está finalizado, leemos el GameState
			if (game != null && !game.isFinished()) {
				try (PreparedStatement psState = con.prepareStatement(sqlState)) {
					psState.setInt(1, gameId);
					try (ResultSet rsState = psState.executeQuery()) {
						if (rsState.next()) {
							int width = rsState.getInt("board_width");
							int height = rsState.getInt("board_height");
							int foodX = rsState.getInt("food_x");
							int foodY = rsState.getInt("food_y");
							Direction dir = Direction.valueOf(rsState.getString("current_direction"));

							// Reconstruimos la serpiente usando el SnakeDAO
							SnakeDAO snakeDao = new SnakeDAO();
							List<Point> body = snakeDao.getSnakeBody(gameId, con);

							Snake snake = new Snake(body, dir);
							Point food = new Point(foodX, foodY);
							GameState gameState = new GameState(width, height, snake, food);

							game.setGameState(gameState);
						}
					}
				}
			}
			return game;
		}
	}
}
