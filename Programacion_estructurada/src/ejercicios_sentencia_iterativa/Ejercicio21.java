package ejercicios_sentencia_iterativa;

/**
 * 21.	Programa que solicite un número N e indique si es o no primo
 */

import java.util.Scanner;

public class Ejercicio21 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int divisorCount = 0;
		boolean primo = false;
		System.out.println("Introduce un número entero");
		int n = scan.nextInt();
		for (int divisor = 1; divisor <= n; divisor++) {	
			if (n % divisor == 0) {
				divisorCount++;
			}
		}
		if (divisorCount == 2) {
			primo = true;				
		}	
		System.out.println("¿El número introducido es primo? " + primo);
	}

}
