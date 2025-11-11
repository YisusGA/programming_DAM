package ejercicios_sentencia_iterativa;

/**
 * Programa que solicite un número N e indique si es o no primo
 */

import java.util.Scanner;

public class Ejercicio21_alternativo {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int divisorCount = 0;
		boolean primo = true;
		System.out.println("Introduce un número entero");
		int n = scan.nextInt();
		if (n == 1) {
			primo = false;
		}	
		for (int divisor = 2; divisor < n; divisor++) {	
			if (n % divisor == 0) {
				primo = false;
			}
		}	
		System.out.println("¿El número introducido es primo? " + primo);
		scan.close();
	}

}
