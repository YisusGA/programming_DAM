package ejercicios_arrays;

/**
 * Leer por teclado un array de 10 elementos numéricos enteros y una posición (entre 0 y 9). 
 * Eliminar el elemento situado en la posición dada sin dejar huecos
 */

import java.util.Scanner;

public class Ejercicio18 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int arraySize = 10;
		int[] numeros = new int[arraySize];
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
		for (int i = posicion; i < 9; i++) {
			numeros[i] = numeros[i + 1];
		}
		numeros[9] = 0; //No es indispensable, pero podemos hacer que la última posición del array se vacíe
		for (int i : numeros) {
			System.out.print(i+ " ");
		}
		scan.close();

	}

}
