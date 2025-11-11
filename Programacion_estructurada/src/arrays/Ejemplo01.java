package arrays;

import java.util.Random;

public class Ejemplo01 {

	public static void main(String[] args) {
		int [] numeros = new int[10];
		numeros [0] = 3;
		numeros [4] = 7;
		for (int i = 0; i < 10; i++) {
			System.out.println("array: " + numeros[i]);
		}
		
//		Si trato de acceder a una posición del array que no existe, mostrará un error de excepción: 
//		java.lang.ArrayIndexOutOfBoundsException
//		for (int i = 0; i <= 10; i++) {
//			System.out.println(numeros[i]);
//		}
		
		//Recorrer el array al revés
		for (int i = 9; i >= 0; i--) {
			System.out.println("array al revés: " + numeros[i]);
		}
		//Con esto, llenamos un array con números aleatorios
		for (int i = 0; i < 10; i++) {
			numeros [i] = (int)(Math.random() * 20);
			System.out.println("array aleatorio 1: " + numeros[i]);
		}
		//Con esto, llenamos un array con números aleatorios pero usando la clase Random
		Random generador = new Random();
		for (int i = 0; i < 10; i++) {
			numeros [i] = generador.nextInt();
			System.out.println("array aleatorio 2: " + numeros[i]);
		}	
	}

}
