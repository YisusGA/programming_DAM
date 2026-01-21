package hospital;

import teclado.Teclado2;

public enum TipoEmpleado {
	ENFERMERO, MEDICO, ADMINISTRATIVO;

	public static TipoEmpleado leerTeclado() {
		String input = Teclado2.leerCadena();
		TipoEmpleado[] tipos = values();
		for (TipoEmpleado tipo : tipos) {
			if (tipo.name().equalsIgnoreCase(input)) {
				return tipo;
			}
		}
		return null;
	}

}
