package ejercicios_sentencia_iterativa;

/**
 * Programa que, dado un número entero, muestre en líneas consecutivas cada una de sus cifras
 */

import java.util.Scanner;

public class Ejercicio20 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce un número entero");
		int n = scan.nextInt();
		String nS = "" + n;
		int nSLength = nS.length() - 1;
		for (int i = 0; i <= nSLength; i++) {
			System.out.println(nS.charAt(i));
		}
		scan.close();
	}

}
