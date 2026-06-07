package es.yisus.controller;

import java.sql.SQLException;
import es.yisus.app.SnakeGame;
import es.yisus.dao.UserDAO;
import es.yisus.modelo.Game;
import es.yisus.modelo.User;
import es.yisus.service.GameService;
import es.yisus.service.UserService;
import es.yisus.utils.Leaderboard;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class GUIController {
	private ObservableList<Leaderboard> leaderboard;
	private ObservableList<Game> savedGames;

	@FXML
	private TextField nicknameInput;
	@FXML
	private Label resultLabel;
	@FXML
	private TableView<Leaderboard> leaderboardTable;
	@FXML
	private TableColumn<Leaderboard, String> nicknameColumn;
	@FXML
	private TableColumn<Leaderboard, Integer> scoreColumn;
	@FXML
	private ListView<Game> savedGamesView;

	public void initialize() {
		savedGames = FXCollections.observableArrayList();
		savedGamesView.setItems(savedGames);
		nicknameColumn.setCellValueFactory(new PropertyValueFactory<>("nickname"));
		scoreColumn.setCellValueFactory(new PropertyValueFactory<>("score"));
		try {
			leaderboard = FXCollections.observableArrayList(GameService.getLeaderBoard());
			leaderboardTable.setItems(leaderboard);
			if (leaderboard.size() == 0) {
				resultLabel.setText("No scores were retrieved");
			}
		} catch (SQLException e) {
			System.err.println("Developer message: Scores couldn't be retrieved from the database");
			resultLabel.setText("Scores couldn't be retrieved");
			e.printStackTrace();
		}
	}

	@FXML
	public void loadGameByNickname() {
		savedGames.clear();
		String nickname = nicknameInput.getText();
		if (nickname.isBlank()) {
			nickname = "RandomUser";
		}

		User user = null;

		try {
			user = UserService.getUserByNickname(nickname);
		} catch (SQLException e) {
			System.err.println("Error loading user, starting new game with random user");
			try {
				user = UserService.getUserByNickname("RandomUser");
			} catch (SQLException e1) {
				System.err.println("Error accesing DB to get RandomUser");
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

		Stage stage = (Stage) (nicknameInput.getScene().getWindow());

		if (user == null) {
			// If no user was found, a new game with RandomUser as nickname is launched
			user = new User(nickname);
			try {
				UserDAO.insertUser(user);
			} catch (SQLException e) {
				System.err.println("Error inserting RandomUser in the DB");
				e.printStackTrace();
			}
			SnakeGame.playGame(stage, user);
		} else {
			// If user exists, program tries to retrieve a save game and add it to an
			// ObservableList, that is linked to a ListView in the GUI
			try {
				savedGames.addAll(GameService.getUnfinishedGamesByUser(user));
			} catch (SQLException e) {
				System.err.println("Error accesing DB to get user's saved games");
				e.printStackTrace();
			}

			if (savedGames.isEmpty()) {
				// If user exists but no saved game was recovered, a new game is launched for
				// that user
				System.out.println("No saved games recovered for that user, a new game is started");
				SnakeGame.playGame(stage, user);
			} else {
				// If user exists and they have a saved game associated, user is given the
				// option to load it by double clicking on it
				// User can also ignore it and click on New Game, which will launch method
				// startNewGame
				resultLabel.setText("Double click a game on the list to load save state");

				// Event listener: double click on ListView
				final User finalUser = user;
				getSelectedGameFromList(stage, finalUser);
			}
		}
	}

	private void getSelectedGameFromList(Stage stage, final User finalUser) {
		savedGamesView.setOnMouseClicked(event -> {
			if (event.getClickCount() == 2) {
				Game selectedGame = savedGamesView.getSelectionModel().getSelectedItem();
				if (selectedGame != null) {
					try {
						// Program loads the whole game
						Game fullGame = GameService.loadGame(selectedGame.getId(), finalUser);
						// Program launches game
						SnakeGame.playLoadedGame(stage, fullGame);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		});
	}

	@FXML
	public void startNewGame() {
		String nickname = nicknameInput.getText();
		if (nickname.isBlank()) {
			nickname = "RandomUser";
		}

		try {
			// Program tries to retrieve the user with entered nickname, or creates a new
			// one with RandomUser if it returned nothing
			User user = UserService.getUserByNickname(nickname);
			if (user == null) {
				user = new User(nickname);
				UserDAO.insertUser(user);
			}

			// Program gets Stage and launch game
			Stage stage = (Stage) (nicknameInput.getScene().getWindow());
			SnakeGame.playGame(stage, user);

		} catch (SQLException e) {
			System.err.println("Error starting game due to DB access error...");
			e.printStackTrace();
		}
	}

}
