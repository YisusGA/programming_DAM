package hospital;

import teclado.TecladoOK;

public enum Turnos {
	MAÑANA, TARDE, NOCHE;

	public static Turnos leerTeclado() {
		String input = TecladoOK.leerCadena();
		Turnos[] turnos = values();
		for (Turnos turno : turnos) {
			if (turno.name().equalsIgnoreCase(input)) {
				return turno;
			}
		}
		return null;
	}
}
