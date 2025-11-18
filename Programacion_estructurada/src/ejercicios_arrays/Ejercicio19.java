package ejercicios_arrays;

/**
 * Leer dos series de 10 enteros, que estarán ordenados crecientemente. Copiar (fusionar) las dos series en una tercera, de forma que sigan ordenadas
 */

import java.util.Scanner;

public class Ejercicio19 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		// Variables
		int arraySize = 10;
		int[] num1 = new int[arraySize];
		int[] num2 = new int[arraySize];
		int[] num3 = new int[arraySize * 2];

		// Array 1
		System.out.println("Array 1");
		System.out.println("Introduce un número entero. El orden debe ser creciente");
		num1[0] = scan.nextInt();
		for (int i = 1; i < 10; i++) {
			int n;
			while ((n = scan.nextInt()) < num1[i - 1]) {
				System.out.println("El número introducido no es válido, debe ser mayor que el anterior");
			}
			num1[i] = n;
		}
		// Array 2
		System.out.println("Array 2");
		System.out.println("Introduce un número entero. El orden debe ser creciente");
		num2[0] = scan.nextInt();
		for (int i = 1; i < 10; i++) {
			int n;
			while ((n = scan.nextInt()) < num2[i - 1]) {
				System.out.println("El número introducido no es válido, debe ser mayor que el anterior");
			}
			num2[i] = n;
		}
		for (int i = 0; i < num3.length;) {
			
		}
		scan.close();

	}

}
