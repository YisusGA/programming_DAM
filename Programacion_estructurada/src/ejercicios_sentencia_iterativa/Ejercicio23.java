package ejercicios_sentencia_iterativa;

/**
 * Programa que pida un número, y muestre la lista de números primos inferiores a ese número
 */

import java.util.Scanner;

public class Ejercicio23 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce un número entero positivo distinto de 0");
		int n = scan.nextInt();
		while (n <= 0) {
			System.out.println("Debes introducir un número entero positivo");
			n = scan.nextInt();
		}
		for (int i = 1; i <= n; i++) {
			boolean esPrimo = true; //Es fundamental inicializar esto en true, pues lo que hacemos abajo es intentar demostrar si es false; si no se demuestra, entonces es true y el número es primo
			//Si el número es par, excluyendo el 2, entonces no puede ser primo
			if (i % 2 == 0 && i != 2) {
				esPrimo = false;
			//Aquí hay que poner un else if, porque si ponemos un else a secas, el 2 se consideraría no primo. Si el número es 2, como esPrimo se inicializa en true y no entra ni en el if
			//ni en el else if, entonces esPrimo es true y el 2 se considera primo
			} else if (i > 2) {
				int raiz = (int)Math.sqrt(i);
				for (int counter = 3; counter <= raiz; counter += 2) {
					if (i % counter == 0) {
						esPrimo = false;
					}
				}
			}
			if (esPrimo) {
				System.out.println("Número primo encontrado: " + i);
			}
		}
		scan.close();

	}

}
