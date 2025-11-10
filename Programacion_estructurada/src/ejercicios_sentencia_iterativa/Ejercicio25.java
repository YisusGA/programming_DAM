package ejercicios_sentencia_iterativa;

/**
 * Programa que lea un número natural y diga si es o no es triangular
 */

import java.util.Scanner;

public class Ejercicio25 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce un número entero positivo mayor que 0");
		int n = scan.nextInt(); //Número sobre el que vamos a comprobar su triangularidad
		boolean esTriangular = false; //Inicializamos el booleano en false, pues vamos a intentar demostrar si es true
		while (n <= 0) { //Obligamos a que el número introducido sea natural (entero positivo)
			System.err.println("Número no válido");
			System.out.println("Introduce otro número");
			n = scan.nextInt();
		}
		//Calculamos todos los números triangulares desde el 1 hasta el número n, y los vamos comparando con n. Si n == Ti, entonces n es triangular
		for (int i = 1; i <= n; i++) {
			int Ti = i * (i + 1) / 2;
			if (n == Ti) {
				esTriangular = true;
				break;
			}
		}
		if (esTriangular) {
			System.out.println("El número introducido es triangular");
		} else {
			System.out.println("El número introducido no es triangular");
		}
		scan.close();

	}

}
