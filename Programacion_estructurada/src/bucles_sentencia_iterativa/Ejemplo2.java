package bucles_sentencia_iterativa;

/**
 * Hay situaciones en las que necesitamos que la primera ejecución del bucle se haga sí o sí, de forma
 * incondicional. Para no tener que hacer la trampa de inicializar la variable antes, podemos hacer lo que se ve 
 * aquí debajo, un do-while. Primero ejecuta el bloque de código, y luego entra en el bucle si se cumpla la 
 * condición de entrada en e bucle.
 */

import java.util.Scanner;

public class Ejemplo2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n;
		do {
			System.out.println("Introduzca un número positivo");
			n = scan.nextInt();
		} while(n < 0);
		System.out.println("EL número introducido es n: " + n);
	}

}
