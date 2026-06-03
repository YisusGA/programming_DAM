package es.yisus.controller;

import java.sql.SQLException;
import java.util.List;

import es.yisus.app.SnakeGame;
import es.yisus.dao.UserDAO;
import es.yisus.modelo.User;
import es.yisus.service.GameService;
import es.yisus.service.UserService;
import es.yisus.utils.Leaderboard;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class GUIController {
	private ObservableList<Leaderboard> leaderboard;
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

	public void initialize() {
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
	public User searchUserByNickname() throws SQLException {
		String nickname = nicknameInput.getText();
		if (nickname.isBlank()) {
			nickname = "RandomUser";
		}
		User user;
		try {
			user = UserService.getOrCreateUser(nickname);
		} catch (SQLException e) {
			System.err.println("Error loading user, starting new game with random user");
			user = UserService.getUserByNickname("RandomUser");
			if (user == null) {
				user = new User("RandomUser");
				UserDAO.insertUser(user);
			}
			e.printStackTrace();
		}
		Stage stage = (Stage) (nicknameInput.getScene().getWindow());
		SnakeGame.playGame(stage, user);
		return user;

	}
}
