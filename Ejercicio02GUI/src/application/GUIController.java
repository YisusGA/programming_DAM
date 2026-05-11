package application;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class GUIController {

	@FXML
	TextField inputTxt;
	@FXML
	ListView<String> listaGUI;

	@FXML
	public void initialize() {
		listaGUI.setItems(ServiceController.getLista());
	}

//	@FXML
//	public void addToListButton() {
//		String input = inputTxt.getText().trim();
//		if (!input.isBlank()) {
//			ServiceController.addToList(input);
//			inputTxt.clear();
//		}
//	}
//
//	@FXML
//	public void addToListEnter(KeyEvent event) {
//		String input = inputTxt.getText().trim();
//		if (!input.isBlank()) {
//			if (event.getCode().toString().equals("ENTER")) {
//				ServiceController.addToList(input);
//				inputTxt.clear();
//			}
//		}
//	}

	// Como KeyEvent y ActionEvent heredan ambos de Event, podemos generalizar los 2
	// métodos de arriba en uno sólo, y luego distinguiendo dentro del método de qué
	// clase viene el evento, que es necesario para poder gestionar que la tecla que
	// se pulse sea la de Enter y no otra
	@FXML
	public void addToList(Event event) {
		String input = inputTxt.getText().trim();
		if (!input.isBlank()) {
			if (event.getClass().equals(KeyEvent.class)) {
				if (((KeyEvent) event).getCode().toString().equals("ENTER")) {
					ServiceController.addToList(input);
					inputTxt.clear();
				}
			} else {
				ServiceController.addToList(input);
				inputTxt.clear();
			}
		}
	}

	@FXML
	public void eliminarElemento(MouseEvent event) {
		int numClicks = event.getClickCount();
		if (numClicks == 2) {
			ServiceController.removeFromList(listaGUI.getSelectionModel().getSelectedItem());
			listaGUI.getSelectionModel().clearSelection();
		}
	}

}
