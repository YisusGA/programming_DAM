package ejercicios_sentencia_iterativa;

/**
 * Programa que muestre la secuencia de Fibonacci: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89...
 */

public class Fibonacci {

	public static void main(String[] args) {
		int n = 0; //El número que vamos a mostrar como secuencia de Fibonacci. Lo inicializamos en 0.
		int c = 1; //El número que vamos a ir sumando a n y que va a ir tomando siempre el valor de n previo a sumarle c
		while (n <= 100) {
			System.out.println(n);
			n += c;
			c = n - c;
		}
	}

}