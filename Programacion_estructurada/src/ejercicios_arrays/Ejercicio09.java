package ejercicios_arrays;

/**
 * Leer los datos correspondientes a dos arrays de 12 elementos numéricos, y mezclarlos en un tercero de la forma: 3 de la tabla A, 3 de la B, otros 3 de A, otros 3 de la B, etc.
 */

import java.util.Random;

public class Ejercicio09 {

	public static void main(String[] args) {
		int[] num1 = new int[12];
		int[] num2 = new int[12];
		int[] num3 = new int[24];
		Random generador = new Random();
		System.out.println("Array 1: ");
		for (int i = 0; i < 12; i++) {
			num1[i] = generador.nextInt();
			System.out.print(num1[i] + " ");
		}
		System.out.println();
		System.out.println("Array 2: ");
		for (int i = 0; i < 12; i++) {
			num2[i] = generador.nextInt();
			System.out.print(num2[i] + " ");
		}
		System.out.println();
		System.out.print("Array 3: ");
		int i1 = 0; //Contador de posición del array 1
		int i2 = 0; //Contador de posición del array 2
		int j = 0; //Contador de posición del array 3
		while (j < 24) {
			for (int k = 0; k < 3; i1++, j++, k++) {
				num3[j] = num1[i1];
				System.out.print(num3[j] + " ");
			}
			for (int k = 0; k < 3; i2++, j++, k++) {
				num3[j] = num2[i2];
				System.out.print(num3[j] + " ");
			}
		}	

	}

}
