package ejercicios_en_clase;

import java.util.Scanner;

public class Ejercicio27 {
	
	//Programa que lea dos caracteres y te diga si el segundo es el primero en mayúsculas. 
	//Si no lo es, te dirá cuál es la mayúsucula del primero.
	//Si el primer caracter introducido no es una letra minúscula, mostrar un mensaje y no seguir

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println ("Introduce una letra mayúscula o minúscula");
		char car1 = scan.nextLine().charAt(0);
		System.out.println ("Introduce otra letra mayúscula o minúscula");
		char car2 = scan.nextLine().charAt(0);
		boolean car1Valido = (car1 >= 97) && (car1 <= 122);
		int car1May = car1 - 32;
		String print = !car1Valido ? "El primero caracter introducido no es válido, por favor introduce una letra minúscula" : (car2 == (car1 - 32)) ? "El segundo char es la mayúscula del primero" : "El segundo no es la mayúscula del primero. La mayúscula del primero es: " + (char)car1May;
		System.out.println (print);
		scan.close();

	}

}
