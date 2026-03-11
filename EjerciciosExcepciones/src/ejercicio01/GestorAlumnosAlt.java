package ejercicio01;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/*
 * Lo que cambia en esta versión con respecto a GestorAlumnos es que nunca devuelvo un objeto de Alumno que 
 * sea null, sino que valido el año mediante una clase Exception que yo creo y obligo a introducir un año válido
 */

public class GestorAlumnosAlt {
	private static Map<String, AlumnoAlt> alumnos = new TreeMap<>();

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("¿Cuántos alumnos quieres añadir?");
		int num = scan.nextInt();
		scan.nextLine(); // Limpiar buffer
		for (int i = 0; i < num; i++) {
			System.out.println("Introduce el nombre del alumno");
			String nombre = scan.nextLine();
			String nif = "";
			boolean nifValido = false;
			while (!nifValido) {
				try {
					System.out.println("Introduce el nif del alumno");
					nif = scan.nextLine();
					nifValido = validarNif(nif);
				} catch (NifExistenteException ex) {
					ex.printStackTrace();
					System.out.println();
					System.out.println("Ese nif ya existe");
					System.out.println();
				}
			}
			int year = 0;
			boolean yearValido = false;
			while (!yearValido) {
				try {
					System.out.println("Introduce el año de nacimiento del alumno");
					year = scan.nextInt();
					yearValido = validarYear(year);
					scan.nextLine(); // Este es necesario para limpiar buffer porque si no da problemas al pedir el
										// nombre del siguiente alumno en la siguiente iteración del bucle. Si no fuera
										// por eso, no haría falta
				} catch (InputMismatchException ex) {
					ex.printStackTrace();
					System.out.println();
					System.out.println("El año introducido no tiene un formato válido");
					System.out.println();
					scan.nextLine(); // ¿Por qué es necesario poner este scan.nextLine() para que no entre en un
					// bucle infinito? Aunque no tiene ningún sentido tener que ponerlo, porque lee
					// int en cada iteración, parece ser que es necesario, por el motivo que sea. Se
					// debe de quedar pillado algo en el buffer y nos obliga a tener que descartar
					// una línea para que funcione el siguiente scan.nextInt()

				} catch (YearNoValidoExceptionAlt ex) { // Esto también podría validarse en el propio try, con un if que
														// sólo actualice yearValido a true si el año es positivo. O
														// metiendo la condición de que sólo se salga del bucle while si
														// el año introducido es >= 0. Entonces, tendríamos esas 2
														// opciones adicionales a la de crear una Exception como he
														// hecho yo aquí. La opción de crear una clase Exception (ya sea
														// interna o externa) es la opción más engorrosa. Mejor meter la
														// validación dentro del propio try, con un if. Ver
														// GestorAlumnosAlt2
					ex.printStackTrace();
					System.out.println();
					System.out.println("Ese año no es válido, debe ser positivo");
					System.out.println();
				}
			}
			alumnos.put(nif, AlumnoAlt.crearAlumno(nif, nombre, year));
			System.out.println("Alumno añadido");
		}
		System.out.println("Finalizando programa...");
		scan.close();

	}

	public static boolean validarNif(String nif) throws NifExistenteException {
		if (alumnos.containsKey(nif)) {
			throw new NifExistenteException();
		}
		return true;
	}

	public static boolean validarYear(int year) throws YearNoValidoExceptionAlt {
		if (year < 0) {

//			throw new YearNoValidoException(); // Con esto, usaríamos la clase YearNoValidoException creada dentro de este paquete

			// Como crear una clase Exception sólo para usarla una vez es un poco inútil,
			// mejor crear la clase dentro de esta misma clase.
			// No sería buena idea crear una clase anónima, pues una clase anónima no nos
			// permite darle un nombre a la Exception, sino que se queda como Exception. Y
			// luego no podemos distinguir entre diferentes Exception. Por lo tanto, la
			// mejor solución es crear una clase interna, como se ve debajo. Y luego hacer
			// un throw de esa clase Exception interna
			throw new YearNoValidoExceptionAlt();
		}
		return true;
	}

	// Esto es una clase interna, que está dentro de la clase GestorAlumnosAlt, y al
	// mismo nivel que cualquier método. Implicaciones de tener una clase interna:
	// para que existan objetos de esta clase interna, deben existir objetos de la
	// clase que la contiene, es decir, un objeto de GestorAlumnos. Debemos hacer
	// que sea static, pues la llamamos desde un método static. Como es static,
	// entonces no necesitamos instanciar como tal un objeto de GestorAlumnosAlt,
	// sino que se llame desde el contexto general de GestorAlumnosAlt. Y como la
	// vamos a llamar desde un método static contenido dentro de la clase
	// GestorAlumnosAlt, entonces podemos llamar a esta clase sin problema y sin
	// hacer nada más. Ver método validarYear(), que es desde donde la llamamos
	static class YearNoValidoExceptionAlt extends RuntimeException {
		public YearNoValidoExceptionAlt() {
			super("El año introducido no es válido, debe ser positivo");
		}
	}

}
