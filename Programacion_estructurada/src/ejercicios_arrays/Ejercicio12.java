package ejercicios_arrays;

/**
 * Leer por teclado una serie de 5 palabras y guardarlas en un array. Leer un nuevo número e indicar cuántas y qué palabras son más largas del valor indicado
 */

import java.util.Scanner;

public class Ejercicio12 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] palabras = new String[5];
		for (int i = 0; i < 5; i++) {
			System.out.println("Introduce una palabra");
			palabras[i] = scan.nextLine();
		}
		System.out.println("Introduce el número comprobador");
		int comprobador = scan.nextInt();
		int contadorMasLargas = 0;
		String[] palabrasMasLargas = new String[5];
		for (int i = 0; i < 5; i++) {
			if (palabras[i].length() > comprobador) {
				contadorMasLargas++;
				palabrasMasLargas[i] = palabras[i];
			}
		}
		System.out.println(contadorMasLargas + " palabras del array tienen más de " + comprobador + " caracteres");
		System.out.println("Las palabras en cuestión son:");
		for (int i = 0; i < 5; i++) {
			if (palabrasMasLargas[i] != null) {
			System.out.print(palabrasMasLargas[i] + " ");
			}
		}
	}

}
