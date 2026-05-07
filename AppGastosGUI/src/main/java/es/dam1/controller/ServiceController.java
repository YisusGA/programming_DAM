package es.dam1.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ServiceController {
	public static ObservableList<String> listaGastos = FXCollections.observableArrayList();
	
	/**
	 * Método para parsear un String a un Double
	 * @param input la String leído del TextField
	 * @return la String parseada a Double, o null si no pudo parsearse
	 */
	public static Double parsearDouble(String input) {
		Double result = null;
		try {
			result = Double.parseDouble(input);
		} catch (NumberFormatException e) {
			System.err.println("Dato no válido");
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * Método para parsear un String a un Integer
	 * @param input la String leído del TextField
	 * @return la String parseada a Double, o null si no pudo parsearse
	 */
	public static Integer parsearInteger(String input) {
		Integer result = null;
		try {
			result = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			System.err.println("Dato no válido");
			e.printStackTrace();
		}
		return result;
	}

}
