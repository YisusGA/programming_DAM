package ejercicios_sentencia_iterativa;

/*
 * Pedir 5 calificaciones de alumnos y decir al final si hay algún suspenso
 */

import java.util.Scanner;

public class Ejercicio17 {

	public static void main(String[] args) {
		boolean suspenso = false;
		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < 5; i++) {
			System.out.println("Introduce tu nota");
			double nota = scan.nextDouble();
			if (nota < 5) {
				suspenso = true;
			}
		}
		if (suspenso) {
			System.out.println("Ha habido algún suspenso");
		} else {
			System.out.println("No ha habido ningún suspenso");
		}
	}

}
