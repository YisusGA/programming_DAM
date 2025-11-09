package ejercicios_sentencia_iterativa;

/**
 * Pedir un número y calcular su factorial
 */

import java.util.Scanner;

public class Ejercicio11 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce un número entero");
		int n = scan.nextInt();
		int c = n - 1; //El número por el que multiplicamos el número introducido. Su valor inicial debe ser 
					  //n - 1. Luego después de que haga el primer producto en el bucle, va decreciendo su valor en 1 por bucle	
		while (c > 0) {
			n *= c;
			c--;
		}
		System.out.println("El factorial del número introducido es: " + n);
	}

}
