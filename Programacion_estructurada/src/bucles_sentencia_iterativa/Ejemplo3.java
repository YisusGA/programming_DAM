package bucles_sentencia_iterativa;

/**
 * Con esta variante del Ejemplo2, podemos inicializar la variable mediante la entrada del usuario mostrando el mensaje que nosotros queramos.
 * Si tras la introducción del dato por parte del usuario, se cumple la condición de entrada en el bucle, entonces podemos mostrar un mensaje 
 * distinto al inicial una vez que se ha entrado en el bucle.
 */

import java.util.Scanner;

public class Ejemplo3 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n;
		System.out.println("Introduce un número positivo");
		n = scan.nextInt();
		while (n < 0) {
			System.out.println("Que pongas un positivo, leñe");
			n = scan.nextInt();
		}
		System.out.println("EL número introducido es n: " + n);
	}

}

