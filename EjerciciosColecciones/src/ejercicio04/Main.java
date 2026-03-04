package ejercicio04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import teclado.Teclado2;

public class Main {
	private static Map<String, String> personas = new HashMap<>();

	public static void main(String[] args) {
		System.out.println("¿Cuántas personas quieres insertar?");
		int num = Teclado2.leerEntero();

		for (int i = 0; i < num; i++) {
			System.out.println("Introduce el nif");
			String nif = Teclado2.leerCadena();
			System.out.println("Introduce el nombre");
			String nombre = Teclado2.leerCadena();
			insertarPersona(nif, nombre);
		}

		List<String> nifsEncontrados = buscarNifPorNombre();
		System.out.println("Esta es la lista de nifs encontrados");
		if (nifsEncontrados != null) {
			for (String i : nifsEncontrados) {
				System.out.println(i);
			}
		} else {
			System.err.println("No se ha encontrado ningún nombre con los nifs introducidos");
		}

	}

	public static void insertarPersona(String nif, String nombre) {
		personas.put(nif, nombre);
	}

	public static List<String> buscarNifPorNombre() {
		String input;
		List<String> nifsEncontrados = new ArrayList<>();
		Set<Map.Entry<String, String>> vistaMap = personas.entrySet();
		boolean encontrado = false;
		do {
			System.out.println("Introduce el nombre a buscar. Introduce fin cuando quieras parar");
			input = Teclado2.leerCadena();
			if (!input.equalsIgnoreCase("fin")) {
				for (Map.Entry<String, String> entry : vistaMap) {
					if (entry.getValue().equalsIgnoreCase(input)) {
						nifsEncontrados.add(entry.getKey());
						encontrado = true;
					}
				}
			}
		} while (!input.equalsIgnoreCase("fin"));
		if (encontrado) {
			return nifsEncontrados;
		} else {
			return null;
		}
	}

}
