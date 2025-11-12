package ejercicios_sentencia_iterativa;

/**
 * Realizar un programa que muestre por pantalla la siguiente figura (ver word) (siendo el número de filas un valor que se solicita por teclado)
 */


import java.util.Scanner;

public class Ejercicio30b_NO_FUNCIONA {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce un número de líneas");
		int numLineas = scan.nextInt();
		for (int i = 0; i < numLineas; i++) { //i es el contador de línea
			for (int j = 0; j < numLineas - 1 - i; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < 2 * i + 1; j++) { //Podemos volver a declarar e inicializar la j porque ya salimos del primer bucle
				System.out.print("*");
			}
			//salto de linea para la siguiente fila
			System.out.println();
		}
		for (int i = 0; i < numLineas - 1; i++) { //i es el contador de línea
			for (int j = numLineas; j > numLineas - i - 1; j--) {
				System.out.print(" ");
			}
			for (int j = numLineas; j  > 2 * i + 1; j--) { //Podemos volver a declarar e inicializar la j porque ya salimos del primer bucle
				System.out.print("*");
			}
			//salto de linea para la siguiente fila
			System.out.println();
		}
	}

}
