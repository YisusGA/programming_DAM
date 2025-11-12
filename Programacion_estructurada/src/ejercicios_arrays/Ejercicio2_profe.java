package ejercicios_arrays;

/**
 * Leer 5 palabras y decir si una de ellas es igual a otra solicitada previamente
 */

import java.util.Scanner;

public class Ejercicio2_profe {

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
		System.out.println("¿Qué palabra quieres comprobar?");
		String palabraComprobar = scan.nextLine();
		boolean coincide = false;
		for (int i = 0; i < palabras.length; i++) {
			if (palabras [i].equals(palabraComprobar)) {
				coincide = true;
			}
		}
		if (coincide) {
			System.out.println("Tu palabra coincide con una de las 5 palabras introducidas");
		} else {
			System.out.println("Tu palabra NO coincide con ninguna de las 5 palabras introducidas");
		}
	}

}