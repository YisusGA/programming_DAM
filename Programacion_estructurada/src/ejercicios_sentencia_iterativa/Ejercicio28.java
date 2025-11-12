package ejercicios_sentencia_iterativa;

/**
 * Pide un número (que debe estar entre 0 y 10) y mostrar la tabla de multiplicar de dicho número
 */

import java.util.Scanner;

public class Ejercicio28 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce un número entero entre 0 y 10");
		int n = scan.nextInt();
		while (n < 0 || n > 10) {
			System.out.println("Número no válido, prueba de nuevo");
			n = scan.nextInt();
		}
		for (int i = 0; i <= 10; i++) {
			System.out.println(n + " * " + i + " = " + n * i);
		}
	}

}
