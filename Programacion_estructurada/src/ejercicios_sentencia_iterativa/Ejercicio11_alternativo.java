package ejercicios_sentencia_iterativa;

/**
 * Pedir un número y calcular su factorial
 */

import java.util.Scanner;

public class Ejercicio11_alternativo {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce un número entero");
		int n = scan.nextInt();
		int c = 1; //El número que se va a ir incrementando en 1 su valor por iteración, hasta llegar al valor de n	
		int result = 1;
		while (c <= n) {
			result *= c;
			c++;
		}
		System.out.println("El factorial del número introducido es: " + result);
	}

}

