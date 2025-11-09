package ejercicios_sentencia_iterativa;

/**
 * Programa que lea un número N mayor que 0 y calcule la siguiente suma: 1+2+3+...+N.
 */

import java.util.Scanner;

public class Ejercicio06_alternativo {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce un número entero");
		int n = scan.nextInt();
		scan.close();
		int i = 1;
		int suma = 0; 
		if (n <= 0) {
			System.err.println("El número introducido debe ser mayor que 0");
			System.exit(0);
		}
		while (i <= n) {
			suma += i;
			i++;
		}
		System.out.println("El resultado de la suma es: " + suma);
	}

}
