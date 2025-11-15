package ejercicios_arrays;

/**
 * Leer 10 números enteros. Debemos mostrarlos en el siguiente orden: el primero, el último, el segundo, el penúltimo, el tercero, etc.
 */

import java.util.Scanner;

public class Ejercicio05 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] numeros = new int[10];
		for (int i = 0; i < numeros.length; i++) {
			System.out.println("Introduce un número entero");
			numeros[i] = scan.nextInt();
		}
		System.out.println("La secuencia solicitada de números es: ");
		for (int i = 0; i < (numeros.length / 2); i++) {
			System.out.printf("%1d %1d ", numeros[i], (numeros.length - 1 - i));
		}
		scan.close();
	}

}
