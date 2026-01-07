package ejercicios_arrays;

//Dado un array de enteros, genera otro array sin números repetidos y ordena los elementos según el número de veces que aparecen en el array original (de mayor a menor frecuencia)
//No terminado aún

import java.util.Scanner;

public class Ejercicio29 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int arraySize = 5; //Tamaño del array que leemos
		int[] arrayOriginal = new int[arraySize]; //Array que leemos por teclado
		int[] numerosUnicos = new int[arrayOriginal.length]; //Array que llenaremos con aquellos números que aparezcan por primera y única vez. Le damos el tamaño máximo (el del array original)
		int[] frecuencias = new int[arrayOriginal.length]; //Array que llenaremos con las frecuencias de cada número del array original. Le damos el tamaño máximo (el del array original)
		int contadorUnicos = 0; //Contador de cuántos números únicos (que aparecen sólo 1 vez) hay en el array original

		//Rellenamos el array original con números enteros leídos por teclado
		for (int i = 0; i < arrayOriginal.length; i++) {
			System.out.println("Introduce un número entero");
			arrayOriginal[i] = scan.nextInt();
		}
		
		//Mostramos el array que se ha leído por teclado antes de modificar nada
		System.out.print("El array introducido es: ");
		for (int i : arrayOriginal) {
			System.out.print(i + ", ");
		}
		
		//Generamos un array con los números únicos y vamos añadiento la frecuencia de cada uno en otro array
		for (int i = 0; i < arrayOriginal.length; i++) {
			boolean existe = false;
			for (int j = 0; !existe && j < contadorUnicos; j++) { //Si el número ya se había encontrado y añadido al array de números únicos, se incrementa su frecuencia y se sale del bucle for
				if (numerosUnicos[j] == arrayOriginal[i]) {
					frecuencias[j]++;
					existe = true;
				}
			}
			if (!existe) { //Si el número no se había encontrado previamente, se incluye en el array de números únicos, se le asigna una frecuencia de 1 y se mueve la posición en el array de números únicos
				numerosUnicos[contadorUnicos] = arrayOriginal[i];
				frecuencias[contadorUnicos] = 1;
				contadorUnicos++;
			}
		}
		
		//Se ordenan tanto el array de frecuencias como el array de números únicos de acuerdo a las frecuencias descendentes
		for (int i = 0; i < contadorUnicos; i++) {
			for (int j = i + 1; j < contadorUnicos; j++) {
				if (frecuencias[i] < frecuencias[j]) {
					// Intercambiar frecuencias
					int tempFreq = frecuencias[i];
					frecuencias[i] = frecuencias[j];
					frecuencias[j] = tempFreq;

					// Intercambiar números
					int tempNum = numerosUnicos[i];
					numerosUnicos[i] = numerosUnicos[j];
					numerosUnicos[j] = tempNum;
				}
			}
		}
		
		
		//Se eliminan las posiciones vacías del array de números únicos pasando los valores "útiles" a un nuevo array
		int[] arrayResultadoNumeros = new int[contadorUnicos];
		for (int i = 0; i < contadorUnicos; i++) {
			arrayResultadoNumeros[i] = numerosUnicos[i];
		}
		
		//Se eliminan las posiciones vacías del array de frecuencias pasando los valores "útiles" a un nuevo array
		int[] arrayResultadoFrecuencias = new int[contadorUnicos];
		for (int i = 0; i < contadorUnicos; i++) {
			arrayResultadoFrecuencias[i] = frecuencias[i];
		}

		//Mostramos el array final ordenado con frecuencias descendentes y sin repeticiones
		System.out.println();
		System.out.print("El array ordenado con frecuencias descendentes y sin repeticiones es: ");
		for (int i : arrayResultadoNumeros) {
			System.out.print(i + ", ");
		}

		//Mostramos el array final de frecuencias
		System.out.println();
		System.out.print("El array de frecuencias respecto al array final es: ");
		for (int i : arrayResultadoFrecuencias) {
			System.out.print(i + ", ");
		}

		scan.close();

	}

}
