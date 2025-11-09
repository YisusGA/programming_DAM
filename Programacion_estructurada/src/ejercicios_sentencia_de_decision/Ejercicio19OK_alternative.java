package ejercicios_sentencia_de_decision;

/**
 * La diferencia de este con respecto al Ejercicio19OK es básicamente que en este, no introduzo el método
 * if (scan.hasNextInt()), sino que lo hago de forma más simple. El problema de no introducir este método es
 * que si el número se sale del rango de un int o si directamente no es un número, saldrá un error en la consola
 * pero no indicará qué ha sucedido. Al introducir el método, sí que te dice a qué se debe el error, porque hemos
 * puesto una condición que, si se cumple, muestra el mensaje de error que nosotros queremos.
 */

import java.util.Scanner;

public class Ejercicio19OK_alternative {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce una letra minúscula");
		char c1 = scan.nextLine().charAt(0);
		System.out.println("Introduce otra letra minúscula");
		char c2 = scan.nextLine().charAt(0);
		System.out.println("Introduce una tercera letra minúscula");
		char c3 = scan.nextLine().charAt(0);
		System.out.println("Introduce un número entero");
		int n = scan.nextInt();
		scan.close();
		int cN1 = 1;
		int cN2 = 1;
		int cN3 = 1;
		if (c1 < 97 || c1 > 122 || c2 < 97 || c2 > 122 || c3 < 97 || c3 > 122) {
			System.out.println("La letra introducida debe ser una minúscula y ser diferente de ñ");
			System.exit(0);
		}
		if (n > Integer.MAX_VALUE - 122) {
			System.out.println("El número introducido es demasiado grande");
			System.exit(0);
		}
		cN1 = (c1 + n - 'a') % 26 + 'a';
		cN2 = (c2 + n - 'a') % 26 + 'a';
		cN3 = (c3 + n - 'a') % 26 + 'a';
		System.out.println("El caracter introducido " + c1 + " se convierte en " + (char)cN1 + " tras avanzar " + n + " posiciones");
		System.out.println("El caracter introducido " + c2 + " se convierte en " + (char)cN2 + " tras avanzar " + n + " posiciones");
		System.out.println("El caracter introducido " + c3 + " se convierte en " + (char)cN3 + " tras avanzar " + n + " posiciones");
	}
}
