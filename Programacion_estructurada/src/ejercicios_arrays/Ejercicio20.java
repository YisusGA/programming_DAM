package ejercicios_arrays;

import java.util.Scanner;

//Leer 10 enteros ordenados crecientemente. Leer N y mostrar la posición en que  se encuentra. Si no está, indicarlo con un mensaje

public class Ejercicio20 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int arraySize = 10;
		int[] array = new int[arraySize];
		int max = Integer.MIN_VALUE;
		int i = 0;
		while (i < array.length) {
			System.out.println("Introduce un número entero");
			int n = scan.nextInt();
			if (n > max) {
				array[i++] = n;
				max = n;
			} else {
				System.err.println("El número introducido debe ser mayor que el anterior");
			}
		}
		System.out.println("Array completado");
		System.out.println("Introduce un número para buscar si está en el array");
		int n = scan.nextInt();
		boolean encontrado = false;
		for (int j = 0; !encontrado && j < array.length; j++) {
			if (array[j] == n) {
				System.out.println("El número se ha encontrado, está en la posición: " + j);
				encontrado = true;
			}
		}
		if (!encontrado) {
			System.out.println("El número introducido no se encuentra en el array");
		}
		scan.close();

	}

}
