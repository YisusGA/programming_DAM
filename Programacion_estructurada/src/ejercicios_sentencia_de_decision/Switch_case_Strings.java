package ejercicios_sentencia_de_decision;

/**
 * Ejemplo para trabajar con switch-case usando Strings
 */

import java.util.Scanner;

public class Switch_case_Strings {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce 'a', 'b' y 'c' en el orden que quieras (sin las comillas simples)");
		String s = scan.nextLine();
		scan.close();
		switch (s) {
		case "abc":
			System.out.println("Orden natural del alfabeto abc: " + s);
			break;
		case "acb":
			System.out.println("El orden es acb: " + s);
			break;
		case "bac":
			System.out.println("El orden es bac: " + s);
			break;
		case "bca":
			System.out.println("El orden es bca: " + s);
			break;
		case "cab":
			System.out.println("El orden es cab" + s);
			break;
		case "cba":
			System.out.println("El orden es cba: " + s);
			break;
		}
	}

}
