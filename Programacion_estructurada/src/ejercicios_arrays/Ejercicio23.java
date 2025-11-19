package ejercicios_arrays;

/**
 * Dado un array de n enteros pasados por teclado, ordenarlo (el resultado será un nuevo array)
 */

import java.util.Scanner;

public class Ejercicio23 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("Introduce el tamaño deseado de array");
		int arraySize = scan.nextInt();

		int[] array1 = new int[arraySize];
		int[] array2 = new int[arraySize];

		for (int i = 0; i < arraySize; i++) {
			System.out.println("Introduce un número entero");
			array1[i] = scan.nextInt();
		}
		System.out.print("Array original: ");
		for (int i : array1) {
			System.out.print(i + ", ");
		}
		int min = Integer.MAX_VALUE;
//		for (int i = 0; i < arraySize; i++) {
//			for (int k = 0; k < arraySize; k++) {
//				if (array1[k] < min) {
//					min = array1[k];
//					array2[i] = min;
//				}
//			}
//		}
		for (int i = 0; i < arraySize; i++) {
			for (int j = 1; j < arraySize; j++) {
				if (array1[j] < array1[j - 1]) {
					min = array1[j];
				}
				array2[i] = min;
				System.out.println("array 2 : " + array2[i]);
				System.out.println("min: " + min);
				for (int k = 0; k < arraySize; k++) {
					if (array1[k] == min) {
						array1[k] = Integer.MAX_VALUE;
						System.out.println("array 1: " + array1[k]);
					}
				}
			}
		}
		System.out.println();
		System.out.print("Nuevo array ordenado: ");
		for (int i : array2) {
			System.out.print(i + ", ");
		}
		scan.close();

	}

}
