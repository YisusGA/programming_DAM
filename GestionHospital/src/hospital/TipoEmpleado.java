package hospital;

import teclado.TecladoOK;

public enum TipoEmpleado {
	ENFERMERO, MEDICO, ADMINISTRATIVO;

	public static TipoEmpleado leerTeclado() {
		String input = TecladoOK.leerCadena();
		TipoEmpleado[] tipos = values();
		for (TipoEmpleado tipo : tipos) {
			if (tipo.name().equalsIgnoreCase(input)) {
				return tipo;
			}
		}
		return null;
	}

}
