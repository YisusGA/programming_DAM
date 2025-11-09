package ejercicios_sentencia_iterativa;

/**
 * Programa que cuente todos los números múltiplos de 7 comprendidos entre 1 y 100
 */

public class Ejercicio04 {

	public static void main(String[] args) {
		int counter = 0;
		int number = 0;
		do {
			counter++;
			number +=7;
		} while (number <= 100);
		System.out.println("Hay " + counter + " múltiplos de 7 desde 1 hasta 100");

	}

}
