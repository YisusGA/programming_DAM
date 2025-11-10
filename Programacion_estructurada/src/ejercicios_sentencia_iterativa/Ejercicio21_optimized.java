package ejercicios_sentencia_iterativa;

/**
 * Programa que solicite un número N e indique si es o no primo
 * 
 * En esta versión: 
 * -Empezamos el contador en 3, pues no hay números primos divisibles entre 2 otros que el mismo 2 (Todos los numeros pares son divisibles entre 2, quitando la posibilidad de ser primos, entonces, si quitamos el propio 2 de la ecuacion, ganamos mucho tiempo).
 * -Fijamos el limite como Math.sqrt(n). De esta forma, reducimos la complejidad de cálculo del algoritmo, pues ya no tiene que llegar comprobando números hasta el valor de operacionPrimo. Y vamos comprobando los divisores de 2 en 2. 3-5-7-9-11-13-15-17, 
 *  hasta llegar a la raiz cuadrada de 'n'. Si ninguno de los anteriores divisores, ni siquiera la propia raiz cuadrada de 'n', es divisor suyo, eso significa que es primo. 
 *  Solo hemos comprobado los divisores IMPARES y hasta la raiz cuadrada del numero.
 */

import java.util.Scanner;

public class Ejercicio21_optimized {

	public static void main(String[] args) {
		boolean esPrimo = true; //Es fundamental inicializar esto en true, pues lo que hacemos abajo es intentar demostrar si es false; si no se demuestra, entonces es true y el número es primo
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce un número entero positivo");
		int n = scan.nextInt();
		while (n <= 0) {
			System.out.println("Debes introducir un número entero positivo distinto de 0");
			n = scan.nextInt();
		}
		//Si el número es par, excluyendo el 2, entonces no puede ser primo
		if (n % 2 == 0 && n != 2) {
			esPrimo = false;
		//Aquí hay que poner un else if, porque si ponemos un else a secas, el 2 se consideraría no primo. Si el número es 2, como esPrimo se inicializa en true y no entra ni en el if
		//ni en el else if, entonces esPrimo es true y el 2 se considera primo	
		} else if (n > 2) {
			int raiz = (int)Math.sqrt(n);
			for (int i = 3; i <= raiz; i += 2) {
				if (n % i == 0) {
					esPrimo = false;
				}
			}
		}
		System.out.println("¿El número introducido es primo? " + esPrimo);
		scan.close();
	}

}
