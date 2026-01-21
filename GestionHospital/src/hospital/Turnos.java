package hospital;

import teclado.Teclado2;

public enum Turnos {
	MAÑANA, TARDE, NOCHE;

	public static Turnos leerTeclado() {
		String input = Teclado2.leerCadena();
		Turnos[] turnos = values();
		for (Turnos turno : turnos) {
			if (turno.name().equalsIgnoreCase(input)) {
				return turno;
			}
		}
		return null;
	}
}
