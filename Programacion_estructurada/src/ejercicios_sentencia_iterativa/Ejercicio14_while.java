package ejercicios_sentencia_iterativa;

/**
 * Programa que lea de forma repetida un número N. Para cada número leído calculará y mostrará la suma 1+2+3+...+N.
 * Cada vez que muestre el resultado el programa preguntará al usuario si desea continuar;
 * si se introduce sí el programa continuará. En caso contrario finalizará.
 */

import java.util.Scanner;

public class Ejercicio14_while {

	public static void main(String[] args) {
		String continuar = "Sí";
		int counter = 0; //Este contador no lo pide, pero me pareció buena idea meterlo para contar cuántas iteraciones del bucle se han hecho antes de finalizar
		Scanner scan = new Scanner(System.in);
		do {
			int n = 0, i = 1, result = 0; //n será el número introducido por el usuario; i, los números iguales o menores que n que se sumarán para mostrar la suma 1+2+3+...+N, y result, donde se almacenará el resultado de la suma
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
			counter++;
		} while (continuar.equals("Sí") || continuar.equals("Si") || continuar.equals("sí") || continuar.equals("si"));
		System.out.println("El programa ha finalizado correctamente. El número de iteraciones ha sido de: " + counter);
		scan.close();
	}

}
