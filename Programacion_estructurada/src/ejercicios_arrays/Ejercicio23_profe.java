package ejercicios_arrays;

import java.util.Scanner;

public class Ejercicio23_profe {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("Introduce el tamaño deseado de array");
		int arraySize = scan.nextInt();

		int[] array1 = new int[arraySize];
		int[] array2 = new int[arraySize];

		for (int i = 0; i < arraySize; i++) {
			System.out.println("Introduce un número entero");
			array1[i] = scan.nextInt();
		}
		System.out.print("Array original: ");
		for (int i : array1) {
			System.out.print(i + ", ");
		}
		for (int i = 0; i <arraySize; i++) {
			//encontrar mínimo
			int min = array1[0];
			for (int j = 1; j < array1.length; j++) {
				System.out.println("j: " + j);
				if (array1[j] < min) {
					min = array1[j];
				}
			}
			//Eliminar min del array1. Hacemos lo que vimos en el Ejercicio18_profe para reducir el tamaño de un array eliminando una posición concreta,
			//que en este caso es el mínimo que ya hemos sacado
			int[] aux = new int[array1.length -1];
			for (int j = 0, t = 0; j < array1.length; j++) {
				if (array1[j] != min) {
					aux[t++] = array1 [j];
				}
			}
			array1 = aux;
			
			array2[i] = min;
		}
		System.out.println();
		System.out.print("Nuevo array ordenado: ");
		for (int i : array2) {
			System.out.print(i + ", ");
		}
		scan.close();
	}

}
