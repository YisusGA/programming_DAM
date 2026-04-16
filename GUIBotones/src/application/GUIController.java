package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class GUIController {

//	Ya no hace falta declarar los objetos Button para la forma
//	genérica con ActionEvent
//	@FXML
//	Button b1;
//	@FXML
//	Button b2;

//	Sería una locura tener que hacer esto para cada uno de los botones

//	@FXML
//	private void click1() {
//		b1.setText("CLICKED");
//		b1.setDisable(true);
//	}
//	
//	@FXML
//	private void click2() {
//		b2.setText("CLICKED");
//		b2.setDisable(true);
//	}


//	Así que hacemos algo genérico. Ya no haría falta poner fx:id a cada botón en el fxml,
//	porque ya tendrá un id interno automático
	@FXML
	private void click(ActionEvent e) {
		Button b = (Button)e.getSource();
		b.setText("CLICKED");
		b.setDisable(true);		
	}

}
