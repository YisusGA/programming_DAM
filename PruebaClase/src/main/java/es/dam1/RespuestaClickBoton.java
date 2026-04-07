package es.dam1;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

// Implementamos el gestor de eventos, que al ser una interfaz, nos obliga a implementar su método
public class RespuestaClickBoton implements EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent event) {
		System.out.println("Me han pulsado...");

	}

}
