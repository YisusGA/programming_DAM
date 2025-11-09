package bucles_sentencia_iterativa;

import java.util.Scanner;

public class Ejemplo1 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		//Si queremos que entre en el bucle, una forma de solucionarlo sería inicializar la variable con un valor que haga que entre en el bucle
		int n = -1;
		while(n < 0) {
			System.out.println("Introduzca un número positivo");
			n = scan.nextInt();
		}
		System.out.println("EL número introducido es n: " + n);
	}

}
