package ejercicio02;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GestorAlumnos {
	private static Alumno[] alumnos = new Alumno[0];
	private static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		int numAlumnos = 1;
		boolean numAlumnosValido = false;
		int numBisiestos = 0;
		while (!numAlumnosValido) {
			try {
				System.out.println("¿Cuántos alumnos quieres añadir?");
				numAlumnos = scan.nextInt();
				if (numAlumnos >= 1) {
					numAlumnosValido = true;
				} else {
					System.err.println("El número introducido debe ser mayor o igual que 1");
				}
				scan.nextLine();
			} catch (InputMismatchException ex) {
//				ex.printStackTrace();
				System.err.println("Número no válido, prueba de nuevo");
				scan.nextLine(); // ¿Por qué es necesario poner este scan.nextLine() para que no entre en un
									// bucle infinito? Aunque no tiene ningún sentido tener que ponerlo, porque lee
									// int en cada iteración, parece ser que es necesario, por el motivo que sea. Se
									// debe de quedar pillado algo en el buffer y nos obliga a tener que descartar
									// una línea para que funcione el siguiente scan.nextInt()
			}
		}

		// Descomentar esta línea de debajo para comprobar cómo se gestiona la
		// NullPointerException que se generaría al intentar leer la longitud del array
		// siendo este null. Es importante meter esta gestión de NullPointerException
		// debido a que si alguien usa mi método addAlumno en un contexto en el que el
		// array pueda ser null, tiene que poder gestionar esa NullPointerException

//		alumnos = null; 
		
		for (int i = 0; i < numAlumnos; i++) {
			Alumno a = null;
			String nif;
			do {
				nif = validarNif();
			} while (nif == null);
			System.out.println("Introduce el nombre del alumno");
			String nombre = scan.nextLine();
			boolean creado = false;
			while (!creado) {
				try {
					System.out.println("Introduce el año de nacimiento del alumno");
					int year = scan.nextInt();
					a = Alumno.createAlumno(nif, nombre, year);
					scan.nextLine();
					creado = true;
				} catch (InputMismatchException ex) {
//					ex.printStackTrace();
					System.err.println("El formato del año introducido no es válido");
					scan.nextLine();
				} catch (CreateAlumnoException ex) {
					System.err.println("El año no puede ser negativo");
					scan.nextLine();
				}
			}
			System.out.println(addAlumno(a));
		}

		for (Alumno i : alumnos) {
			if (nacidoYearBisiesto(i)) {
				numBisiestos++;
			}
		}

		System.out.printf("Hay %d alumno(s) que han nacido en año bisiesto", numBisiestos);
		scan.close();

	}

	public static boolean nacidoYearBisiesto(Alumno alumno) {
		int year = alumno.getYear();
		boolean result = false;
		if ((year % 4 == 0 && year % 100 != 0) || (year % 100 == 0 && year % 400 == 0)) {
			result = true;
		}
		return result;
	}

	public static String addAlumno(Alumno a) {
		boolean added = false;
		while (!added) {
			try {
				Alumno[] aux = new Alumno[alumnos.length + 1];
				for (int i = 0; i < alumnos.length; i++) {
					aux[i] = alumnos[i];
				}
				aux[aux.length - 1] = a;
				alumnos = aux;
				added = true;
			} catch (NullPointerException ex) {
//				ex.printStackTrace();
				alumnos = new Alumno[0];
			}
		}
		return "Alumno añadido";
	}

	/**
	 * Método para validar que el nif introducido es único y no existe previamente
	 * en el array
	 * 
	 * @return el nif leído por teclado si no existía previamente en el array o null
	 *         si ya existía
	 */
	public static String validarNif() {
		String nif = null;
		System.out.println("Introduce el nif del alumno, no debe coincidir con uno ya existente");
		String input = scan.nextLine();
		try {
			boolean existe = false;
			for (int i = 0; !existe && i < alumnos.length; i++) {
				if (alumnos[i].getNif().equals(input)) {
					existe = true;
				}
			}
			if (alumnos.length == 0 || !existe) {
				nif = input;
			}

		} catch (NullPointerException ex) {
//				ex.printStackTrace();

			// Si salta esta excepción en el for cuando llama a alumnos.length, es porque
			// aún no hay alumnos en el array, y por lo tanto no es necesario comprobar si
			// el nif ya existe en el array. Por ello, capturamos la excepción, devolvemos
			// el nif leído y no hacemos nada más
			nif = input;
		}

		return nif;
	}

}
