package model;

import teclado.Teclado2;

public enum EstadoEnvio {
	CREADO, ENVIADO, RECIBIDO, DEVUELTO;
	
	public static EstadoEnvio leerTeclado() {
		String input = Teclado2.leerCadena();
		EstadoEnvio[] estados = values();
		for (EstadoEnvio estado : estados) {
			if (estado.name().equalsIgnoreCase(input)) {
				return estado;
			}
		}
		return null;
	}

}
