package ejercicios_sentencia_iterativa;

/**
 * 16.	Pedir 10 números, y mostrar al final si se ha introducido alguno negativo
 */

import java.util.Scanner;

public class Ejercicio16_contador {

	public static void main(String[] args) {
		int negCount = 0;
		boolean algunoNegativo = false;
		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < 10; i++) {
			System.out.println("Introduce un número entero");
			int n = scan.nextInt();
			if (n < 0) {
				algunoNegativo = true;
				negCount++;
			}
		}
		if (algunoNegativo) {
			System.out.println("Se han introducido " + negCount + " número(s) negativo(s)");
		} else {
			System.out.println("No  se ha introducido ningún número negativo");
		}
		scan.close();
	}

}
