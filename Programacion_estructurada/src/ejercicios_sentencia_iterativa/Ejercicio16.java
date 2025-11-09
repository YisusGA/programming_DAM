package ejercicios_sentencia_iterativa;

/**
 * 16.	Pedir 10 números, y mostrar al final si se ha introducido alguno negativo
 */

import java.util.Scanner;

public class Ejercicio16 {

	public static void main(String[] args) {
		int negCount = 0;
		boolean algunoNegativo = false;
		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < 10; i++) {
			System.out.println("Introduce un número entero");
			int n = scan.nextInt();
			if (n < 0) {
				algunoNegativo = true;
			}
//			CIUDADO: Si ponemos esto de debajo, si introducimos un número negativo, y la variable booleana cambia a true, tras introducir el 
//			siguiente número, si este es positivo, pisa el valor true anterior y lo cambia a false. Entonces, es como si no hubiéramos introducido 
//			ningún negativo
//			else {
//				algunoNegativo = false;
//			}
		}
		if (algunoNegativo) {
		System.out.println("Se ha introducido algún número negativo");
		}
		else {
			System.out.println("No se ha introducido ningún número negativo");
		}
		scan.close();
	}

}
