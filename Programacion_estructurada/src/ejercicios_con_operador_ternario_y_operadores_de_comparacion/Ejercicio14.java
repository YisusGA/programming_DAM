package ejercicios_con_operador_ternario_y_operadores_de_comparacion;

import java.util.Scanner;

public class Ejercicio14 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce un número entero");
		int n = scan.nextInt();
		boolean par = n % 2 == 0;
		String print = par?"El número introducido: " + n + " es par":"El número introducido: " + n + " es impar";
		System.out.println(print);
		scan.close();
	}

}
