package variables_objeto;

import java.util.Scanner;

public class Leer_teclado_decimales {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Haz click en la consola e introduce un número decimal poniendo el decimal con coma");
		double dato = scan.nextDouble();
		scan.close();
		double resultado;
		resultado = dato / 2.0;
		System.out.println("Resultado: " + resultado);

	}

}
