package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class GUIController implements Initializable {
	private GestorAlumno g; // Atributo que inicializaremos dentro del método initialize

	@FXML
	private void add() {
		System.out.println(g.size());
	}

	// Este método se implementa desde la interfaz Initializable que hemos
	// implementado en la clase, y se ejecutará cada vez que se inicialize la clase
	// GUIController
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		g = new GestorAlumno();

	}

}
