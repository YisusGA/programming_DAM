package ejercicios_arrays;

/**
 * Como el 15, pero desplazar N posiciones (N es introducido por el usuario)
 */

import java.util.Scanner;

public class Ejercicio16 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int arraySize = 10;
		int[] numeros = new int[arraySize];
		for (int i = 0; i < arraySize; i++) {
			System.out.println("Introduce un número entero");
			numeros[i] = scan.nextInt();
		}
		int[] numerosNuevos = new int[arraySize];
		System.out.println("Introduce un número de desplazamientos N");
		//Reducimos la N con % 10 para que entre al bucle más reducida y sea más eficiente computacionalmente 
		int N = Math.abs(scan.nextInt()) % arraySize;
		System.out.print("Array original: ");
		for (int i = 0; i < arraySize; i++) {
			System.out.print(numeros[i] + " ");
		}
		for (int i = 0; i < arraySize; i++) {	
			//Colocamos en la posición avanzada del nuevo array, cada posición desde 0 a 9 del array original
			numerosNuevos[(i + N) % arraySize] = numeros[i];
		}	
		System.out.println();
		System.out.print("Array cambiado: ");
		for (int i : numerosNuevos) {
			System.out.print(i + " ");
		}
	}

}
