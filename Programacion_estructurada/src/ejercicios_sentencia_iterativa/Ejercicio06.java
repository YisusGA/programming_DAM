package ejercicios_sentencia_iterativa;

/**
 * Programa que lea un número N mayor que 0 y calcule la siguiente suma: 1+2+3+...+N.
 */

import java.util.Scanner;

public class Ejercicio06 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce un número entero");
		int n = scan.nextInt();
		scan.close();
		int c = n--; //Es super importante que sea un post-decremento, para que la c tome el valor inicial de n y luego n decrezca una unidad antes de entrar en el bucle
		if (n <= 0) {
			System.err.println("El número introducido debe ser mayor que 0");
			System.exit(0);
		}
		/*
		 * c comienza con el valor inicial que tenía n, y n con un valor de nInicial - 1. Ambos se suman y n decrece su valor en 1 antes de entrar al siguiente bucle. Por ejemplo, si nInicial es 5, en 
		 * el primer bucle se suman 5 + 4, en el segundo bucle, sumamos 3 los 5 + 4 que ya teníamos (5 + 4 + 3). Y así sucesivamente.
		 */
		while (n > 0) {
			c += n;
			n--;
		}
		System.out.println("El resultado de la suma es: " + c);
	}

}
