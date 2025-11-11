package ejercicios_sentencia_iterativa;

/**
 * Programar un juego de adivinanza. El programa pedirá al usuario dos números, max y min, y un número de intentos, n. 
 * El programa obtendrá a continuación un número aleatorio entre max y min, y el usuario deberá adivinarlo utilizando como mucho n intentos. 
 * Cada vez que el usuario introduce un número, el programa le dice si es mayor o menor. Al final el programa indica si se ha ganado o no 
 * (para generar un número aleatorio se puede utilizar la clase Random o Math).
 */

import java.util.Scanner;

public class Ejercicio24_Math {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
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
		while (intentos <= 0) {
			System.out.println("Debes introducir un número de intentos mayor que 0");
			intentos = scan.nextInt();
		}
		/*
		 * En este caso, usamos la función Math.random(), que genera un número double aleatorio entre 0 (inclusivo) y 1.0 (exclusivo).
		 * Si queremos trabajar en un rango, hacemos igual que se explicó para la clase Random, calculando (max - min + 1) + min. La
		 * diferencia es que en este caso, debemos multiplicar el resultado de Math.random() por el resultado de (max - min + 1) y a esto
		 * sumarle el min. Y todo esto, lo casteamos a int, para tener un número entero en lugar de uno decimal. En mi opinión, es más
		 * sencilla de usar la clase Random, aunque requiere que se importe la clase en la cabecera del código y se cree una instancia
		 * de Random.
		 */
		int nRandom = (int)(Math.random() * (max - min + 1) + min);
		for (int i = 1; i <= intentos; i++) {
			boolean acierto = false;
			System.out.println("Prueba suerte. Introduce un número");
			int n = scan.nextInt();
			if (n == nRandom) {
				System.out.println("¡Has acertado! El número generado era: " + nRandom);
				break;
			} else if (n > nRandom) {
				System.out.println("Te has pasado, prueba con un número menor");
			} else if (n < nRandom) {
				System.out.println("Te has quedado corto, prueba con un número menor");
			}
		}
		scan.close();
	}

}