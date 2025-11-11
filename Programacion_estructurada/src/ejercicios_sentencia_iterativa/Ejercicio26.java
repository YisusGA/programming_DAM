package ejercicios_sentencia_iterativa;

/**
 * Programa que muestre los 50 primeros números de la serie de Fibonacci 0, 1, 1, 2, 3, 5, 8, 13, 21,…
 * Los primeros términos son 0 y 1, los siguientes la suma de los dos anteriores.
 */

public class Ejercicio26 {

	public static void main(String[] args) {
		int n = 0; //El número que vamos a mostrar como secuencia de Fibonacci. Lo inicializamos en 0.
		int c = 1; //El número que vamos a ir sumando a n
		int nOriginalValue = 0;
		for (int i = 1; i <= 50; i++) {
			System.out.println(n);
			nOriginalValue = n;
			n += c;
			c = nOriginalValue;
		}
	}

}