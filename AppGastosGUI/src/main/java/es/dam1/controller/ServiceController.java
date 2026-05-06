package es.dam1.controller;

public class ServiceController {
	
	/**
	 * Método para parsear un String de gasto a un Double
	 * @param input la String leído del TextField
	 * @return la String parseada a Double, o null si no pudo parsearse
	 */
	public static Double parsearGasto(String input) {
		Double result = null;
		try {
			result = Double.parseDouble(input);
		} catch (NumberFormatException e) {
			System.err.println("Gasto no válido");
			e.printStackTrace();
		}
		return result;
	}

}
