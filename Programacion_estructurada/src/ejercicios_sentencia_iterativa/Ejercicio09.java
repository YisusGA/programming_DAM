package ejercicios_sentencia_iterativa;

/**
 * Programa que lea dos números: a y b de tipo int. El programa debe calcular a^b
 */

import java.util. Scanner;

public class Ejercicio09 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int a; // Base de la potencia 
		int b; //Exponente de la potencia. Lo vamos a ir decrementando para que entre en el bucle por última vez cuando su valor sea 1 (si vale 0, ya no entra)
		System.out.println("Introduce un número entero");
		a = scan.nextInt();
		System.out.println("Introduce otro número entero");
		b = scan.nextInt();
		double r = 1L; // Valor donde vamos a ir almacenando el resultado acumulado de las potencias. Su valor inicial debe ser 1, pues a^1 es a
		if (b > 0) {
			while (b > 0) {
				r *= a;
				b--;
			}
			if (Math.abs(r) >= Long.MAX_VALUE) {
				System.err.println("El resultado de la operación es demasiado grande para ser almacenado en 64 bit");
			} else {
			System.out.println("El resultado de a^b es: " + (long)r);
			}
		}	
		if (b < 0) {
			while (b < 0) {
				r /= a;
				b++;	
			}
			if (Math.abs(r) <= Double.MIN_VALUE) {
				System.err.println("El resultado de la operación es demasiado grande para ser almacenado en 64 bit");
			} else {
			System.out.println("El resultado de a^b es: " + r);
		    }
		}	
	}

}
