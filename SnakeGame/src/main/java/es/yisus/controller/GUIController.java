package es.yisus.controller;

import java.sql.SQLException;
import es.yisus.app.SnakeGame;
import es.yisus.dao.GameDAO;
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
	        user = UserService.getUserByNickname(nickname);
	    } catch (SQLException e) {
	        System.err.println("Error loading user, starting new game with random user");
	        user = UserService.getUserByNickname("RandomUser");
	        e.printStackTrace();
	    }
	    
	    Stage stage = (Stage) (nicknameInput.getScene().getWindow());

	    if (user == null) {
	        // El usuario no existe: Lo creamos y le lanzamos una partida nueva
	        user = new User(nickname);
	        UserDAO.insertUser(user);
	        SnakeGame.playGame(stage, user);
	    } else {
	        // El usuario existe: Buscamos sus partidas
	        savedGames = FXCollections.observableArrayList();
	        savedGames.addAll(GameService.getUnfinishedGamesByUser(user));
	        
	        // ¡ESTO FALTABA! Enlazar la lista recuperada con la vista de JavaFX
	        savedGamesView.setItems(savedGames);

	        if (savedGames.isEmpty()) {
	            // Si existe pero no tiene partidas a medias, le creamos una nueva directamente
	            SnakeGame.playGame(stage, user);
	        } else {
	            resultLabel.setText("Haz doble clic en una partida de la lista para continuar.");
	            
	            // Evento: Escuchar el doble clic en el ListView
	            final User finalUser = user;
	            savedGamesView.setOnMouseClicked(event -> {
	                if (event.getClickCount() == 2) {
	                    Game selectedSummary = savedGamesView.getSelectionModel().getSelectedItem();
	                    if (selectedSummary != null) {
	                        try {
	                            // Cargamos TODO el árbol del juego (Serpiente, comida, etc.)
	                            Game fullGame = GameDAO.loadGame(selectedSummary.getId(), finalUser);
	                            // Llamamos a un nuevo método que crearemos en el Paso 2
	                            SnakeGame.playLoadedGame(stage, fullGame);
	                        } catch (SQLException e) {
	                            e.printStackTrace();
	                        }
	                    }
	                }
	            });
	        }
	    }
	    return user;
	}
	
	@FXML
	public void startNewGame() {
	    String nickname = nicknameInput.getText();
	    if (nickname.isBlank()) {
	        nickname = "RandomUser";
	    }
	    
	    try {
	        // Recuperamos el usuario (o lo creamos si es totalmente nuevo)
	        User user = UserService.getUserByNickname(nickname);
	        if (user == null) {
	            user = new User(nickname);
	            UserDAO.insertUser(user);
	        }
	        
	        // Obtenemos la ventana actual y lanzamos el juego vacío usando tu método original
	        Stage stage = (Stage) (nicknameInput.getScene().getWindow());
	        SnakeGame.playGame(stage, user);
	        
	    } catch (SQLException e) {
	        System.err.println("Error al intentar iniciar una nueva partida.");
	        e.printStackTrace();
	    }
	}
	
	
}
