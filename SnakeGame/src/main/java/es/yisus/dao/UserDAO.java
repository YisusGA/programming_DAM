package es.yisus.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import es.yisus.dbcontext.DBContext;
import es.yisus.modelo.User;

public class UserDAO {

	public static int insertUser(User user) throws SQLException {
		int inserted = 0;
		// try-with-resources, para que se cierre tanto Connection como
		// PreparedStatement al terminar de usarse
		try (Connection con = DBContext.getConnection();
				// Avisamos de que queremos recuperar las claves que genere
				PreparedStatement ps = con.prepareStatement("INSERT INTO users (nickname) VALUES(?)",
						Statement.RETURN_GENERATED_KEYS)) {
			ps.setString(1, user.getNickname());
			inserted = ps.executeUpdate();
			if (inserted > 0) {
				// Recuperamos el ID generado por SQLite y se lo asignamos al objeto user
				try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
					// Sólo devolverá 1, porque el id es único. No hace falta bucle
					if (generatedKeys.next()) {
						user.setId(generatedKeys.getInt(1));
					}
				}
			}
		}
		return inserted;
	}

	public static int deleteUser(User user) throws SQLException {
		int inserted = 0;
		try (Connection con = DBContext.getConnection();
				PreparedStatement ps = con.prepareStatement("DELETE FROM users WHERE id = ?")) {
			ps.setInt(1, user.getId());
			inserted = ps.executeUpdate();
		}
		return inserted;
	}

	public static int updateUser(User user) throws SQLException {
		int updated = 0;
		try (Connection con = DBContext.getConnection();
				PreparedStatement ps = con.prepareStatement("UPDATE users SET nickname = ? WHERE id = ?")) {
			ps.setString(1, user.getNickname());
			ps.setInt(2, user.getId());
			updated = ps.executeUpdate();
		}
		return updated;
	}

	public static User getUser(int id) throws SQLException {
		User retrievedUser = null;
		try (Connection con = DBContext.getConnection();
				PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE id = ?")) {
			ps.setInt(1, id);
			try (ResultSet registros = ps.executeQuery()) {
				// Cómo mucho va a devolver 1 porque el id es único, no hace falta un bucle
				// while
				if (registros.next()) {
					retrievedUser = new User(registros.getInt("id"), registros.getString("nickname"));
				}
			}
		}
		return retrievedUser;
	}

}
