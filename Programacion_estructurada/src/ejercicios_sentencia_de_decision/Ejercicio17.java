package ejercicios_sentencia_de_decision;

import java.util.Scanner;

/**
 * Recibe 4 char y comprueba que ha recibido, en orden ‘g’ ‘a’ ‘t’ ‘o’.
 */

public class Ejercicio17 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce una letra minúscula");
		char c1 = scan.nextLine().charAt(0);
		System.out.println("Introduce una segunda letra minúscula");
		char c2 = scan.nextLine().charAt(0);
		System.out.println("Introduce una tercera letra minúscula");
		char c3 = scan.nextLine().charAt(0);
		System.out.println("Introduce una cuarta letra minúscula");
		char c4 = scan.nextLine().charAt(0);
		
		if (c1 == 'g' && c2 == 'a' && c3 == 't' && c4 == 'o') {
			System.out.println("El orden es correcto, la palabra formada con las letras en orden es gato");
		} else {
			System.out.println("El orden introducido no es correcto");
		}
		
		//Otra forma
		
		/*
		 * Recordemos que para concatenar datos como un string, tenemos que concatenar primero un String con lo que venga después,
		 * y así todo será convertido a String. Si ponemos el String al final, la VM va a hacer primero todas las operaciones aritméticas,
		 * y luego el resultado lo concatenará con el string. Y eso no es lo que queremos
		 */
		String palabra = "" + c1 + c2 + c3 + c4;
		if (palabra.equals("gato")) {
			System.out.println("El orden es correcto, la palabra formada con las letras en orden es gato");
		} else {
			System.out.println("El orden introducido no es correcto");
		}
		
		//Como se ha comentado antes, fijarse en que si ponemos el String al final de la concatenación, el resultado no es el deseado
		String palabra2 = c1 + c2 + c3 + c4 + "";
		System.out.println("palabra2 " +  palabra2);
		
		//Otra forma
		System.out.println("Introduce una palabra de 4 letras");
		String palabraScan = scan.nextLine();
		if (palabraScan.equals("gato")) {
			System.out.println("El orden es correcto, la palabra formada con las letras en orden es gato");
		} else {
			System.out.println("El orden introducido no es correcto");
		}
		scan.close();
		//Recordar que podemos sacar una posición de un String ya existente
		char t = palabraScan.charAt(0);
		System.out.println("La primera letra de la palabara introducida es: " + t);
		

	}

}
