package arrays;

/**
 * Programa que lea por teclado 5 nombres, muestre cuántos empiezan por mayúscula y muestre concatenados los que comienzan por mayúscula
 */

import java.util.Scanner;

public class Ejercicio01 {

	public static void main(String[] args) {
		char[] letras;
		int counter = 0;
		letras = new char[5];
		Scanner scan = new Scanner(System.in);
		String linea = "";
		for (int i = 0; i < 5; i++) {
			System.out.println("Introduce un nombre");
			String nombre = scan.nextLine();
			;
			letras[i] = nombre.charAt(0);
			if (letras[i] >= 65 && letras[i] <= 90) {
				counter++;
				linea += nombre;
			}
		}
		System.out.println(counter + " nombres empiezan por mayúscula");
		System.out.println(linea);
		scan.close();
	}

}
