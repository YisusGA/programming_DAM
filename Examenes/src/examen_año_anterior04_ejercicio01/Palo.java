package examen_año_anterior04_ejercicio01;

import teclado.TecladoOK;

public enum Palo {
	OROS, COPAS, BASTOS, ESPADAS;

	public static Palo leerTeclado() {
		String input = TecladoOK.leerCadena();
		Palo[] tipos = values();
		for (Palo tipo : tipos) {
			if (tipo.name().equals(input)) {
				return tipo;
			}
		}
		return null;
	}

}
