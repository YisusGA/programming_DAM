package es.dam1.controller;

import es.dam1.model.Calculadora;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
	// int op1; // Esto es una solución para poder almacenar el primer número que
	// metamos en el
	// campo de texto, pero no es una buena decisión de diseño meter datos en el
	// Controller, sería mejor sacarlo a otro lado
	boolean suma = false;
	boolean resta = false;

	@FXML
	TextField dato;
	@FXML
	Label result;

	Calculadora calculadora = new Calculadora();

	@FXML
	public void botonSuma() {
		calculadora.setOp1(Integer.parseInt(dato.getText()));
		resta = false;
		suma = true;
		dato.clear();
	}

	@FXML
	public void botonResta() {
		calculadora.setOp1(Integer.parseInt(dato.getText()));
		suma = false;
		resta = true;
		dato.clear();
	}

	@FXML
	public void botonIgual() {
		calculadora.setOp2(Integer.parseInt(dato.getText()));
		if (suma) {
			result.setText(calculadora.sumar() + "");
		}
		if (resta) {
			result.setText(calculadora.restar() + "");
		}
		suma = false;
		resta = false;
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
