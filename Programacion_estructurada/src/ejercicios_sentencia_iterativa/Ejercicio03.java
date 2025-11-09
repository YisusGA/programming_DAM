package ejercicios_sentencia_iterativa;

/**
 * Realizar un programa que muestre por pantalla los números del 1 al 100 sin mostrar los múltiplos de 5
 */

public class Ejercicio03 {

	public static void main(String[] args) {
		int n = 0;
		do {
			n++;
			if (n % 5 != 0) {
				System.out.println("n: " + n);
			}	
		} while (n < 100);
	}

}
