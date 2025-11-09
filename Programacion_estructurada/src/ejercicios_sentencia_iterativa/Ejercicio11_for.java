package ejercicios_sentencia_iterativa;

/**
 * Pedir un número y calcular su factorial
 */

import java.util.Scanner;

public class Ejercicio11_for {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce un número entero");
		int n = scan.nextInt();	
		int result = 1;
		for (int c = 1; c <= n; c++) {
			result *= c;
		}
		System.out.println("El factorial del número introducido es: " + result);
	}

}