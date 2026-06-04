package es.yisus.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.yisus.dao.GameDAO;
import es.yisus.modelo.Game;
import es.yisus.modelo.User;
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
}
