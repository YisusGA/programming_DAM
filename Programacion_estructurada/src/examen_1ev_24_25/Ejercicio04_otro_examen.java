package examen_1ev_24_25;

import java.util.Scanner;

public class Ejercicio04_otro_examen {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int arraySize = 6;
		int[] numeros = new int[arraySize];
		for (int i = 0; i < numeros.length; i++) {
			System.out.println("Introduce un número entero");
			numeros[i] = scan.nextInt();
		}
		System.out.println("Introduce un número como objetivo");
		int n = scan.nextInt();
		boolean sumaTrue = false;
		for (int i = 0; i < numeros.length; i++) {
			for (int j = 0; j < numeros.length; j++) {
				if (i != j && (numeros[i] + numeros[j]) == n) {
					sumaTrue = true;
					break;
				}
			}
		}
		System.out.println("¿Existen dos números en el array cuya suma sea igual al número objetivo? " + sumaTrue);
		scan.close();
	}

}
