package ejercicios_sentencia_de_decision;

import java.util.Scanner;

public class Ejercicio02 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce un año");
		int n1 = scan.nextInt();
		if ((n1 % 4 == 0) || ((n1 % 100 == 0) && (n1 % 400 == 0))) {	
			System.out.println("El año es bisiesto");
		
		} else {
			System.out.println("El año no es bisiesto");
		}
		scan.close();

	}

}
