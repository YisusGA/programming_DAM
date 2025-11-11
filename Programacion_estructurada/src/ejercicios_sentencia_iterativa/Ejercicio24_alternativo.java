package ejercicios_sentencia_iterativa;

/**
 * Programar un juego de adivinanza. El programa pedirá al usuario dos números, max y min, y un número de intentos, n. 
 * El programa obtendrá a continuación un número aleatorio entre max y min, y el usuario deberá adivinarlo utilizando como mucho n intentos. 
 * Cada vez que el usuario introduce un número, el programa le dice si es mayor o menor. Al final el programa indica si se ha ganado o no 
 * (para generar un número aleatorio se puede utilizar la clase Random o Math).
 */

import java.util.Scanner;
import java.util.Random;

public class Ejercicio24_alternativo {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random generador = new Random();
		System.out.println("Introduce el mínimo del intervalo");
		int min = scan.nextInt();
		System.out.println("Introduce el máximo del intervalo");
		int max = scan.nextInt();
		while (max == min) {
			System.out.println("El máximo y el mínimo del intervalo no pueden coincidir");
			System.out.println("Introduce el mínimo del intervalo");
			min = scan.nextInt();
			System.out.println("Introduce el máximo del intervalo");
			max = scan.nextInt();
		}
		if (min > max) { //En caso de que el usuario se ponga juguetón e introduza un máximo menor que el mínimo, los invertimos
			int maxTemporal = min;
			min = max;
			max = maxTemporal;
		}
		System.out.println("Introduce un número de intentos");
		int intentos = scan.nextInt();
		int n;
		while (intentos <= 0) {
			System.out.println("Debes introducir un número de intentos mayor que 0");
			intentos = scan.nextInt();
		}
		/*
		 * Ver la explicación sobre cómo usar el generador de números aleatorios dentro de un rango en el cuaderno. 
		 * Por decirlo en corto, se resta el max menos el min para sacar la distancia entre los extremos, y se suma 
		 * uno para incluir el extremo de la derecha, pues si no, no se incluye.
		 * Además, al resultado de esto se le suma el min del intervalo, el cual actúa como un offset. Si no hacemos esto,
		 *  el generador de números aleatorios trabaja en un intervalo que comienza en el 0 y tantas posiciones desde el 0 
		 *  como sea el número dentro de los paréntesis.
		 */
		int nRandom = generador.nextInt(max - min + 1) + min;
		do {
			System.out.println("Num intentos restantes: " + intentos);
			intentos--;
			boolean acierto = false;
			System.out.println("Prueba suerte. Introduce un número");
			n = scan.nextInt();
			if (n == nRandom) {
				System.out.println("¡Has acertado! El número generado era: " + nRandom);
			} else if (n > nRandom && intentos > 0) {
				System.out.println("Te has pasado");
			} else if (n < nRandom && intentos > 0) {
				System.out.println("Te has quedado corto");
			}
		} while (intentos > 0 && n != nRandom);
		if (intentos == 0 && n != nRandom) {
			System.out.println("Has agotado los intentos y no has acertado");
		}
		scan.close();
	}

}
