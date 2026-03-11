package ejercicio02;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GestorAlumnos {
	private static Alumno[] alumnos;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
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
			} catch (InputMismatchException ex) {
//				ex.printStackTrace();
				System.err.println("Número no válido, prueba de nuevo");
				scan.nextLine(); // ¿Por qué es necesario poner este scan.nextLine() para que no entre en un
									// bucle infinito?
			}
		}

		createAlumno("1", "1", 5);
//		alumnos = new Alumno[numAlumnos];

//		for (Alumno i : alumnos) {
//			if (nacidoYearBisiesto(i)) {
//				numBisiestos++;
//			}
//		}

		System.out.printf("Hay %d alumnos que han nacido en año bisiesto", numBisiestos);

	}

	public static boolean nacidoYearBisiesto(Alumno alumno) {
		int year = alumno.getYear();
		boolean result = false;
		if ((year % 4 == 0 && year % 100 != 0) || (year % 100 == 0 && year % 400 == 0)) {
			result = true;
		}
		return result;
	}

	public static void createAlumno(String nif, String nombre, int year) {
		boolean creado = false;
		while (!creado) {
			try {
				Alumno[] aux = new Alumno[alumnos.length + 1];
				for (int i = 0; i < alumnos.length; i++) {
					aux[i] = alumnos[i];
				}
				aux[aux.length - 1] = new Alumno(nif, nombre, year);
				alumnos = aux;
				creado = true;
			} catch (NullPointerException ex) {
				alumnos = new Alumno[1];
			}
		}
	}

}
