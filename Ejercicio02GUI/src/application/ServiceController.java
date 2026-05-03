package application;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ServiceController {

	private static ObservableList<String> lista = FXCollections.observableArrayList();

	public static ObservableList<String> getLista() {
		return lista;
	}

	public static void setLista(ObservableList<String> lista) {
		ServiceController.lista = lista;
	}

	public static void addToList(String input) {
		lista.add(input);
	}
	
	public static void removeFromList(String input) {
		lista.remove(input);
	}
}
