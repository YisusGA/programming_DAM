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

public class SistemaVotacionesAlt4 {
	private static Scanner scan = new Scanner(System.in);
	private static List<String> candidates = new ArrayList<>();
	// Usamos un TreeMap para que las claves se almacenen en un TreeSet de Strings,
	// así al recorrer el Map, se recorre según el orden de String, que es
	// alfabético
	private static Map<String, Integer> votaciones = new TreeMap<>();
	private static int numberCandidates = 5; // Ponemos el número por defecto en 5, para que sea el número de candidatos
	// por defecto en el caso de que el usuario no meta un int válido cuando
	// se le pregunta por el número de candidatos
	private static int numVotaciones = 5;

	public static void main(String[] args) throws VotoNoValidoException {
		System.out.println("¿Cuántos candidatos quieres añadir?");
		numberCandidates = validaNumero();

		scan.nextLine(); // Limpiamos el buffer del Scanner
		for (int i = 0; i < numberCandidates; i++) {
			System.out.println("Introduce el nombre del candidato");
			addCandidates(scan.nextLine());
		}

		for (int i = 0; i < numVotaciones; i++) {
			// Capturamos o propagamos
			String voto = getVoto(); // Si dejamos esto así, nos sale en rojo y el compilador nos da 2 opciones:
										// capturar con un try-catch o hacer un throws en el main. Si optamos por esta
										// segunda opción, se lanza la excepción y se detiene la ejecucción. Optar por
										// esta segunda opción se llama propagar. Al dar a click a la opción de Throws,
										// se añade ya automáticamente el throws a la declaración del método main
			if (votaciones.containsKey(voto)) {
				int numVotos = votaciones.get(voto);
				votaciones.replace(voto, numVotos + 1);
			} else {
				votaciones.put(voto, 1);
			}
		}
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

	}

	public static boolean addCandidates(String name) {
		boolean added = false;
		if (candidates != null) {
			candidates.add(name);
			added = true;
		}
		return added;
	}

	public static String getVoto() throws VotoNoValidoException { // Tenemos que poner el throws seguido de nuestra
																	// clase de excepción para que el método pueda
																	// lanzar esa excepción
		System.out.println("Introduce el nombre del candidato a las elecciones al que quieres dar tu voto");
		String voto = scan.nextLine();
		if (!candidates.contains(voto)) {
			// Creamos nuestra propia excepción y la lanzamos
			throw new VotoNoValidoException(); // Lanza la excepción y se para. Y ya la persona que vea que ha
												// devuelto esa excepción, decide lo que hacer con ella
		}
		System.out.println("Ha votado a " + voto);

		return voto;
	}

	public static String mayoriaAbsoluta() { // Aunque queda feo el doble return, es la única forma de poder parar la
												// iteración en cuanto encuentre el candidato con mayoría absoluta.
												// Otras opciones que no usen programación funcional serían demasiado
												// complejas y no merecen la pena
		Set<Map.Entry<String, Integer>> setVotaciones = votaciones.entrySet();
		for (Map.Entry<String, Integer> entry : setVotaciones) {
			if (entry.getValue() > numVotaciones / 2) {
				return entry.getKey();
			}
		}
		return null;
	}

	public static int validaNumero() {
		int n = 0;
		boolean noValido = true;
		while (noValido) {
			try {
				n = scan.nextInt();
				noValido = false;
			} catch (InputMismatchException ex) {
				System.err.println("Numero no válido, prueba de nuevo");
				scan.nextLine(); // Limpiar buffer
			} finally {
				// El finally normalmente se usa para cerrar recursos que se hayan abierto en el
				// try-catch
			}
		}
		return n;
	}

}
