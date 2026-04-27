package es.dam1.controller;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.WindowEvent;

public class ServiceController {

	// IMPORTANTE: no puedo crear una instancia aquí del controlador gráfico, pues
	// se creará una instancia vacía que no estará conectada a la que se está viendo
	// por pantalla. En su lugar, lo que hay que hacer es usar el objeto de
	// FXMLLoader que creamos en el método start() de la clase con el main para
	// cargar el controlador real que tiene asociado y almacenarlo dentro de un
	// objeto de la clase GUIController. Y luego usamos el método setController de
	// esta clase (ServiceController) para ponerle ese controlador
	private static GUIController controller;

	public static GUIController getController() {
		return controller;
	}

	public static void setController(GUIController controller) {
		ServiceController.controller = controller;
	}

	public static void confirmarSalida(WindowEvent event) {
		// Creamos la alerta de confirmación
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Guardar cambios");
		alert.setHeaderText("Tienes cambios sin guardar.");
		alert.setContentText("¿Deseas guardar los cambios antes de salir?");

		// Definimos los botones que queremos mostrar
		ButtonType botonSi = new ButtonType("Sí");
		ButtonType botonNo = new ButtonType("No");
		ButtonType botonCancelar = new ButtonType("Cancelar");

		// Agregamos los botones a la alerta
		alert.getButtonTypes().setAll(botonSi, botonNo, botonCancelar);

		// Mostramos la ventana y esperamos la respuesta del usuario
		Optional<ButtonType> resultado = alert.showAndWait();

		if (resultado.isPresent()) {
			if (resultado.get() == botonSi) {
				boolean guardadoExitoso = controller.saveOnExit();
				if (!guardadoExitoso) {
					event.consume();
					System.err.println("Operacion de guardado cancelada por el usuario");
				} else {
					System.out.println("Fichero guardado con exito");
				}
			} else if (resultado.get() == botonNo) {
				System.out.println("Saliendo sin guardar...");
			} else {
				System.out.println("Operacion cancelada");
				event.consume();
			}
		}
	}

	public static String firstCharOfEachWordToUpperCase(String text) {
		String result = null;
		if (text != null && !text.isBlank()) {
			String[] lineas = text.split("\n");
			result = "";
			for (int i = 0; i < lineas.length; i++) {
				String[] palabras = lineas[i].split(" ");
				lineas[i] = "";
				for (int j = 0; j < palabras.length; j++) {
					if (!palabras[j].isEmpty()) {
						System.out.println(palabras[j]);
						palabras[j] = palabras[j].substring(0, 1).toUpperCase()
								+ palabras[j].substring(1).toLowerCase();
					}
					if (j == palabras.length - 1) {
						lineas[i] += palabras[j];
					} else {
						lineas[i] += palabras[j] + " ";
					}
				}
				if (i == lineas.length - 1) {
					result += lineas[i];
				} else {
					result += lineas[i] + "\n";
				}
			}
		}
		return result;
	}
}
