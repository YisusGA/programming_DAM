package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;

public class GUIController {
	private ObservableList<String> listaIngredientes = FXCollections.observableArrayList();

	@FXML
	ListView<String> listView;
	@FXML
	TextArea textArea;

	@FXML
	public void initialize() {
		listView.setItems(listaIngredientes);
	}

	@FXML
	public void addToList(ActionEvent event) {
		MenuItem item = (MenuItem) event.getSource();
		listaIngredientes.add(item.getText());
	}
	
	@FXML
	public void exportToText() {
		String result = "Lista de ingredientes:\n";
		for (String s : listaIngredientes) {
			result += s + "\n";
		}
		textArea.setText(result);
	}

}
