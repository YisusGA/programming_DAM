package ejercicios_sentencia_de_decision;

import java.util.Scanner;

public class Ejercicio05_2 {

	//Realizar un programa que lea un número entero de tres cifras e 
	//indique si se lee igual de izquierda a derecha que de derecha a izquierda
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce un número entero de 3 cifras");
		int n = scan.nextInt();
		scan.close();
		if (n < 100 || n >999) {
			System.out.println("El número introducido no es válido");
		} else {
			/*
			 * Importante poner las comillas del String vacío al principio del todo. Si no hacemos esto, si hubiera operaciones aritméticas con los números,
			 * primero se harían las operaciones que van antes de las comillas del String, y luego se concatenaría con el String vacío.
			 * Dependiendo del caso, esto podría interesarnos o no, pero lo más común es que no.
			 * En este caso concreto de debajo, daría igual poner las comillas del String antes o después de n.
			 */
			String nCadena = "" + n;
			char c1 = nCadena.charAt(0);
			char c3 = nCadena.charAt(2);
			if (c1 == c3) {
				System.out.println("El número introducido es capicúa");
			} else {
				System.out.println("El número introducido no es capicúa");
			}
			
		}

	}

}
