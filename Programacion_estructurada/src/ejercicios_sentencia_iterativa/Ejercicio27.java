package ejercicios_sentencia_iterativa;

/**
 * Programa que dado un número entero lo exprese en el sistema de numeración romano
 */

import java.util.Scanner;

public class Ejercicio27 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String unidades = "";
		String decenas = "";
		String centenas = "";
		String miles = "";
		System.out.println("Introduce un número entero comprendido entre 0 y 3999");
		int num = scan.nextInt();
		while (num < 0 || num > 3999) {
			System.out.println("Número no válido, prueba de nuevo");
			num = scan.nextInt();
		}
		int numOriginal = num;
		scan.close();
		int[] cifras = new int[("" + num).length()]; //Sacamos el número de cifras del número y asignamos ese tamaño al array
		for (int i = 0; num > 0; i++) {
			cifras[i] = num % 10;
			num /= 10;
		}
		//UNIDADES
		switch (cifras[0]) {
			case 1, 2, 3:
				for (int i = 1; i <= cifras[0]; i++) {
					unidades += "I";
				}
			break;
			case 4:
				unidades = "IV";
				break;
			case 5:
				unidades = "V";
				break;
			case 6, 7, 8:
				unidades = "V";
			for (int i = 6; i <= cifras[0]; i++) {
				unidades += "I";
			}
			break;
			case 9:
				unidades = "IX";
				break;
			}
		//DECENAS
		if (numOriginal >= 10) {
			switch (cifras[1]) {
				case 1, 2, 3:
					for (int i = 1; i <= cifras[1]; i++) {
						decenas += "X";
					}
				break;
				case 4:
					decenas = "XL";
					break;
				case 5:
					decenas = "L";
					break;
				case 6, 7, 8:
					decenas = "L";
				for (int i = 6; i <= cifras[1]; i++) {
					decenas += "X";
				}
				break;
				case 9:
					decenas = "XC";
					break;
			}
		}
		//CENTENAS
		if (numOriginal >= 100) {
			switch (cifras[2]) {
				case 1, 2, 3:
					for (int i = 1; i <= cifras[2]; i++) {
						centenas += "C";
					}
				break;
				case 4:
					centenas = "CD";
					break;
				case 5:
					centenas = "D";
					break;
				case 6, 7, 8:
					centenas = "D";
				for (int i = 6; i <= cifras[2]; i++) {
					centenas += "C";
				}
				break;
				case 9:
					centenas = "CM";
					break;
			}
		}
		//MILES
		if (numOriginal >= 1000) {
			for (int i = 1; i <= cifras[3]; i++) {
				miles += "M";
			}
		}	
		System.out.println("El número romano de " + numOriginal + " es: " + miles + centenas + decenas + unidades);
	}

}
