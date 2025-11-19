package ejercicios_arrays;

/**
 * Dado un array de n enteros pasados por teclado, ordenarlo (el resultado será un nuevo array)
 */

import java.util.Scanner;

public class Ejercicio23_profe_Gemini {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		//Leemos el tamaño del array
		System.out.println("Introduce el tamaño deseado de array");
		int arraySize = scan.nextInt();

		//Inicializamos los arrays
		int[] arrayOriginal = new int[arraySize];
		int[] arrayOrdenado = new int[arraySize];

		//Llenamos el arrayOriginal
		for (int i = 0; i < arraySize; i++) {
			System.out.println("Introduce un número entero");
			arrayOriginal[i] = scan.nextInt();
		}
		
		//Imprimimos el arrayOriginal para ver cómo es
		System.out.print("Array original: ");
		for (int i : arrayOriginal) {
			System.out.print(i + ", ");
		}
		for (int i = 0; i <arraySize; i++) {
			//Encontramos el mínimo del arrayOriginal
			int min = arrayOriginal[0];
			int minIndex = 0;
			for (int j = 1; j < arrayOriginal.length; j++) {
				if (arrayOriginal[j] < min) {
					min = arrayOriginal[j];
					minIndex = j; //Fijarse en que nos quedamos con la posición donde se ha encontrado un mínimo
				}
			}
			
			//Llenamos la posición que toque del arrayOrdenado con el mínimo encontrado
			arrayOrdenado[i] = min;
			
			//Eliminar min del arrayOriginal. Lo que hacemos llenar el array auxiliar hasta el valor de antes del mínimo encontrado, y luego continuamos metiendo los valores desde justo después de esa posición
			int[] aux = new int[arrayOriginal.length -1];
			for (int j = 0; j < minIndex; j++) {
				aux[j] = arrayOriginal [j];
			}
			for (int j = minIndex; j < arrayOriginal.length - 1; j++) {
				aux[j] = arrayOriginal[j + 1];
			}
			arrayOriginal = aux;
			
			
		}
		
		//Imprimimos el nuevo arrayOrdenado, ya ordenado
		System.out.println();
		System.out.print("Nuevo array ordenado: ");
		for (int i : arrayOrdenado) {
			System.out.print(i + ", ");
		}
		scan.close();
	}

}