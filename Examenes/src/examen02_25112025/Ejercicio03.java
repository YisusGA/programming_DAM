package examen02_25112025;

import java.util.Scanner;

public class Ejercicio03 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce el tamaño del array");
		int arraySize= scan.nextInt();
		int[] numeros = new int[arraySize];
		for (int i = 0; i < numeros.length; i++) {
			System.out.println("Introduce un número entero");
			numeros[i] = scan.nextInt();
		}
		int max = 0;
		int mayoritario = numeros[0];
		for (int i = 0; i < numeros.length; i++) {
			int contador = 0;
			for (int j = 0; j < numeros.length; j++) {
				if (numeros[i] == numeros[j]) {
					contador++;
				}
				if (contador > max) {
					max = contador;
					mayoritario = numeros[i];
				}
			}
		}
		if (max > (arraySize / 2)) {
			System.out.println("Hay un elemento mayoritario, es: " + mayoritario);
		} else {
			System.out.println("No existe un elemento mayoritario");
		}
		scan.close();
	}

}
