package ejercicios_arrays;

/**
 * Leer por teclado una serie de 10 números enteros. La aplicación debe indicarnos si los números están  ordenados de forma creciente, decreciente, o si están desordenados
 */

import java.util.Scanner;

public class Ejercicio13 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] numeros = new int [10];
		for (int i = 0; i < 10; i++) {
			System.out.println("Introduce un número entero");
			numeros[i] = scan.nextInt();
		}
		scan.close();
		int max = numeros[0];
		int min = numeros[0];
		boolean creciente = false;
		boolean decreciente = false;
		for (int i = 0, j = 1; j < 10; i++, j++) {
			if (numeros[j] > numeros[i]) {
				creciente = true;
			} else {
				creciente = false;
				break;
			}
		}	
		for (int i = 0, j = 1; j < 10; i++, j++) {
			if (numeros[j] < numeros[i]) {
				decreciente = true;
			} else {
				decreciente = false;
				break;
			}
		}
		if (creciente) {
			System.out.println("Los números tienen orden creciente");
		} else if (decreciente) {
			System.out.println("Los números tienen orden decreciente");
		} else {
			System.out.println("Los números están desordenados");
		}
	}

}
