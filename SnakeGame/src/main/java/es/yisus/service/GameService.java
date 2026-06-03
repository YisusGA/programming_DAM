package es.yisus.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.yisus.dao.GameDAO;
import es.yisus.modelo.Game;
import es.yisus.utils.Leaderboard;

public class GameService {
	
	public static List<Leaderboard> getLeaderBoard() throws SQLException {
		List<Leaderboard> leaderboard = null;
		List<Game> games = GameDAO.getGames();
		if (games != null) {
			leaderboard = new ArrayList<>();
			for (int i = 0; i < games.size() && i < 10; i++) {
				Game g = games.get(i);
				leaderboard.add(new Leaderboard(g.getUser().getNickname(), g.getScore()));
				leaderboard = leaderboard.reversed();
			}
		}
				
		return leaderboard;
		
	}
}
