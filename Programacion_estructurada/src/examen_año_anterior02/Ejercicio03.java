package examen_año_anterior02;

import java.util.Scanner;

public class Ejercicio03 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int arraySize;
		System.out.println("Introduce un número entero positivo mayor que 0");
		while ((arraySize = scan.nextInt()) <= 0) {
			System.out.println("Número no válido, debe ser mayor que 0");
		}
		String trash = scan.nextLine();
		String[] palabras = new String[arraySize];
		for (int i = 0; i < palabras.length; i++) {
			System.out.println("Introduce una palabra");
			palabras[i] = scan.nextLine();
		}
		System.out.print("Array original: ");
		for (String i : palabras) {
			System.out.print(i+ ", ");
		}
		String aux = "";
		for (int i = 0, j = palabras.length - 1; i < j; i++, j--) {
			aux = palabras[i];
			palabras[i] = palabras[j];
			palabras[j] = aux;
		}
		
		System.out.println();
		System.out.print("Array invertido: ");
		for (String i : palabras) {
			System.out.print(i+ ", ");
		}
		scan.close();
	}

}
