package bucles_sentencia_iterativa;

/**
 * Leer 10 números decimales
 */

import java.util.Scanner;
public class Ejemplo4for {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		double num;
		for (int i = 0; i < 3; i++) {
			System.out.println("Introduce un número decimal");
			num= scan.nextDouble();
			System.out.println("Has introducido " + num);
			System.out.println(" ");
			//Si quisiera que este bucle fuera infinito, podemos meter lo que viene aquí debajo
			//i--;
		}
		/*
		 * Versión en la que introduzo 3 números decimales, pero si introduzco 0, se detiene el bucle
		 */
		num = 1;
		for (int i = 0; i < 3 && num != 0; i++) {
			System.out.println("Introduce un número decimal");
			num= scan.nextDouble();
			System.out.println("Has introducido " + num);
			System.out.println(" ");
		}	
	}

}
