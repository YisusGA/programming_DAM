package es.yisus.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import es.yisus.dbcontext.DBContext;
import es.yisus.modelo.Game;

public class GameStateService {

	public static int deleteGameStateByGame(Game game) throws SQLException {
		int deleted = 0;
		String sqlDeleteSaveStates = "DELETE FROM game_states WHERE game_id = ?";
		try (Connection con = DBContext.getConnection();
				PreparedStatement ps = con.prepareStatement(sqlDeleteSaveStates)) {
			ps.setInt(1, game.getId());
			deleted = ps.executeUpdate();
		}
		return deleted;
	}

	public static int deleteGameStateByGame(Game game, Connection con) throws SQLException {
		int deleted = 0;
		String sqlDeleteSaveStates = "DELETE FROM game_states WHERE game_id = ?";
		try (PreparedStatement ps = con.prepareStatement(sqlDeleteSaveStates)) {
			ps.setInt(1, game.getId());
			deleted = ps.executeUpdate();
		}
		return deleted;
	}

}
