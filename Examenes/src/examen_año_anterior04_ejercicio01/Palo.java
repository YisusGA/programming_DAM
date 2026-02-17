package examen_año_anterior04_ejercicio01;

import teclado.Teclado2;

public enum Palo {
	OROS, COPAS, BASTOS, ESPADAS;

	public static Palo leerTeclado() {
		String input = Teclado2.leerCadena();
		Palo[] tipos = values();
		for (Palo tipo : tipos) {
			if (tipo.name().equals(input)) {
				return tipo;
			}
		}
		return null;
	}

}
