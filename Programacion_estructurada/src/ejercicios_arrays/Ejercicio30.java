package ejercicios_arrays;

import java.util.Scanner;

//Reorganiza un array para que los valores pares y los impares aparezcan alternados. Si hay más de un tipo, los sobrantes van al final

public class Ejercicio30 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int arraySize = 5;
		int[] arrayOriginal = new int[arraySize];
		int[] arrayPares = new int[arraySize];
		int[] arrayImpares = new int[arraySize];
		int[] arrayOrdenado = new int[arrayOriginal.length];
		
		//Leemos el array de partida
		for (int i = 0; i < arrayOriginal.length; i++) {
			System.out.println("Introduce un número entero");
			arrayOriginal[i] = scan.nextInt();
		}
		
		//Rellenamos dos arrays, uno de pares y otro de impares, con los números almacenados en el array de partida
		int par = 0; //Contador pares
		int impar = 0; //Contador impares
		for (int i = 0; i < arrayOriginal.length; i++) {
			if (arrayOriginal[i] % 2 == 0) {
				arrayPares[par++] = arrayOriginal[i];
			} else {
				arrayImpares[impar++] = arrayOriginal[i];
			}
		}
		
		//Declaramos arrays para los números pares e impares que tengan sólo el tamaño adecuado a la cantidad de números pares e impares respectivamente, para así evitar posiciones vacías
		int[] arrayParesFinal = new int[par];
		int[] arrayImparesFinal = new int[impar];
		
		//Rellenamos los arrays declarados justo encima únicamente con los números que provengan del array original, eliminando las posiciones vacías que pudieron quedar al rellenar los arrays iniciales de pares e impares
		for (int i = 0; i < arrayParesFinal.length; i++) {
			arrayParesFinal[i] = arrayPares[i];
		}
		
		for (int i = 0; i < arrayImparesFinal.length; i++) {
			arrayImparesFinal[i] = arrayImpares[i];
		}
		
		par = 0; //Contador pares. Misma variable de antes, reinicializada a 0
		impar = 0; //Contador impares. Misma variable de antes, reinicializada a 0
		int arr = 0; //Contador array ordenado
		
		//Añadimos de forma alterna números pares e impares al array final de ordenados. El bucle termina en cuanto el array de pares o el de impares se agota
		while(par < arrayParesFinal.length && impar < arrayImparesFinal.length) {
			arrayOrdenado[arr++] = arrayParesFinal[par++];
			arrayOrdenado[arr++] = arrayImparesFinal[impar++];
		}
		
		//Si se han quedado números pares sin añadir (porque se terminó primero el array de impares), los añadimos aquí. Esto es posible porque conservamos el valor de la variable contadora par
		while (par < arrayParesFinal.length) {
			arrayOrdenado[arr++] = arrayParesFinal[par++];
		}
		
		//Si se han quedado números impares sin añadir (porque se terminó primero el array de pares), los añadimos aquí. Esto es posible porque conservamos el valor de la variable contadora impar
		while (impar < arrayImparesFinal.length) {
			arrayOrdenado[arr++] = arrayImparesFinal[impar++];
		}
		
		//Mostramos el array final
		System.out.print("Array final: ");
		for (int s : arrayOrdenado) {
			System.out.print(s + ", ");
		}
		scan.close();

	}

}
