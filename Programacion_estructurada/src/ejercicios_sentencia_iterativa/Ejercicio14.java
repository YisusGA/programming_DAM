package ejercicios_sentencia_iterativa;

/**
 * Programa que lea de forma repetida un número N. Para cada número leído calculará y mostrará la suma 1+2+3+...+N.
 * Cada vez que muestre el resultado el programa preguntará al usuario si desea continuar;
 * si se introduce sí el programa continuará. En caso contrario finalizará.
 */

import java.util.Scanner;

public class Ejercicio14 {

	public static void main(String[] args) {
		String continuar = "Sí";
		int counter = 0;
		Scanner scan = new Scanner(System.in);
		//Un bucle for así queda MUY FEO. Mejor hacer este ejercicio con un bucle do-while, ver Ejercicio14_while
		for (int n = 0, i = 1, result = 0; continuar.equals("Sí") || continuar.equals("Si") || continuar.equals("sí") || continuar.equals("si"); counter++) {
			System.out.println("Introduce un número");
			n = scan.nextInt();
			while (i <= n) {
				result += i;
				i++;
			}
			System.out.println("El resultado de la suma 1+2+3+... + n es: " + result);
			String trash = scan.nextLine();
			System.out.println("¿Quieres continuar el programa? Sí o No");
			continuar = scan.nextLine();
		}
		System.out.println("El programa ha finalizado correctamente. El número de iteraciones ha sido de: " + counter);
		scan.close();
	}
	
}
