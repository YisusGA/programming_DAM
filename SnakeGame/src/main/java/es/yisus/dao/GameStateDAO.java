package es.yisus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import es.yisus.dbcontext.DBContext;
import es.yisus.modelo.Game;
import es.yisus.modelo.GameState;

public class GameStateDAO {

	public static int insertGameState(GameState gameState, Game game) throws SQLException {
		String sqlSaveState = "INSERT OR REPLACE INTO game_states(game_id, board_width, board_height, food_x, food_y, current_direction) VALUES (?, ?, ?, ?, ?, ?)";
		int inserted = 0;
		try (Connection con = DBContext.getConnection();
				PreparedStatement psState = con.prepareStatement(sqlSaveState)) {
			psState.setInt(1, game.getId());
			psState.setInt(2, gameState.getBoardWidth());
			psState.setInt(3, gameState.getBoardHeight());
			psState.setInt(4, gameState.getFood().getX());
			psState.setInt(5, gameState.getFood().getY());
			psState.setString(6, gameState.getSnake().getDirection().name());
			psState.executeUpdate();
		}
		return inserted;
	}

	public static int insertGameState(GameState gameState, Game game, Connection con) throws SQLException {
		String sqlSaveState = "INSERT OR REPLACE INTO game_states(game_id, board_width, board_height, food_x, food_y, current_direction) VALUES (?, ?, ?, ?, ?, ?)";
		int inserted = 0;
		try (PreparedStatement psState = con.prepareStatement(sqlSaveState)) {
			psState.setInt(1, game.getId());
			psState.setInt(2, gameState.getBoardWidth());
			psState.setInt(3, gameState.getBoardHeight());
			psState.setInt(4, gameState.getFood().getX());
			psState.setInt(5, gameState.getFood().getY());
			psState.setString(6, gameState.getSnake().getDirection().name());
			psState.executeUpdate();
		}
		return inserted;
	}
	
	public static int deleteGameState(GameState gameState) throws SQLException {
		int deleted = 0;
		String sqlDeleteSaveStates = "DELETE FROM game_states WHERE game_id = ?";
		try (Connection con = DBContext.getConnection();
				PreparedStatement ps = con.prepareStatement(sqlDeleteSaveStates)) {
			ps.setInt(1, gameState.getGameId());
			deleted = ps.executeUpdate();
		}
		return deleted;
	}
}
