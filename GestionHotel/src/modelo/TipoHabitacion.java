package modelo;

import teclado.Teclado2;

public enum TipoHabitacion {
	HABITACION, HABITACIONFAMILIAR;
	
	public static TipoHabitacion leerTeclado() {
		String input = Teclado2.leerCadena();
		TipoHabitacion[] tipos = values();
		for (TipoHabitacion tipo : tipos) {
			if (tipo.name().equalsIgnoreCase(input)) {
				return tipo;
			}
		}
		return null;
	}

}
