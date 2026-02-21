package ejercicio04_zoologico_virtual;

public enum TipoAnimal {
	PERRO, GATO, AVE;

	public static TipoAnimal escogerTipo(String input) {
		TipoAnimal tipoEncontrado = null;
		TipoAnimal[] tipos = values();
		for (TipoAnimal i : tipos) {
			if (i.name().equals(input.toUpperCase())) {
				tipoEncontrado = i;
			}
		}
		return tipoEncontrado;
	}

}
