package ejercicio08;

import java.util.ArrayList;
import java.util.Collection;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import teclado.Teclado2;

public class SistemaVotaciones {
	private static Scanner scan = new Scanner(System.in);
	private static List<String> candidates = new ArrayList<>();
	// Usamos un TreeMap para que las claves se almacenen en un TreeSet de Strings,
	// así al recorrer el Map, se recorre según el orden de String, que es
	// alfabético
	private static Map<String, Integer> votaciones = new TreeMap<>();
	private static int numberCandidates = 5; // Ponemos el número por defecto en 5, para que sea el número de candidatos
	// por defecto en el caso de que el usuario no meta un int válido cuando
	// se le preguntan por el número de candidatos
	private static int numVotaciones = 30;

	public static void main(String[] args) {
		System.out.println("¿Cuántos candidatos quieres añadir?");

		// Capturamos la excepción. La ventaja de capturar la excepción es que el
		// programa no se detiene en ningún caso. CUIDADO: un try-catch abre un bloque.
		// Así que si declaramos una variable dentro del bloque, no va a ser accesible
		// desde fuera del bloque. Tenemos que declararla antes del bloque si queremos
		// que siga siendo accesible fuera del bloque

		int[] numeros = new int[0];
		try {
			numberCandidates = scan.nextInt(); // Esto puede generar un InputMismatchException
			numeros[0] = numberCandidates; // Esto va a generar un ArrayIndexOutOfBoundsException
		} catch (InputMismatchException ex) { // La superclase de InputMismatchException es Exception. En este caso,
												// podríamos poner directamente Exception ex. La ventaja de usar
												// Exception es que me sirve de paraguas para cualquier tipo de
												// excepction que pueda salir. El problema de poner Exception es que el
												// bloque del try me puede generar un montón de cosas distintas, y no
												// podré distinguir cuál es la que se ha generado exactamente. La
												// solución es hacer un catch para cada tipo de excepción que se pueda
												// generar
			// Esto es lo que se ejecuta si salta una excepción
			ex.printStackTrace(); // Se suele poner esto por defecto en los catch, para ver los detalles de las
									// excepciones que se generan. Así puedes saber en qué puntos está fallando tu
									// programa. Te muestra los datos de la excepción, pero no se detiene el
									// programa. Cuando ya he pasado las fases de prueba y queremos subir el
									// programa a producción, quitamos esta parte para que no salgan print con los
									// errores. Lo que se suele hacer en verdad es sustituir esto por una escritura
									// en un log externo de los errores que se generan
			System.err.println("Número no válido. Número de candidatos establecido por defecto en 5");
		} catch (ArrayIndexOutOfBoundsException ex) {
			System.err.println("No he podido rellenar el array");
		}
		scan.nextLine();
		for (int i = 0; i < numberCandidates; i++) {
			System.out.println("Introduce el nombre del candidato");
			addCandidates(scan.nextLine());
		}

		if (rondaVotaciones()) {
			System.out.println("Resultado votaciones");
			System.out.println("--------------------");
			Set<Map.Entry<String, Integer>> resultados = votaciones.entrySet();
			for (Map.Entry<String, Integer> entry : resultados) {
				System.out.print(entry.getKey() + ": ");
				System.out.println(entry.getValue() + " votos");
			}

			String candidatoMayoria = mayoriaAbsoluta();
			if (candidatoMayoria != null) {
				System.out.print("Hay un candidato con mayoría absoluta: ");
				System.out.println(candidatoMayoria);
			} else {
				System.out.println("No hay un candidato con mayoría absoluta");
			}
		} else {
			System.err.println("No existen candidatos");
		}

	}

	public static boolean addCandidates(String name) {
		boolean added = false;
		if (candidates != null) {
			candidates.add(name);
			added = true;
		}
		return added;
	}

	public static boolean rondaVotaciones() {
		boolean votacionOK = false;
		if (candidates != null && candidates.size() > 0) {
			Random generador = new Random();
			for (int i = 0; i < numVotaciones; i++) {
				int voto = generador.nextInt(0, candidates.size());
				String votado = candidates.get(voto);
				if (votaciones.containsKey(votado)) {
					int numVotos = votaciones.get(votado);
					votaciones.replace(votado, ++numVotos);
				} else {
					votaciones.put(votado, 1);
				}
			}
			votacionOK = true;
		}
		return votacionOK;
	}

	public static String mayoriaAbsoluta() {
		String candidatoMayoria = null;
		Set<Map.Entry<String, Integer>> setVotaciones = votaciones.entrySet();
		for (Map.Entry<String, Integer> entry : setVotaciones) {
			if (entry.getValue() >= numVotaciones / 2) {
				candidatoMayoria = entry.getKey();
			}
		}
		return candidatoMayoria;
	}

	public static String mayoriaAbsoluta2() {
		String candidatoMayoria = null;
		Collection<Integer> votos = votaciones.values();
		boolean encontrado = false;
		Iterator<Integer> it = votos.iterator();
		while (!encontrado && it.hasNext()) {
			int num = it.next();
			if (num >= numVotaciones / 2) {
				encontrado = true;
			}
		}
		return candidatoMayoria;
	}

}
