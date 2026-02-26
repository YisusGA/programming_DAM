package examen02_25112025;

import java.util.Scanner;

public class Ejercicio03_profe {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce el tamaño del array");
		int arraySize= scan.nextInt();
		int[] numeros = new int[arraySize];
		for (int i = 0; i < numeros.length; i++) {
			System.out.println("Introduce un número entero");
			numeros[i] = scan.nextInt();
		}
		boolean encontrado = false;
		for (int i = 0; i < numeros.length && !encontrado; i++) {
			int contador = 0;
			for (int j = 0; j < numeros.length; j++) {
				if (numeros[i] == numeros[j]) {
					contador++;
				}
			}
			if (contador > (arraySize / 2)) {
				System.out.println("El número mayoritario existe, es: " + numeros[i]);
				encontrado = true;
			}
		}
		if (!encontrado) {
			System.out.println("No existe un elemento mayoritario");
		}
		scan.close();
	}

}

