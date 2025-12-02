package bucles_sentencia_iterativa;

import java.util.Random;

public class For_each_usos {

	public static void main(String[] args) {
		Random generador = new Random();
		int[] numeros = new int[5];
		int[] nuevosNumeros = new int[5];
		for (int i = 0; i < numeros.length; i++) {
			numeros[i] = generador.nextInt();
		}
		
		//Formas de rellenar el array nuevosNumeros
		
		//Esto no va a funcionar, porque no existe 'i' para añadir al nuevo array
//		for (int numero : numeros) {
//			nuevosNumeros[i] = numero;
//		}
		
		//Forma 1: Crear el contador fuera del bucle for-each
		int index = 0;
		for (int numero : numeros) {
			nuevosNumeros[index++] = numero; //Se va post-incrementando el contador
		}
		//Imprimimos el array relleno
		System.out.print("Array nuevosNumeros forma 1: ");
		for (int i : nuevosNumeros) {
			System.out.print(i + ", ");
		}
		System.out.println();
		
		//Forma 2: Se crea el contador dentro del for, y no se usa el for-each
		for (int i = 0; i < numeros.length; i++) {
			nuevosNumeros[i] = numeros[i];
		}
		//Imprimimos el array relleno
				System.out.print("Array nuevosNumeros forma 2: ");
				for (int i : nuevosNumeros) {
					System.out.print(i + ", ");
				}
	}

}
