package ejercicio04_zoologico_virtual;

import java.util.Scanner;

public enum TipoAnimal {
	PERRO, GATO, AVE;

	public static TipoAnimal escogerTipo(String input) {
		TipoAnimal tipoEncontrado = null;
		TipoAnimal[] tipos = values();
		for (TipoAnimal i : tipos) {
			if (i.name().equals(input)) {
				tipoEncontrado = i;
			}
		}
		return tipoEncontrado;
	}

}
