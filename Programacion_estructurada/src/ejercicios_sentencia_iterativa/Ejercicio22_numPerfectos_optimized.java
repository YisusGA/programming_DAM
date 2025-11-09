package ejercicios_sentencia_iterativa;

import java.util.Scanner;

/**
 * Programa para calcular y mostrar todos los números perfectos hasta el límite de limit == Long.MAX_VALUE. Este variable limit se usará de la siguiente forma:
 *  para que un número sea perfecto, se tiene que cumplir que (2^n) - 1 sea un número primo. Si esto se cumple, entonces calculamos el número perfecto con la siguiente 
 *  fórmula:  numPerfecto = (2^(n - 1)) *  ((2^n) - 1). Lo que vamos a hacer es ir incrementando el valor de esa n desd 1 hasta el limit.
 *  En esta versión: 
 * -Empezamos el contador en 3, pues no hay números primos divisibles entre 2 otros que el mismo 2 (Todos los numeros pares son divisibles entre 2, quitando la posibilidad de ser primos, entonces, si quitamos el propio 2 de la ecuacion, ganamos mucho tiempo).
 * -Fijamos el limite como Math.sqrt(operacionPrimo). Y vamos comprobando los divisores de 2 en 2. 3-5-7-9-11-13-15-17. Hasta llegar a la raiz cuadrada de 'operacionPrimo'. Si ninguno de los anteriores divisores, ni siquiera la propia raiz cuadrada de 'operacionPrimo', es divisor suyo, eso significa que es primo. 
 *  Solo hemos comprobado los divisores IMPARES y hasta la raiz cuadrada del numero.
 */

public class Ejercicio22_numPerfectos_optimized {

	public static void main(String[] args) {
		long limit = Integer.MAX_VALUE;
		boolean primo = false;
		for (int n = 1; n < limit; n++) {
			double operacionPrimo = (Math.pow(2, n) - 1);
			boolean esPrimo = true;
			if (operacionPrimo < 2 || (operacionPrimo % 2 == 0 && operacionPrimo != 2)) {
				esPrimo = false;
			}
			else if (operacionPrimo == 2) {
				esPrimo = true;
			}
			else {
				int raiz = (int)Math.sqrt(operacionPrimo);
				for (int i = 3; i <= raiz; i += 2) {
					if (operacionPrimo % i == 0) {
						esPrimo = false;
					}
				}
			}
			if (primo) {
				double numPerfecto = (Math.pow(2, (n -1)) * (Math.pow(2, n) - 1));
				System.out.println("Número perfecto encontrado: " + numPerfecto);
			}
		}

	}

}
