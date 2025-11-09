package ejercicios_sentencia_de_decision;

/**
 * Pedir un número entre 0 y 99999 y mostrarlo con las cifras al revés
 */

import java.util.Scanner;

public class Ejercicio23 {

	public static void main(String[] args) {
		System.out.println("Introduce un número entero comprendido entre 0 y 99999");
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt();
		scan.close();
		if (num < 0 || num > 99999) {
			System.err.print("ERROR: el número introducido debe estar comprendido entre 0 y 99999");
			return;
		} else {
			String numString = "" + num;
			int length = numString.length();
			if (length == 1) {
				System.out.println("El número introducido sólo tiene una cifra");
			} else if (length == 2) {
				System.out.println("El número que has introducido leído desde el final es: " + numString.charAt(1) + numString.charAt(0));
			} else if (length == 3) {
				System.out.println("El número que has introducido leído desde el final es: " + numString.charAt(2) + numString.charAt(1) + numString.charAt(0));
			} else if (length == 4) {
				System.out.println("El número que has introducido leído desde el final es: " + numString.charAt(3) + numString.charAt(2) + numString.charAt(1) + numString.charAt(0));
			} else {
				System.out.println("El número que has introducido leído desde el final es: " + numString.charAt(4) + numString.charAt(3) + numString.charAt(2) + numString.charAt(1) + numString.charAt(0));
			}
		}

	}

}
