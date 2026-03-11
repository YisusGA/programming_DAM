package ejercicio01;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/*
 * Lo que cambia en esta versión con respecto a GestorAlumnosAlt es que valido que el año introducido sea mayor o
 * igual que o mediante un if dentro del try que actualiza el boolean a true, en lugar de complicarme la vida tanto
 * haciendo una clase interna o externa para lanzar una excepcion. Esta versión es bastante más equilibraday menos 
 * engorrosa
 */


public class GestorAlumnosAlt2 {
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
					if (year >= 0) {
						yearValido = true;
					} else {
						System.out.println();
						System.err.println("El año introducido debe ser mayor o igual que 0");
						System.out.println();
					}
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

}
