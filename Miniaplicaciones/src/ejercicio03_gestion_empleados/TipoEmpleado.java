package ejercicio03_gestion_empleados;

import teclado.Teclado;

public enum TipoEmpleado {
	PROGRAMADOR, DISEÑADOR;
	
	public static TipoEmpleado leerTeclado(String input) {
		TipoEmpleado[] tipos = values();
		for (TipoEmpleado i : tipos) {
			if (i.name().equalsIgnoreCase(input)) {
				return i;
			}
		}
		return null;
	}
}
