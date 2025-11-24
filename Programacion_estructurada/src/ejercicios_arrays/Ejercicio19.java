package ejercicios_arrays;

/**
 * Leer dos series de 10 enteros, que estarán ordenados crecientemente. Copiar (fusionar) las dos series en una tercera, de forma que sigan ordenadas
 */

import java.util.Scanner;

public class Ejercicio19 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		// Variables
		int arraySize = 10; //Tamaño de los arrays iniciales num1 y num2
		int[] num1 = new int[arraySize];
		int[] num2 = new int[arraySize];
		int[] num3 = new int[arraySize * 2]; //Array donde se van a fusionar en orden decreciente los arrays iniciales

		//Llenado por lectura de teclado de array num1. Restricciones para que los números se deban introducir en orden
		System.out.println("Array 1");
		System.out.println("Introduce un número entero. El orden debe ser creciente");
		num1[0] = scan.nextInt();
		for (int i = 1, n = 0; i < arraySize; i++) {
			System.out.println("Introduce otro número");
			while ((n = scan.nextInt()) < num1[i - 1]) {
				System.out.println("El número introducido no es válido, debe ser mayor que el anterior");
			}
			num1[i] = n;
		}
		//Llenado por lectura de teclado de array num2. Restricciones para que los números se deban introducir en orden
		System.out.println("Array 2");
		System.out.println("Introduce un número entero. El orden debe ser creciente");
		num2[0] = scan.nextInt();
		for (int i = 1, n = 0; i < arraySize; i++) {
			System.out.println("Introduce otro número");
			while ((n = scan.nextInt()) < num2[i - 1]) {
				System.out.println("El número introducido no es válido, debe ser mayor que el anterior");
			}
			num2[i] = n;
		}
		
		//Variables contadoras
		int i = 0; // Contador de num1
		int j = 0; // Contador de num2
		int k = 0; // Contador de num3
		
		//Iteramos comparando cada posición de un array con la posición del otro. El valor que sea menor, se incorpora al array num3. Y se incrementa sólo el contador del array
		//cuyo valor se haya incorporado. Tras la incorporación, siempre se incrementa el contador del array num3
		
		while (i < arraySize && j < arraySize) { //En cuanto uno de los arrays se agote, se sale del bucle while
			if (num1[i] < num2[j]) {
				num3[k] = num1[i];
				i++;
			} else {
				num3[k] = num2[j];
				j++;
			}
			k++;
		}
		
		//Recordar que los valores de los contadores i, j, k se conservan tras terminar el bucle while anterior
		//LLegados a este punto, una de los dos arrays se tiene que haber agotado, así que vamos a terminar de rellenar con el que aún tenga posiciones sin usar
		
		//Si quedan elementos de num1, los incorporamos a num3
		while (i < arraySize) {
			num3[k++] = num1[i++];
		}
		
		//Si quedan elementos de num2, los incorporamos a num3
		while (j < arraySize) {
			num3[k++] = num2[j++];
		}
		
		//Imprimimos todos los valores de num3
		System.out.print("Array fusion: ");
		for (int c : num3) {
			System.out.print(c + " ");
		}
		scan.close();

	}

}
