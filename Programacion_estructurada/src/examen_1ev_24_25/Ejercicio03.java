package examen_1ev_24_25;

import java.util.Scanner;

public class Ejercicio03 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		//Variables
		int arraySize = 10; //Tamaño del array inicial
		int[] numeros = new int[arraySize]; //Array inicial de lectura
		int contadorNumerosIntroducidos = 0; //Variable para contar cuántos números hemos introducido antes de meter un 0. Si no se mete 0, serán 10
		
		//Rellenamos el array por teclado, hasta introducir un 0 (que no se almacenará) o hasta tener 10 valores 
		for (int i = 0; i < 10; i++) {
			int n;
			System.out.println("Introduce un número entero positivo. Máximo hasta 10. Introduce 0 si quieres que pare antes");
			while ((n = scan.nextInt()) < 0) { //Si es menor que 0, muestra mensaje de error y pide de nuevo
				System.err.println("Número no válido, introduce uno positivo");
			}
			if (n == 0) { //Si el número introducido es 0, se para el bucle y no se almacena el 0
				break;
			} else { //Sólo se almacena el número si es mayor que 0, y contamos que se ha almacenado
				numeros[i] = n;
				contadorNumerosIntroducidos++;
			}
		}
		
		//Si el primer número que introduce el usuario es 0, abortamos el programa y pedimos que se ejecute de nuevo
		if (contadorNumerosIntroducidos == 0) {
			System.err.println("Debes introducir al menos un número distinto de 0. Ejecuta de nuevo el programa");
			System.exit(0);
		}
		
		//Imprimimos el array inicial
		System.out.print("Array Inicial: ");
		for(int i : numeros) {
			System.out.print(i + " ");
		}
		
		//Creamos un array auxiliar, que nos va a servir para reducir el tamaño del array inicial a la cantidad de números leídos antes de introducir el 0
		int[] aux = new int[contadorNumerosIntroducidos]; //La longitud del array auxiliar será la cantidad de números introducidos mayores que 0
		for (int i = 0, j = 0; i < numeros.length; i++) {
			if (numeros[i] != 0) { //Sólo almacenamos en el array auxiliar los números mayores que 0 del array inicial
				aux[j++] = numeros[i];
			}
		}
		
		//Cuando hemos llenado el array auxiliar, asignamos al array inicial numeros la dirección de memoria del array auxiliar
		numeros = aux;
		
		//Imprimimos el array numeros ya habiendo eliminado los 0 (posiciones vacías) y habiendo reducido su tamaño a la cantidad de números útiles (mayores que 0)
		System.out.println();
		System.out.print("Array final: ");
		for(int i : numeros) {
			System.out.print(i + " ");
		}
		
		//Aquí, vamos a iterar el array numeros sobre sí mismo, para contar cuántos números se repiten. Vamos a ir almacenando el número de veces que se repite cada
		//número en una posición de un nuevo array
		int[] contadorVeces = new int[numeros.length];
		for (int i = 0, j = 0; i < numeros.length; i++) {
			int cont = 1; //Contador de cuántas veces se repite cada número del array comparándolo con las posiciones posteriores a él
			for (int k = i; k < numeros.length; k++) {
				if (numeros[i] == numeros[k] && i != k) {
					cont++; //Almacenamos ese número en un contador, que se reseteará a 1 cuando comience la siguiente iteración del bucle parental (el que incrementa la i)
				}
			}
			contadorVeces[j++] = cont; //Guardamos ese valor de repeticiones en una posición en el array que creamos antes de entrar en este bucle
		}
		
		//Aunque no lo pidan, imprimimos el número de veces que aparece cada número
		System.out.println();
		System.out.print("Contador repeticiones: ");
		for (int i : contadorVeces) {
			System.out.print(i + " ");
		}
		
		//Iteramos sobre el array que almacena el contador de veces que aparece cada número. Y buscamos su valor máximo 
		int max = contadorVeces[0];
		for (int i = 1; i < contadorVeces.length; i++) {
			if (contadorVeces[i] > max) {
				max = contadorVeces[i]; 
			}
		}
		
		//Como cada contador del array contadorVeces se corresponde con la misma posición del array numeros, buscamos a qué posición de numeros[i] se corresponde,
		//y así obtenemos el número más frecuente
		int numFrecuente = 0;
		for (int i = 0; i < contadorVeces.length; i++) {
			if (contadorVeces[i] == max) {
				numFrecuente = numeros[i];
			}
		}
		
		//Imprimimos el número más frecuente y el número de veces que aparece
		System.out.println();
		System.out.println("El número que más veces se repite es: " + numFrecuente + ". Aparece " + max + " veces");
		scan.close();
	}

}
