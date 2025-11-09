package ejemplos_logicos;

import java.util.Scanner;

public class RangosBooleanos {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce un número entero");
		int n = scan.nextInt();
		boolean cond = ( n > 3 ) && ( n < 6 );
		System.out.println("Tu número está en el rango (3-6): " + cond);
		
		//Ahora deseamos saber si una variable tiene el valor "a" sin importar si es mayúscula o minúscula
		char c = 'b';
		boolean cond2 = ( c == 'a' ) || ( c == 'A' );
		System.out.println("La condición cond2 es: " + cond2);
		
		char c2 = 'a';
		boolean cond3 = ( c2 == 'a' ) || ( c2 == 'A' );
		System.out.println("La condición cond3 es: " + cond3);
	}

}
