package es.dam1;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;

// Implementamos el gestor de eventos, que al ser una interfaz, nos obliga a implementar su método
public class RespuestaClickBoton implements EventHandler<ActionEvent> {

	private Label mensaje;
	
	public RespuestaClickBoton(Label mensaje) {
		this.mensaje = mensaje;
	}
	
	@Override
	public void handle(ActionEvent event) {
		mensaje.setText("Me has pulsado");
	}

}
