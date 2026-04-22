package es.dam1.controller;

import java.io.IOException;

import es.dam1.model.Calculadora;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {
	// int op1; // Esto es una solución para poder almacenar el primer número que
	// metamos en el
	// campo de texto, pero no es una buena decisión de diseño meter datos en el
	// Controller, sería mejor sacarlo a otro lado

	@FXML
	TextField dato;
	@FXML
	Label result;

	Calculadora calculadora = new Calculadora();
	String operacion = "";

//	@FXML
//	public void botonSuma() {
//		calculadora.setOp1(Integer.parseInt(dato.getText()));
//		operacion = "+";
//		dato.clear();
//	}
//	
//	@FXML
//	public void botonResta() {
//		calculadora.setOp1(Integer.parseInt(dato.getText()));
//		operacion = "-";
//		dato.clear();
//	}

	@FXML
	public void botonOperacion(ActionEvent event) {
		calculadora.setOp1(Integer.parseInt(dato.getText()));
		dato.clear();
		Button botonPulsado = (Button) event.getSource();
		operacion = botonPulsado.getText(); // Esto pilla el texto que tiene el botón, que es justamente lo que usamos
											// en el swtich-case del método botonIgual()
	}

	@FXML
	public void botonIgual() {
		calculadora.setOp2(Integer.parseInt(dato.getText()));
		switch (operacion) {
		case "+" -> {
			result.setText(calculadora.sumar() + "");
		}
		case "-" -> {
			result.setText(calculadora.restar() + "");
		}
		default -> {
			result.setText("");
		}
		}
	}

	@FXML
	public void entrar(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/calculadora.fxml"));
		try {
			// Creamos una nueva escena, y le cargamos una GUI
			Scene scene = new Scene(loader.load());
			// Casteamos la fuente del event a Node, pues todo en JavaFX es un Node. Y de
			// ahí, pillamos la escena, y de esa escena, la ventana. Eso se castea a stage,
			// y se almacena dentro de un objeto Stage. Con esto, lo que conseguimos es
			// capturar el Stage de la clase con el main, a partir de saacar el Stage al que
			// pertenece el primer botón que pulsamos en la primera escena para abrir la
			// calculadora
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			// Y le ponemos al Stage la nueva escena que hemos creado
			stage.setScene(scene);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * Parace que no es necesario que la clase implemente la interfaz Initializable
	 * e implemente y sobreescriba su método initialize (como vimos con Stefano)
	 * para que JavaFX inicialice este método al arrancar la app. Funciona así tal
	 * cual como está puesto, con este nombre y con la etiqueta FXML
	 */
	@FXML
	public void initialize() {
		System.out.println("Arrancando app...");
	}

}
