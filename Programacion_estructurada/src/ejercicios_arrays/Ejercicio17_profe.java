package ejercicios_arrays;

/**
 * Leer 5 elementos numéricos que se introducirán ordenados de forma creciente. Si esto fuera el examen, asumimos que el usuario los va a introducir
 * en orden, no haría falta hacer toda la parte de comprobación que yo he hecho. Éstos los guardaremos en un array de tamaño 10. 
 * Leer un número N, e insertarlo en el lugar adecuado para que el array continúe ordenado
 */

import java.util.Scanner;

public class Ejercicio17_profe {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int arraySize = 10;
		int elementosUtiles = 5;
		int[] numeros = new int[arraySize];
		System.out.println("Introduzca un numero");
		numeros[0] = scan.nextInt();
		for (int i = 1; i < elementosUtiles; i++) {
			System.out.println("Introduce otro numero");
			int n;
			while ((n = scan.nextInt()) < numeros[i - 1]) {
				System.out.println("Ese numero no es válido");
			}
			numeros[i] = n;
		}
		System.out.println("Introduce un número n");
		int n = scan.nextInt();
		int posicionInsercion = elementosUtiles; //Preasumimos que n va a ser el mayor y va a estar en la posición 5 del array
		for (int j = 0; j < elementosUtiles; j++) {
			if (n <= numeros[j]) {
				posicionInsercion = j;
				break;
			}
		}
		for (int j = elementosUtiles - 1; j >= posicionInsercion; j--) {
            numeros[j + 1] = numeros[j];
        }
		numeros[posicionInsercion] = n;
		for (int k : numeros) {
			System.out.print(k + " ");
		}
		scan.close();

	}

}

