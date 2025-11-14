package ejercicios_arrays;

/**
 * Leer por teclado dos arrays de 5 números enteros y mezclarlas en un tercero de la forma: el 1° de A, el 1° de B, el 2° de A, el 2° de B, etc.
 */

import java.util.Scanner;

public class Ejercicio08 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] num1 = new int[5];
		int[] num2 = new int[5];
		int[] num3 = new int[10];
		for (int i = 0; i < 5; i++) {
			System.out.println("Array 1. Introduce un número entero");
			num1[i] = scan.nextInt();
		}
		for (int i = 0; i < 5; i++) {
			System.out.println("Array 2. Introduce un número entero");
			num2[i] = scan.nextInt();
		}
		System.out.print("Array 3: ");
		for (int i = 0, j = 0; j < 5; i++) {
			num3[j] = num1[i];
			System.out.print(num3[j] + " ");
			j++;
			num3[j] = num2[i];
			System.out.print(num3[j] + " ");
		}
		scan.close();

	}

}
