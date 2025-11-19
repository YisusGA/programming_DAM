package ejercicios_arrays;

/**
 * Dado un array de n enteros pasados por teclado, ordenarlo (el resultado será un nuevo array)
 */

import java.util.Scanner;

public class Ejercicio23 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		System.out.println("Introduce el tamaño deseado de array");
		int arraySize = scan.nextInt();

		int[] arrayOriginal = new int[arraySize];
		int[] arrayOrdenado = new int[arraySize];

		for (int i = 0; i < arraySize; i++) {
			System.out.println("Introduce un número entero");
			arrayOriginal[i] = scan.nextInt();
		}
		System.out.print("Array original: ");
		for (int i : arrayOriginal) {
			System.out.print(i + ", ");
		}
//		for (int i = 0; i < arraySize; i++) {
//			for (int k = 0; k < arraySize; k++) {
//				if (arrayOriginal[k] < min) {
//					min = arrayOriginal[k];
//					arrayOrdenado[i] = min;
//				}
//			}
//		}
		for (int i = 0; i <arraySize; i++) {
			//Encontramos el mínimo del arrayOriginal
			int min = arrayOriginal[0];
			for (int j = 1; j < arrayOriginal.length; j++) {
				if (arrayOriginal[j] < min) {
					min = arrayOriginal[j];
				}
			}	
			
			//Llenamos la posición que toque del arrayOrdenado con el mínimo encontrado
			arrayOrdenado[i] = min;
			
			 
			for (int k = 0; k < arrayOriginal.length; k++) {
				//Iteramos en el arrayOriginal hasta encontrar la posición que coincide con el min encontrado, y le asignamos el valor más alto posible, un Integer.MAX_VALUE, para que jamás vuelva a encontrarse como mínimo
				if (arrayOriginal[k] == min) {
					arrayOriginal[k] = Integer.MAX_VALUE;
					break; //Metiendo este break de aquí, lo que logramos es que en cuanto encuentre una coincidencia, se salga del bucle for en el que está este bloque de código. Si no hacemos esto, si hay varios números
						   //iguales en el arrayOriginal, al encontrarse con los sucesivos, los va a rellenar con un Integer.MAX_VALUE y los perderemos
				}
			}
		}	
		System.out.println();
		System.out.print("Nuevo array ordenado: ");
		for (int i : arrayOrdenado) {
			System.out.print(i + ", ");
		}
		scan.close();

	}

}
