package ejercicios_sentencia_iterativa;

/**
 * Programa que solicite números hasta que se introduzca un cero, y cuente cuántos de esos números son de 2 cifras
 */

import java.util.Scanner;

public class Ejercicio05b {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n;
		int counter = 0;
		do {
			System.out.println("Introduce un número entero");
			n = scan.nextInt();
			//La primera versión que yo hice transformando a String el número y contando el número de caracteres
			//no sirve si se introduce un número negativo, pues el signo también cuenta como caracter
			if ((n >= 10 && n <= 99) || (n >= -99 && n <= -10)) {
				counter++;
			}
		} while (n != 0);
		scan.close();
		System.out.println(counter + " números tienen 2 cifras");
	}

}
