package es.yisus.dbcontext;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class DBContext {
	private static File localAppData;
	private static boolean dbLocalAppData = true;
	private static String URL;
	private static final String create_table_users = "CREATE TABLE users (id INTEGER PRIMARY KEY AUTOINCREMENT, nickname TEXT NOT NULL UNIQUE);";
	private static final String create_table_games = "CREATE TABLE games (id INTEGER PRIMARY KEY AUTOINCREMENT, user_id INTEGER NOT NULL, score INTEGER DEFAULT 0, date_time DATETIME DEFAULT CURRENT_TIMESTAMP, finished INTEGER DEFAULT 0 CHECK(finished IN (0, 1)), FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE);";
	private static final String create_table_gameStates = "CREATE TABLE game_states (game_id INTEGER PRIMARY KEY, board_width INTEGER NOT NULL, board_height INTEGER NOT NULL, food_x INTEGER NOT NULL, food_y INTEGER NOT NULL, current_direction TEXT NOT NULL, FOREIGN KEY (game_id) REFERENCES games(id) ON DELETE CASCADE);";
	private static final String create_table_snakeSegments = "CREATE TABLE snake_segments (game_id INTEGER NOT NULL, segment_order INTEGER NOT NULL, pos_x INTEGER NOT NULL, pos_y INTEGER NOT NULL, PRIMARY KEY (game_id, segment_order), FOREIGN KEY (game_id) REFERENCES game_states(game_id) ON DELETE CASCADE);";

	// DB checking and creation (if it doesn't already exists)
	public static void dbCheckingAndCreation() {
		try {
			if (System.getenv("LOCALAPPDATA") != null) {
				localAppData = new File(System.getenv("LOCALAPPDATA") + "\\snakegame");

				try {
					Files.createDirectory(localAppData.toPath());
				} catch (FileAlreadyExistsException e) {
					// Directory is not created
//					e.printStackTrace();
				}
				try {
					localAppData = new File(System.getenv("LOCALAPPDATA") + "\\snakegame\\snakegame.db");
					Files.createFile(localAppData.toPath());
					dbTableCreation();
				} catch (FileAlreadyExistsException e) {
					// File is not created
//					e.printStackTrace();
				}

			} else {
				dbLocalAppData = false;
			}
		} catch (IOException | NullPointerException | SQLException e) {
			System.out.println("Using backup database");
			dbLocalAppData = false;
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		if (dbLocalAppData) {
			URL = "jdbc:sqlite:" + System.getenv("LOCALAPPDATA") + "\\snakegame\\snakegame.db";
			URL = URL.replace("\\", "/");
		} else {
			URL = "jdbc:sqlite:src/main/resources/snakegame.db";
		}

		Connection con = DriverManager.getConnection(URL);
		// FK checking restrictions are activated each time a connection is established,
		// since they are deactivated by default in SQLite
		try (Statement stmt = con.createStatement()) {
			stmt.execute("PRAGMA foreign_keys = ON;");
		}
		return con;
	}

	private static void dbTableCreation() throws SQLException {
		try (Connection con = getConnection(); Statement stmt = con.createStatement()) {
			stmt.execute(create_table_users);
			stmt.execute(create_table_games);
			stmt.execute(create_table_gameStates);
			stmt.execute(create_table_snakeSegments);
		}
	}

}
