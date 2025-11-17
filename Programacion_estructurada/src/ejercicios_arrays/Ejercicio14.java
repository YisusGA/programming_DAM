package ejercicios_arrays;

/** 
 * Diseñar una aplicación que declare un array de 10 elementos enteros. Leer mediante el teclado 8 números y guardarlos en el array.
 * Después se debe pedir otro número y una posición del array. Insertar el número en la posición indicada, desplazando los que estén
 * detrás de una posición
 */

import java.util.Scanner;

public class Ejercicio14 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] numeros = new int[10];
		for (int i = 0; i < 8; i++) {
			System.out.println("Introduce un número entero");
			numeros[i] = scan.nextInt();
		}
		System.out.println("Introduce un nuevo número para incluirlo en el array");
		int numeroNuevo = scan.nextInt();
		System.out.println("Introduce la posición del array donde quieres incluirlo, debe estar comprendido entre 0 y 9, ambos incluidos");
		int posicion = scan.nextInt();
		while (posicion < 0 || posicion > 9) {
			System.out.println("Posición no válida, debe ser igual o mayor que 0 e igual o menor que 9");
			posicion = scan.nextInt();
		}
		System.out.print("Array original: ");
		for (int i = 0; i < 10; i++) {
			System.out.print(numeros[i] + " ");
		}
		System.out.println();
		if (posicion >= 8) {
			numeros[posicion] = numeroNuevo;
		} else {
			for (int i = 8; i > posicion; i--) {
				numeros[i] = numeros[i - 1];
			}
			numeros[posicion] = numeroNuevo;
		}
		System.out.print("Array con la inclusión del nuevo número en la posición indicada: ");
		for (int i : numeros) {
			System.out.print(i + " ");
		}
		scan.close();
	}

}
