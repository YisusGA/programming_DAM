package es.yisus.dbcontext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBContext {
	private static final String URL = "jdbc:sqlite:src/main/resources/snakegame.db";

	// Método estático para obtener la conexión
	public static Connection getConnection() throws SQLException {
		Connection con = DriverManager.getConnection(URL);
		// Activamos las restricciones de integridad en SQLite para esta conexión, dado
		// que por defecto están desactivadas
		try (Statement stmt = con.createStatement()) {
			stmt.execute("PRAGMA foreign_keys = ON;");
		}
		return con;
	}

}
