package ejercicios_sentencia_iterativa;

/**
 * Programa que cuente todos los números múltiplos de uno solicitado previamente por teclado, comprendidos entre dos números solicitados también previamente por teclado
 */

import java.util.Scanner;

public class Ejercicio05a {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n;
		System.out.println("Introduce el número entero del que quieras conocer sus múltiplos. Debe ser distinto de 0");
		do {
			n = scan.nextInt();
			if (n == 0) {
				System.out.println("El número introducido no puede ser 0. prueba con otro");
			}
		} while (n == 0);	
		System.out.println("Introduce un número de comienzo del intervalo");
		int begin = scan.nextInt();
		System.out.println("Introduce un número de final del intervalo");
		int end = scan.nextInt();
		scan.close();
		int counter = 0;
		if (begin == end) {
			System.err.println("El intervalo introducido no es válido, por favor introduce otros números");
			System.exit(0);
		}
		else if (begin < end) {
			if (n > end) {
				System.err.println("El número introducido no puede ser mayor que el mayor número del intervalo, el número de múltiplos es 0");
				System.exit(0);
			}
			while (begin <= end) {
				if (begin % n == 0) {
					counter++;
				}
				begin++;
			}
		} else {
			if (n > begin) {
				System.err.println("El número introducido no puede ser mayor que el mayor número del intervalo, el número de múltiplos es 0");
				System.exit(0);
			}
			while (end <= begin) {
				if (end % n == 0) {
					counter++;
				}
				end++;
			}
		}
		System.out.println("El número de múltiplos del número introducido dentro del intervalo es de: " + counter + " mútiplos");
	}

}
