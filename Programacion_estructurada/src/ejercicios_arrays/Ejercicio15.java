package ejercicios_arrays;

/**
 * Crear un programa que lea por teclado una array de 10 números enteros y lo desplace una posición hacia abajo: 
 * el primero pasa a ser el segundo, el segundo pasa a ser el tercero y así sucesivamente. El último pasa a ser el primero.
 */

import java.util.Scanner;

public class Ejercicio15 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] numeros = new int[10];
		for (int i = 0; i < 10; i++) {
			System.out.println("Introduce un número entero");
			numeros[i] = scan.nextInt();
		}
		System.out.print("Array original: ");
		for (int i = 0; i < 10; i++) {
			System.out.print(numeros[i] + " ");
		}
		int num1Original = numeros[0];
		for (int i = 0; i < 9; i++) {
			numeros[i] = numeros[i + 1];
		}
		numeros[9] = num1Original;
		System.out.println();
		System.out.print("Array cambiado: ");
		for (int i = 0; i < 10; i++) {
			System.out.print(numeros[i] + " ");
		}
	}

}
