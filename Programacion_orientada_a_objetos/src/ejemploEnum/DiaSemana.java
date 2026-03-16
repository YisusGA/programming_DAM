package ejemploEnum;

import teclado.TecladoOK;

public enum DiaSemana {

	LUNES, MARTES, MIERCOLES, JUEVES, VIERNES;

	public static DiaSemana leerTeclado() {
		String input = TecladoOK.leerCadena();
		DiaSemana[] dias = values(); // values() es un método de enum que devuelve un array con los valores de la
										// clase enum
		for (DiaSemana dia : dias) { // También se podría poner directamente for (DiaSemana dia : values()) {, sin
										// necesidad de almacenarlo en un array
			if (dia.name().equalsIgnoreCase(input)) { // equalsIgnoreCase() para ignorar mayúsculas y minúsculas
														// .name() es un método que tiene un objeto de tipo enum para
														// conseguir su nombre
				return dia;
			}
		}
		return null;
	}
}
