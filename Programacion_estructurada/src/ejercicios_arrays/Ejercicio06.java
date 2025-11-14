package ejercicios_arrays;

/**
 * Leer 5 letras minúsculas y guardarlas en un array. Luego se convierten en mayúsculas sobrescribiendo la letra en el array
 */

import java.util.Scanner;

public class Ejercicio06 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		char[] letras = new char[5];
		for (int i = 0; i < letras.length; i++) {
			System.out.println("Introduce una letra minúscula");
			letras[i] = scan.nextLine().charAt(0);
			while (letras[i] < 97 || letras[i] > 122) {
				System.out.println("Carácter no válido, prueba de nuevo");
				letras[i] = scan.nextLine().charAt(0);
			}
		}
		for (int i = 0; i < letras.length; i++) {
			letras[i] -= 32;
			System.out.print(letras[i] + " ");
		}
		scan.close();
	}

}
