package es.yisus.controller;

import java.sql.SQLException;
import java.util.List;

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

public class GUIController {
	private ObservableList<Leaderboard> leaderboard;
	@FXML
	private TextField nicknameInput;
	@FXML
	private Label resultLabel;
	@FXML
	private TableView<Leaderboard> leaderBoardTable;
	@FXML
	private TableColumn<Leaderboard, String> nicknameColumn;
	@FXML
	private TableColumn<Leaderboard, Integer> scoreColumn;

	public void initialize() {
		nicknameColumn.setCellValueFactory(new PropertyValueFactory<>("nombreLibro"));
		scoreColumn.setCellValueFactory(new PropertyValueFactory<>("fecha"));
		List<Leaderboard> lb;
		try {
			lb = GameService.getLeaderBoard();
			if (lb != null) {
				leaderboard = FXCollections.observableArrayList();
				leaderboard.addAll(lb);
				leaderBoardTable.setItems(leaderboard);
			} else {
				resultLabel.setText("Scores couldn't be retrieved");
			}
		} catch (SQLException e) {
			System.err.println("Developer message: Scores couldn't be retrieved from the database");
			resultLabel.setText("Scores couldn't be retrieved");
			e.printStackTrace();
		}
	}

	@FXML
	public User searchUserByNickname() {
		String nickname = nicknameInput.getText();
		User user = new User("RandomUser");
		try {
			user = UserService.getOrCreateUser(nickname);
		} catch (SQLException e) {
			System.err.println("Error loading user, starting new game with random user");
			e.printStackTrace();
		}
		return user;

	}
}
