package ejercicios_sentencia_iterativa;

/**
 * Programa que muestre la secuencia de Fibonacci: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89...
 */

public class Fibonacci_for {

	public static void main(String[] args) {
		int n = 0; //El número que vamos a mostrar como secuencia de Fibonacci. Lo inicializamos en 0.
		int nOriginalValue = 0;
		//c es el número que vamos a ir sumando a n
		for (int c = 1; n <= 100; c = nOriginalValue) {
			System.out.println(n);
			nOriginalValue = n;
			n += c;
		}
	}

}
