package es.dam1;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class RespuestaClickBoton implements EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent event) {
		System.out.println("Me han pulsado...");
		
	}

}
