package bucles_sentencia_iterativa;

/**
 * Programa que muestre todos los múltiplos de 5 desde 0 hasta 100
 */

public class Multiplos5_sin_If {

	public static void main(String[] args) {
		int n = 0;
		do {
			n += 5;
			System.out.println(n);
		} while (n < 100);
	}

}
