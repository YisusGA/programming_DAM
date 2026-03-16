package model;

import teclado.TecladoOK;

public enum TipoEnvio {
	ENVIOESTANDAR, ENVIOREFRIGERADO, ENVIOURGENTE;
	
	public static TipoEnvio leerTeclado() {
		String input = TecladoOK.leerCadena();
		TipoEnvio[] tipos = values();
		for (TipoEnvio tipo : tipos) {
			if (tipo.name().equalsIgnoreCase(input)) {
				return tipo;
			}
		}
		return null;
	}

}
