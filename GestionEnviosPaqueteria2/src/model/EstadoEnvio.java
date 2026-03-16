package model;

import teclado.TecladoOK;

public enum EstadoEnvio {
	CREADO, ENVIADO, RECIBIDO, DEVUELTO;
	
	public static EstadoEnvio leerTeclado() {
		String input = TecladoOK.leerCadena();
		EstadoEnvio[] estados = values();
		for (EstadoEnvio estado : estados) {
			if (estado.name().equalsIgnoreCase(input)) {
				return estado;
			}
		}
		return null;
	}

}
