package ejercicios_arrays;

import java.util.Scanner;

//Leer un array de N char e indicar si están ordenados alfabéticamente

public class Ejercicio21 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce el tamaño del array. Debe ser igual o mayor que 2");
		int arraySize;
		while ((arraySize = scan.nextInt()) < 2) {
			System.err.println("Tamaño de array no admitido, debe ser igual o mayor que 2");
		}
		scan.nextLine();
		char[] array = new char[arraySize];
		for (int i = 0; i < array.length; i++) {
			System.out.println("Introduce una letra o palabra");
			array[i] = scan.nextLine().charAt(0);
		}
		int max = array[0];
		boolean ordenado = true;
		for (int i = 0; ordenado && i < array.length - 1; i++) {
			if (array[i + 1] < array[i]) {
				System.out.println("El array no está ordenado alfabéticamente");
				ordenado = false;
			}
		}
		if (ordenado) {
			System.out.println("El array está ordenado alfabéticamente");
		}
		scan.close();

	}

}
