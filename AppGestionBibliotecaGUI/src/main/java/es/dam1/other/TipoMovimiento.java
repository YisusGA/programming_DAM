package es.dam1.other;

public enum TipoMovimiento {
	
	PRESTAMO, DEVOLUCION;
	
	/**
	 * Método para devolver el tipo de movimiento (prestamo o devolucion) en función de una cadena introducida por el usuario
	 * @param input cadena introducida por el usuario
	 * @return el tipo de movimiento, o null si no se introdujo un tipo válido
	 */
	public static TipoMovimiento leerTipo (String input) {
		TipoMovimiento tipo = null;
		for (TipoMovimiento t : TipoMovimiento.values()) {
			if (t.name().equalsIgnoreCase(input)) {
				tipo = t;
			}
		}
		return tipo;
	}

}
