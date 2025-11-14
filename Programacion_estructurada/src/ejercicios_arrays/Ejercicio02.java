package ejercicios_arrays;

/**
 * Leer 5 palabras y decir si una de ellas es igual a otra solicitada previamente
 */

import java.util.Scanner;

public class Ejercicio02 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("¿Cuántas palabras quieres introducir?");
		int numPalabras = scan.nextInt();
		String trash = scan.nextLine();
		String [] palabras = new String [numPalabras];
		System.out.println ("Introduce una palabra");
		for (int i = 0; i < palabras.length; i++) {
			if (i > 0) {
				System.out.println ("Introduce otra palabra");
			}
			palabras [i] = scan.nextLine();			
		}
		boolean coincide = false;
		for (int i = 0; i < palabras.length; i++) {
			for (int j = 0; j < palabras.length; j++) {
				if (palabras [i].equals(palabras[j])) {
					coincide = true;
				}
			}
		}
		if (coincide) {
			System.out.println("Algunas palabras son iguales");
		} else {
			System.out.println("Ninguna palabra coincide con otra de las introducidas");
		}
	}

}
