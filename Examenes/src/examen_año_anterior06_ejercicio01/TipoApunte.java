package examen_año_anterior06_ejercicio01;

public enum TipoApunte {
	FACTURA, GASTO;

	public static TipoApunte devolverTipo(String input) {
		TipoApunte aux = null;
		for (TipoApunte tipo : values()) {
			if (tipo.name().equalsIgnoreCase(input)) {
				aux = tipo;
			}
		}
		return aux;
	}

}
