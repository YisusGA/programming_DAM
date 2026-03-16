package ejercicio04;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import teclado.TecladoOK;

public class Main {
	private static Map<String, String> personas = new HashMap<>();

	public static void main(String[] args) {
		System.out.println("¿Cuántas personas quieres insertar?");
		int num = TecladoOK.leerEntero();

		for (int i = 0; i < num; i++) {
			System.out.println("Introduce el nif");
			String nif = TecladoOK.leerCadena();
			System.out.println("Introduce el nombre");
			String nombre = TecladoOK.leerCadena();
			insertarPersona(nif, nombre);
		}

		buscarNifPorNombre();
		System.out.println("Finalizando programa...");
	}

	public static void insertarPersona(String nif, String nombre) {
		personas.put(nif, nombre);
	}

	public static void buscarNifPorNombre() {
		Set<Map.Entry<String, String>> mapView = personas.entrySet();
		String input;
		do {
			boolean encontrado = false;
			System.out.println("Introduce el nombre a buscar. Introduce fin cuando quieras parar");
			input = TecladoOK.leerCadena();
			for (Map.Entry<String, String> entry : mapView) {
				if (entry.getValue().equalsIgnoreCase(input)) {
					System.out.print("NIF: ");
					System.out.println(entry.getKey());
					encontrado = true;
				}
			}
			if (!input.equalsIgnoreCase("fin") && !encontrado) {
				System.err.println("No se ha encontrado ningún nombre con el nif introducido");
			}
			
		} while (!input.equalsIgnoreCase("fin"));
	}

}
