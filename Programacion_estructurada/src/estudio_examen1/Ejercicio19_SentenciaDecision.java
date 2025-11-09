package estudio_examen1;

/** 
 * Recibe tres letras minúsculas y un número entero. Sustituye cada char 
 * con el char en minúscula del alfabeto que se encuentra n posiciones 
 * después(si acaba el alfabeto, empieza desde el principio)
 */

import java.util.Scanner;

public class Ejercicio19_SentenciaDecision {

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
