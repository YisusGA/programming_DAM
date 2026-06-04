package es.yisus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.yisus.modelo.Point;
import es.yisus.modelo.Snake;

public class SnakeDAO {

	// Gestionar la excepción en el GameEngine, para crear una serpiente nueva si no
	// se pudo recuperar la guardada
	public static List<Point> getSnakeBody(int gameId, Connection con) throws SQLException {
		List<Point> body = new ArrayList<>();
		// Este try-with-resources hace que se cierre el recurso PreparedStatement al terminar
		try (PreparedStatement ps = con.prepareStatement(
				"SELECT pos_x, pos_y FROM snake_segments WHERE game_id = ? ORDER BY segment_order ASC")) {
			ps.setInt(1, gameId);
			// Este try-with-resources hace que se cierre el recurso ResultSet al terminar
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					int x = rs.getInt("pos_x");
					int y = rs.getInt("pos_y");

					// Vamos reconstruyendo los puntos uno a uno
					body.add(new Point(x, y));
				}
			}
		}
		return body;
	}

	// An exception is launched if saved was not completed, so that GameState won't save
	public static boolean saveSnakeBody(int gameId, Connection con, Snake snake) throws SQLException {
		List<Point> body = snake.getBody();
		try (PreparedStatement ps = con.prepareStatement("INSERT INTO snake_segments VALUES(?, ?, ?, ?)")) {
			for (int i = 0; i < body.size(); i++) {
				ps.setInt(1, gameId);
				ps.setInt(2, i);
				ps.setInt(3, body.get(i).getX());
				ps.setInt(4, body.get(i).getY());
				ps.addBatch();
			}
			ps.executeBatch();
		}
		return true;
	}
}
