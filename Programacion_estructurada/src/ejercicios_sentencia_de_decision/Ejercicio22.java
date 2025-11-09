package ejercicios_sentencia_de_decision;

/**
 * Pedir un número entre 0 y 99999 y decir cuantas cifras tiene
 */

import java.util.Scanner;

public class Ejercicio22 {

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
		System.out.println("El número introducido tiene " + length + " cifras");
		}
	}

}
