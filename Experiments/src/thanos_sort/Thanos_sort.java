package thanos_sort;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Thanos_sort {
	private static Random generador = new Random();

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int arraySize = 5;
		boolean valid = false;
		while (!valid) {
			try {
				System.out.println("Introduce tamaño del array");
				arraySize = scan.nextInt();
				valid = true;
			} catch (InputMismatchException e) {
				e.printStackTrace();
				System.err.println("Número no válido, prueba de nuevo");
			}
		}
		double[] array = new double[arraySize];
		array = rellenarArray(array);
		System.out.print("Array inicial: ");
		showArray(array);
		System.out.println();
		while(!isSorted(array)) {
			array = thanosClean(array);
			System.out.print("Array intermedio: ");
			showArray(array);
			System.out.println();
		}
		System.out.print("Array superviviente: ");
		showArray(array);
		scan.close();
	}

	private static void showArray(double[] array) {
		for (double i : array) {
			System.out.printf("%.2f, ", i);
		}
	}

	public static double[] rellenarArray(double[] array) {
		for (int i = 0; i < array.length; i++) {
			array[i] = generador.nextDouble();
		}
		return array;
	}

	public static boolean isSorted(double[] array) {
		boolean sorted = true;
		for (int i = 0; i < array.length - 1; i++) {
			if (array[i] > array[i + 1]) {
				sorted = false;
			}
		}
		return sorted;
	}

	public static double[] thanosClean(double[] array) {
		double[] aux = new double[array.length / 2];
		for (int i = 0; i < aux.length; i++) {
			aux[i] = array[generador.nextInt(0, array.length)];
		}
		return aux;
	}

}