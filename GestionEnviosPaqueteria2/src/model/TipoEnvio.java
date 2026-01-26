package model;

import teclado.Teclado2;

public enum TipoEnvio {
	ENVIOESTANDAR, ENVIOREFRIGERADO, ENVIOURGENTE;
	
	public static TipoEnvio leerTeclado() {
		String input = Teclado2.leerCadena();
		TipoEnvio[] tipos = values();
		for (TipoEnvio tipo : tipos) {
			if (tipo.name().equalsIgnoreCase(input)) {
				return tipo;
			}
		}
		return null;
	}

}
