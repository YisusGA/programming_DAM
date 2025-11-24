package estudio_examen2;

/**
 * Leer dos series de 10 enteros, que estarán ordenados crecientemente. Copiar (fusionar) las dos series en una tercera, de forma que sigan ordenadas
 */

import java.util.Scanner;

public class Ejercicio19_arrays {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int arraySize = 10;
		int[] array1 = new int[arraySize];
		int[] array2 = new int[arraySize];
		int[] array3 = new int[arraySize * 2];

		// Llenamos array1
		System.out.println("Introduce un número");
		array1[0] = scan.nextInt();
		for (int i = 1, n = 0; i < array1.length; i++) {
			System.out.println("Introduce otro número");
			while ((n = scan.nextInt()) < array1[i - 1]) {
				System.out.println("Número no válido, debe ser mayor que el introducido anteriormente");
			}
			array1[i] = n;
		}

		// Llenamos array2
		System.out.println("Introduce un número");
		array2[0] = scan.nextInt();
		for (int i = 1, n = 0; i < array2.length; i++) {
			System.out.println("Introduce otro número");
			while ((n = scan.nextInt()) < array2[i - 1]) {
				System.out.println("Número no válido, debe ser mayor que el introducido anteriormente");
			}
			array2[i] = n;
		}

		int i = 0; // Contador array1
		int j = 0; // Contador array2
		int k = 0; // Contador array3

		while (i < array1.length && j < array2.length) {
			if (array1[i] < array2[j]) {
				array3[k] = array1[i];
				i++;
			} else {
				array3[k] = array2[j];
				j++;
			}
			k++;
		}

		while (i < array1.length) {
			array3[k++] = array1[i++];
		}
		while (j < array2.length) {
			array3[k++] = array2[i++];
		}
		
		// Imprimimos todos los valores de array3
		System.out.print("Array fusion: ");
		for (int c : array3) {
			System.out.print(c + " ");
		}
		scan.close();

	}

}
