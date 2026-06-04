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
import es.yisus.dao.GameStateDAO;
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
					GameState gameState = new GameState(gameId, width, height, snake, food);

					game.setGameState(gameState);
				}
			}
		}
	}

	public static boolean saveGame(Game game) throws SQLException {
		try (Connection con = DBContext.getConnection()) {
			// Autocommit deactivated, so that we can decide when changes are commited
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
				GameState state = game.getGameState();
				if (state != null && !game.isFinished()) {
					GameStateDAO.insertGameState(state, game, con);
					// Save snake segments in snake_segments table
					// First, previous saved segments are deleted to avoid duplicates
					SnakeDAO.deleteSnakeByGameId(game.getId(), con);
					// Save snake body
					SnakeDAO.saveSnakeBody(game.getId(), con, state.getSnake());
					// If game is finished, all save data associated is deleted
				} else if (game.isFinished()) {
					GameStateService.deleteGameStateByGame(game, con);
				}
				// If everything was ok, all changes are commited together
				con.commit();
				return true;
			} catch (SQLException e) {
				System.err.println("An error happened during saving state process, no changes have been commited to DB");
				con.rollback();
				throw e;
			} finally {
				// Autocommit activated again
				con.setAutoCommit(true);
			}
		}
	}
}
