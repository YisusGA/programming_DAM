package ejercicios_sentencia_iterativa;

/**
 * Un número perfecto es un entero positivo igual a la suma de sus divisores (exceptuando como divisor al propio número). 
 * Escriba un programa que acepte un entero positivo y determine si es un número perfecto.
 */

import java.util.Scanner;

public class Ejercicio22 {

	public static void main(String[] args) {
		int suma = 0;
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce un número entero positivo");
		int n = scan.nextInt();
		if (n <= 0) {
			System.err.println("Debes introducir un número entero positivo distinto de 0");
			System.exit(0);
		}
		for (int i = 1; i < n; i++) {
			if (n % i == 0) {
				suma += i;
			}
		}
		String numPerfecto = suma == n ? "El número introducido es un número perfecto" : "El número introducido NO es un número perfecto";
		System.out.println(numPerfecto);
		scan.close();
	}

}
