package ejercicio05_sistema_vehiculos;

public enum TipoVehiculo {
	COCHE, MOTO, CAMION;
	
	public static TipoVehiculo devolverTipoVehiculo(String input) {
		TipoVehiculo output = null;
		for (TipoVehiculo tipo : values()) {
			if (tipo.name().equalsIgnoreCase(input)) {
				output = tipo;
			}
		}
		return output;
	}
}
