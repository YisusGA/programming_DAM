package ejercicios_arrays;

/**
 * Leer N palabras y guardarlas en un array. A continuación, eliminar los duplicados y crear un nuevo array sin duplicados
 */

import java.util.Scanner;

public class Ejercicio25 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n; //Número de palabras a leer
		System.out.println("Introduce el número de palabras que quieres leer");
		while ((n = scan.nextInt()) <= 0) {
			System.out.println("El número introducido debe ser mayor que 0");
		}
		String trash = scan.nextLine();
		String[] palabras = new String[n];
		for (int i = 0; i < palabras.length; i++) {
			System.out.println("Introduce una palabra");
			palabras[i] = scan.nextLine();
		}
		int counter = 0;
		for (int i = 0; i < palabras.length; i++) {
			for (int j = 0; j < palabras.length; j++) {
				if (palabras [i] != null && palabras[i].equals(palabras[j]) && i != j) {
					counter++;
					palabras[j] = null;
				}
			}
		}
		String[] palabrasNew = new String[palabras.length - counter];
		for (int i = 0, j = 0; i < palabras.length; i++) {
			if (palabras[i] != null) {
				palabrasNew[j] = palabras[i];
				j++;
			}
		}
		for (String i : palabrasNew) {
			System.out.println(i + " ");
		}
		scan.close();
	}

}
