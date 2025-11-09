package ejercicios_sentencia_iterativa;

/**
 * Realizar un programa que calcule y muestre la suma de los múltiplos de 5 comprendidos entre dos valores A y B. 
 * El programa no permitirá introducir valores negativos para A y B y verificará que A es menor que B. Si A es mayor
 * que B, intercambiará sus valores
 */

import java.util.Scanner;

public class Ejercicio08 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce el valor entero A de comienzo de intervalo");
		int A;
		int B;
		int counter = 0;
		do {
			A = scan.nextInt();
			if (A < 0) {
				System.out.println("Debes introducir un número mayor o igual que 0");
			}
		} while (A < 0);
		System.out.println("Introduce el valor entero B de final de intervalo");
		do {
			B = scan.nextInt();
			if (B < 0) {
				System.out.println("Debes introducir un número mayor o igual que 0");
			}
		} while (B < 0);
		if (A == B) {
			System.out.println("El intervalo no es válido, los dos extremos no pueden ser iguales. El número de múltiplos es 0");
			System.exit(0);
		}
		else if (A > B) {
			int aux = A;
			A = B;
			B = aux;
		}
		do {
			if (A % 5 == 0) {
				++counter;
			}
			A++;
		} while (A < B);
		System.out.println("El número de múltiplos de 5 dentro del intervalo A-B es: " + counter);
	}

}
