package ejercicios_sentencia_de_decision;

import java.util.Scanner;

public class Ejercicio14 {

	//Recibir un número e indicar si es válido. Es válido si es un numero 
	//positivo menor que 100 o un numero negativo menor que -100
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce un número entero");
		int n = scan.nextInt();
		scan.close();
		if ((n > 0 && n < 100) || (n < -100)) {
			System.out.println("El número introducido es válido");
		} else {
			System.out.println("El número introducido, como Clara de Heidi, es inválido");
		}

	}

}
