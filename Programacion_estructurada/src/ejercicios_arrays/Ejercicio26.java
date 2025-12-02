package ejercicios_arrays;

/**
 * Crear un array de 5 posiciones. Leer números (hasta que el usuario quiera) y guardarlos en el array. Al final imprimir el contenido del array
 */

import java.util.Scanner;

public class Ejercicio26 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int arraySize = 5;
		int numeros[] = new int[arraySize];
//		int salida = 1;
		for (int i = 0, n = 0; n >= 0; i++) {
			System.out.println("Introduce un número mayor o igual que 0. Cuando quieras parar, introduce un número negativo");
			n = scan.nextInt();
			if (n >= 0) {
				numeros[i] = n;
			}
			if (i == 4) {
				i = -1;
			}
		}
		System.out.print("Contenido final del array: ");
		for (int i : numeros) {
			System.out.print(i + ", ");
		}
		scan.close();		
	}

}
