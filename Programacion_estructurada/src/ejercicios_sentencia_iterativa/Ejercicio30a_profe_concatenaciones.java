package ejercicios_sentencia_iterativa;

/**
 * Realizar un programa que muestre por pantalla la siguiente figura (ver word) (siendo el número de filas un valor que se solicita por teclado
 */


import java.util.Scanner;

public class Ejercicio30a_profe_concatenaciones {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce un número de líneas");
		int numLineas = scan.nextInt();
		for (int i = 0; i < numLineas; i++) {
			String linea = "";
			for (int j = 0; j < numLineas - 1 - i; j++) {
				linea += " ";
			}
			for (int j = 0; j < 2 * i + 1; j++) {
				linea += "*";			
			}
			System.out.println(linea);
		}
	}

}
