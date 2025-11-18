package ejercicios_arrays;

/**
 * Leer por teclado un array de 10 elementos numéricos enteros y una posición (entre 0 y 9). 
 * Eliminar el elemento situado en la posición dada sin dejar huecos
 */

import java.util.Scanner;

public class Ejercicio18_profe {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int arraySize = 10;
		int[] numeros = new int[arraySize];
		int[] aux = new int[arraySize - 1];
		for (int i = 0; i < 10; i++) {
			System.out.println("Introduce un número entero");
			numeros[i] = scan.nextInt();
		}
		System.out.println("Introduce una posición");
		int posicion = scan.nextInt();
		while (posicion < 0 || posicion > 9) {
			System.out.println("Posición no válida, prueba de nuevo");
			posicion = scan.nextInt();
		}
		for (int i = 0, j =0; i < arraySize; i++) {
			//Rellena el array aux con los valores del array numeros, pero saltándose la posición introducida. Luego continúa rellenando desde la
			//posición de después de la introducida
			if (i != posicion) {
				aux[j++] = numeros[i];
			}
		}
		//Método para hacer que un array pase de apuntar de una dirección de memoria a otra
		numeros = aux;
		for (int i : numeros) {
			System.out.print(i+ " ");
		}
		scan.close();

	}

}