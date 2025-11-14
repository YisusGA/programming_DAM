package ejercicios_arrays;

/**
 * Leer por teclado una serie de 6 números. Una vez insertados todos, indicar el menor y el mayor
 */

import java.util.Scanner;

public class Ejercicio10 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] numeros = new int[6];
		for (int i = 0; i < 6; i++) {
			System.out.println("Introduce un número entero");
			numeros[i] = scan.nextInt();
		}
		int max = numeros[0];
		int min = numeros[0];
		for (int i = 1; i < 6; i++) {
			if (numeros[i] > numeros [0]) {
				max = numeros[i];
			}
			if (numeros[i] < numeros [0]) {
				min = numeros[i];
			}
		}
		System.out.println("Máximo: " + max);
		System.out.println("Mínimo: " + min);
		scan.close();
	}

}
