package ejercicios_sentencia_iterativa;

/**
 * Programa que, dado un número entero, muestre en líneas consecutivas cada una de sus cifras
 * En esta versión, afrontamos el problema con un algoritmo que obtiene las cifras mediante operaciones
 * matemáticas, en lugar de convertir el num a String y sacar sus char.
 */

import java.util.Scanner;

public class Ejercicio20_alternativo {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce un número entero");
		int n = scan.nextInt();
		while (n > 0) {
			System.out.println(n % 10);
			n /= 10;
		}
	}

}
