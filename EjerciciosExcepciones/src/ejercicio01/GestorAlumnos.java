package ejercicio01;

import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class GestorAlumnos {
	private static Map<String, Alumno> alumnos = new TreeMap<>();

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
					yearValido = true;
					scan.nextLine();
				} catch (InputMismatchException ex) {
					ex.printStackTrace();
					System.out.println();
					System.out.println("El año introducido no tiene un formato válido");
					System.out.println();
					scan.nextLine();
				}
			}
			Alumno a = crearAlumno(nif, nombre, year);
			if (a != null) {
				alumnos.put(nif, a);
				System.out.println("Alumno añadido");
			} else {
				System.err.println("Año negativo, no se añadió el alumno");
			}
		}
		System.out.println("Finalizando programa...");
		scan.close();

	}

	public static Alumno crearAlumno(String nombre, String nif, int year) {
		Alumno a = null;
		if (year >= 0) {
			a = new Alumno(nombre, nif, year);
		}
		return a;
	}

	public static boolean validarNif(String nif) throws NifExistenteException {
		if (alumnos.containsKey(nif)) {
			throw new NifExistenteException();
		}
		return true;
	}

}
