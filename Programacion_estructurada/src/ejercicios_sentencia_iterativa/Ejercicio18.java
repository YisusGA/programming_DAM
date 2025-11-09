package ejercicios_sentencia_iterativa;

/**
 * Pedir 5 números e indicar si alguno es múltiplo de 3
 */

import java.util.Scanner;

public class Ejercicio18 {

	public static void main(String[] args) {
		boolean multiplo3 = false;
		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < 5; i++) {
			System.out.println("Introduce un número entero");
			int n = scan.nextInt();
			if (n % 3 == 0) {
				multiplo3 = true;
				break;
			}
		}
		if (multiplo3) {
			System.out.println("Has introducido un múltiplo de 3");
		} else {
			System.out.println("No has introducido ningún múltiplo de 3");
		}
		scan.close();
	}

}
