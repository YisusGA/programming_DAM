package others;

//Dado un array de n enteros pasados por teclado, ordenarlo (sin usar otro array. Se ordenará el mismo array creado anteriormente).

import java.util.Scanner;

public class OrdenarArrayEnteros {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce el tamaño deseado para el array");
		int arraySize = scan.nextInt();
		int[] array = new int[arraySize];
		for (int i = 0; i < array.length; i++) {
			System.out.println("Introduce un número entero");
			array[i] = scan.nextInt();
		}
		System.out.print("El array introducido es: ");
		for (int i : array) {
			System.out.print(i + ", ");
		}
		int min = array[0];
		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array [j] < array[i]) {
					min = array[j];
					array[j] = array[i];
					array[i] = min;
				}
				
			}
		}
		System.out.print("El array ordenado es: ");
		for (int i : array) {
			System.out.print(i + ", ");
		}
		scan.close();

	}

}
