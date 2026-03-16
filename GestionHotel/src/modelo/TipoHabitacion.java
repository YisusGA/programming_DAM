package modelo;

import teclado.TecladoOK;

public enum TipoHabitacion {
	HABITACION, HABITACIONFAMILIAR;
	
	public static TipoHabitacion leerTeclado() {
		String input = TecladoOK.leerCadena();
		TipoHabitacion[] tipos = values();
		for (TipoHabitacion tipo : tipos) {
			if (tipo.name().equalsIgnoreCase(input)) {
				return tipo;
			}
		}
		return null;
	}

}
