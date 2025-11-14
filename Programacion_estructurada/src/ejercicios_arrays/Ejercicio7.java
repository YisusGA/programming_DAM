package ejercicios_arrays;

/**
 * Leer 5 palabras y guardarlas en un array. A continuación, indicar si alguna de ellas es un número entero, tanto positivo como negativo
 */

import java.util.Scanner;

public class Ejercicio7 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String[] palabras = new String[5];
		boolean todasCifras = false;
		for (int i = 0; i < 5; i++) {
			System.out.println("Introduce una palabra o número");
			palabras[i] = scan.nextLine();
		}
		for (int i = 0; i < palabras.length; i++) {
			if (palabras[i].charAt(0) == 45) {
				for (int j = 1; j < palabras[i].length(); j++) {
					if (palabras[i].charAt(j) >= 48 && palabras[i].charAt(j) <= 57) {
						todasCifras = true;
					}
				}
			} else {
				for (int j = 0; j < palabras[i].length(); j++) {
					if (palabras[i].charAt(j) >= 48 && palabras[i].charAt(j) <= 57) {
						todasCifras = true;
					}
				}
			}	
		}
		if (todasCifras) {
			System.out.println("Una de las palabras es un número");
		} else {
			System.out.println("Ninguna de las palabras es un número");
		}
		scan.close();
	}

}
