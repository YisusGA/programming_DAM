package ejercicios_arrays;

/**
 * Dado un array de n enteros pasados por teclado, ordenarlo (el resultado será un nuevo array)
 */

import java.util.Scanner;

public class Ejercicio23_profe_correccion_profe {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.err.println("Esta versión que hizo la profe tiene el problema de que si arrayOriginal tiene 2 números iguales, mete un 0. Ver Ejercicio23_profe_Gemini para ver la solución");
		
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
			for (int j = 1; j < arrayOriginal.length; j++) {
				if (arrayOriginal[j] < min) {
					min = arrayOriginal[j];
				}
			}
			
			//Llenamos la posición que toque del arrayOrdenado con el mínimo encontrado
			arrayOrdenado[i] = min;
			
			//Eliminar min del arrayOriginal. Hacemos lo que vimos en el Ejercicio18_profe para reducir el tamaño de un array eliminando una posición concreta,
			//que en este caso es el mínimo que ya hemos sacado. Importante usar arrayOriginal.length y no arraySize, pues el tamaño del arrayOriginal se va a ir decrementando en cada iteración
			int[] aux = new int[arrayOriginal.length -1];
			//Esta sería una forma de corregir el error
			boolean minimoEncontrado = false;
			for (int j = 0, t = 0; j < arrayOriginal.length; j++) {
				if (arrayOriginal[j] != min || minimoEncontrado) {
					aux[t++] = arrayOriginal [j];
				}
				if (arrayOriginal [j] == min) {
					minimoEncontrado = true;
				}
			}
			//Asignamos al arrayOriginal la dirección de memoria del array aux, con lo cual, ahora arrayOriginal apunta a un array que tiene un tamaño decrementado en 1 y que tiene todos los valores
			//que tenía originalmente arrayOriginal exceptuando el min que encontramos
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
