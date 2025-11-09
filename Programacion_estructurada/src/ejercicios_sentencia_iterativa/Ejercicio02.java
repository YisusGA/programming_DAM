package ejercicios_sentencia_iterativa;

/**
 * Programa que muestre por pantalla todos los números naturales del 1 hasta el 5, ambos incluidos; 
 * lo mismo pero de 1 a 50; lo mismo pero de 1 a 500.  
 */

public class Ejercicio02 {

	public static void main(String[] args) {
		int n1 = 0;
		do {
			n1++;
			System.out.println("n1: " + n1);
		} while (n1 < 5);
		int n2 = 0;
		do {
			n2++;
			System.out.println("n2: " + n2);
		} while (n2 < 50);
		int n3 = 0;
		do {
			n3++;
			System.out.println("n3: " + n3);
		} while (n3 < 500);

	}

}
