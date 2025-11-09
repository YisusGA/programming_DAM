package ejercicios_sentencia_iterativa;

/**
 * Programa que calcule el mínimo, el máximo y la media de una lista 
 * de números enteros positivos introducidos por el usuario. La lista 
 * finalizará cuando se introduzca un número negativo. El número negativo
 * no cuenta a efectos de calcular mínimo, máximo y media
 */

import java.util.Scanner;

public class Ejercicio15 {

	public static void main(String[] args) {
		int n = 0; //El número que se va a ir leyendo por teclado
		int maximo = 0; //La variable donde vamos a ir actualizando el máximo número introducido
		int minimo = Integer.MAX_VALUE; //La variable donde vamos a ir actualizando el mínimi número introducido
		int suma = 0; //La variable donde vamos a ir sumando los números positivos introducidos
		double media = 0; //La variable que nos va a servir para calcular la media de los números introducidos
		int i = 0; //La variable que vamos a usar para contar el número de números POSITIVOS introducidos
		Scanner scan = new Scanner(System.in);
		while (n >= 0) {
			System.out.println("Introduce un número entero positivo");
			System.out.println("Cuando quieras que el programa termine, introduce un número negativo");
			n = scan.nextInt();
			/*
			 * Para el máximo y para el mínimo, debemos poner en el if la condición de que el número sea mayor o
			 * igual a 0, para que no considere el número negativo que termina el programa como máximo ni como mínimo
			 */
			if (n > maximo && n >= 0) {
				maximo = n;
			}
			if (n < minimo && n >= 0) {
				minimo = n;
			}
			/*
			 * Nótese que tanto la suma como el contador se deben incluir en un if con la condición de que el 
			 * número introducido sea mayor o igual a 0. Con esto, conseguimos que el número negativo que termina
			 * el programa no se considere ni para la suma ni para el contador (valores que usaremos para calcular
			 * la media)
			 */
			if (n >= 0) {
				suma += n; 
				i++;
			}
		}
		/*
		 * Aunque esto mismo puede hacaerse con un bucle for, queda muy raro, porque en un bucle for
		 * se suele usar el primer bloque de sentencias para inicializar la variable contadora (i), y la
		 * última sentencia se suele usar para incrementar esa i. En este caso, i necesita inicializarse
		 * antes del bucle, pues debe existir fuera de este para calcular posteriormente la media. Y el 
		 * contador no puede incrementarse como salida del bucle (en el último bloque de sentencias del for),
		 * porque nos interesa incrementarlo sólo en el caso de que el número introducido sea positivo.
		 * El número negativo que introduzcamos para finalizar el programa no debe considerarse ni a efectos de 
		 * máximo, ni a efectos de mínimo, ni a efectos de media ni a efectos de contarlo como número introducido.  
		 */
		
//		for (int n = 0; n >= 0;) {
//			System.out.println("Introduce un número entero positivo");
//			System.out.println("Cuando quieras que el programa termine, introduce un número negativo");
//			n = scan.nextInt();
//			if (n > maximo && n >= 0) {
//				maximo = n;
//			}
//			if (n < minimo && n >= 0) {
//				minimo = n;
//			}
//			if (n >= 0) {
//				suma += n; 
//				i++;
//			}
//		}
		if (i > 0) {
			media = (double)suma / i;
			System.out.println("El máximo de los números introducidos es: " + maximo);
			System.out.println("El mínimo de los números introducidos es: " + minimo);
			System.out.println("La media de los números introducidos es: " + media);
		}
		else {
			System.out.println("No has introducido ningún número");
		}
		scan.close();
	}

}
