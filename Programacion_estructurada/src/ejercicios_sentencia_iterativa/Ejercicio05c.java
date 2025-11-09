package ejercicios_sentencia_iterativa;

/**
 * Programa que solicite una palabra en bucle hasta que se introduzca "fin". Contar cuántas de las palabras introducidas comienzan con mayúscula.
 */

import java.util.Scanner;

public class Ejercicio05c {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int counter = 0;
		String name;
		do {
			System.out.println("Introduce un nombre con la primera letra mayúscula o minúscula");
			System.out.println("Introduce fin cuando quieras que termine el programa");
			name = scan.nextLine();
			char c = name.charAt(0);
			if ((c >= 65 && c <= 90)) {
				counter++;
			}
		} while (!name.equals("fin"));
		scan.close();
		System.out.println(counter + " palabras comienzan por mayúscula");
	}

}