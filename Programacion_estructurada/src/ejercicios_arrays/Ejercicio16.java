package ejercicios_arrays;

/**
 * Como el 15, pero desplazar N posiciones (N es introducido por el usuario)
 */

import java.util.Scanner;

public class Ejercicio16 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int j = 0;
		int[] numeros = new int[10];
		for (int i = 0; i < 10; i++) {
			System.out.println("Introduce un número entero");
			numeros[i] = scan.nextInt();
		}
		int[] numerosNuevos = new int[10];
		System.out.println("Introduce un número de desplazamientos N");
		int N = Math.abs(scan.nextInt());
		System.out.print("Array original: ");
		for (int i = 0; i < 10; i++) {
			System.out.print(numeros[i] + " ");
		}
		int num1Original = numeros[0];
		for (int i = 0; i < 10; i++) {
			int nuevaPosicion = ((i + N) % 9);
			if (nuevaPosicion > 9) {
				numerosNuevos[i] = numeros[nuevaPosicion - 9];
			} else if (nuevaPosicion == 0) {	
				numerosNuevos[i] = numeros[9];
			} else {
				numerosNuevos[i] = numeros[nuevaPosicion];
			}
		}
		System.out.println();
		System.out.print("Array cambiado: ");
		for (int i : numerosNuevos) {
			System.out.print(i + " ");
		}
	}

}
