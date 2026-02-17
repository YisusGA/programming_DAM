package examen_año_anterior03;

import java.util.Scanner;

public class Ejercicio02 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num = 1;
		int arraySize = 5;
		int[] numeros = new int[arraySize];
		boolean igual = false;
		int c = 0;
		do {
			igual = false;
			System.out.println("Introduce un número");
			num = scan.nextInt();
			for (int j = 0; j < numeros.length; j++) {
				if (numeros[j] == num) {
					igual = true;
				}
			}
			if (!igual && num > 0) {
				numeros[c] = num;
				c++;
			}
		} while (c < 5);
		System.out.print("Array introducido: ");
		for (int i : numeros) {
			System.out.print(i + ", ");
		}
		igual = false;
		System.out.println();
		while (!igual) {
			System.out.println("Introduce el número a comprobar");
			int numComp = scan.nextInt();
			for (int i = 0; i < numeros.length; i++) {
				if (numeros[i] == numComp) {
					igual = true;
				}
			}
		}
		
		System.out.println("El programa ha finalizado");
	}

}
