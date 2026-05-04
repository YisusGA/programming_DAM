package application;

public class ServiceController {

	public static Double calcularPrecioFinal(String precioBaseTxt, Integer descuento) {
		Double result = null;
		Double precioBase = parsearDouble(precioBaseTxt);
		if (descuento != null && precioBase != null) {
			result = precioBase * (100 - descuento) / 100.0;
		}
		return result;
	}

	public static Double parsearDouble(String precioBase) {
		Double result = null;
		try {
			result = Double.parseDouble(precioBase);
		} catch (NumberFormatException e) {
			System.err.println("No se pudo parsear el dato introducido");
			e.printStackTrace();
		}
		return result;
	}

}
