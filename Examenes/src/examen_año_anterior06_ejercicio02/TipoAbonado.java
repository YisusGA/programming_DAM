package examen_año_anterior06_ejercicio02;

public enum TipoAbonado {
	REGULAR, VIP;
	
	public static TipoAbonado devolverTipoAbonado(String input) {
		TipoAbonado tipo = null;
		for (TipoAbonado i : values()) {
			if (i.name().equalsIgnoreCase(input)) {
				tipo = i;
			}
		}
		return tipo;
	}

}
