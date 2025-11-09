package ejercicios_sentencia_iterativa;

/**
 * Programa que calcule el mínimo, el máximo y la media de una lista 
 * de números enteros positivos introducidos por el usuario. La lista 
 * finalizará cuando se introduzca un número negativo. El número negativo
 * no cuenta a efectos de calcular mínimo, máximo y media.
 * 
 * Con esta versión, conseguimos varias cosas: la primera, hacemos el scan del número introducido en la propia condición de entrada del bucle. De esta forma,
 * nunca se entrará en el bucle si el número introducido es negativo, y nos ahorramos todos los if (n >= 0) de la versión base de este programa. Esto simplifica mucho
 * el código y lo deja más limpio. Además, es importante fijarse también en que en esta versión, el cálculo de la media se hace directamente en en el print del final.
 * Con esto, vemos que realmente en el print se pueden hacer operaciones con expresiones, lo cual puede ser útil cuando simplemente se quiere mostrar el resultado de una
 * operación pero no se quiere almacenar ese resultado en una variable. Este concepto es muy IMPORTANTE para resolver el ejercicio 19, por ejemplo.
 */

import java.util.Scanner;

public class Ejercicio15_PRO {
	public static void main(String[] args) {
		int n = 0; //El número que se va a ir leyendo por teclado
		int maximo = 0; //La variable donde vamos a ir actualizando el máximo número introducido
		int minimo = Integer.MAX_VALUE; //La variable donde vamos a ir actualizando el mínimi número introducido
		int suma = 0; //La variable donde vamos a ir sumando los números positivos introducidos
		double media = 0; //La variable que nos va a servir para calcular la media de los números introducidos
		int i = 0; //La variable que vamos a usar para contar el número de números POSITIVOS introducidos
		Scanner scan = new Scanner(System.in);
		//Nótese que hay que mostrar el print al usuario por primera vez fuera del bucle
		System.out.println("Introduce un número entero positivo");
		System.out.println("Cuando quieras que el programa termine, introduce un número negativo");
		//Es super importante que el n = scan.nextInt() vaya entre paréntesis, para que la JVM interprete correctamente que es n = scan.nextInt() lo que debe ser mayor que 0 y no se cree ningún conflicto
		while ((n = scan.nextInt()) >= 0) {
			if (n > maximo) {
				maximo = n;
			}
			if (n < minimo ) {
				minimo = n;
			}
			suma += n; 
			i++;
			//Todos los sucesivos prints estarán en la última parte del bucle para que se muestren al final de cada iteración
			System.out.println("Introduce un número entero positivo");
			System.out.println("Cuando quieras que el programa termine, introduce un número negativo");
		}
		if (i > 0) {
			System.out.println("El máximo de los números introducidos es: " + maximo);
			System.out.println("El mínimo de los números introducidos es: " + minimo);
			System.out.println("La media de los números introducidos es: " + (double)suma / i);
		}
		else {
			System.out.println("No has introducido ningún número");
		}
	}

}
