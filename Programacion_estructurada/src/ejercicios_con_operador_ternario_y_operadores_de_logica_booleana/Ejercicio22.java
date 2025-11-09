package ejercicios_con_operador_ternario_y_operadores_de_logica_booleana;

import java.util.Scanner;

public class Ejercicio22 {
	//Escribe un programa que lea por teclado tres variables de tipo double para representar las
	//longitudes de los lados de un triángulo. Muestra en pantalla si el triángulo es equilátero o no

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce la longitud de un lado del triángulo");
		double n1 = scan.nextDouble();
		System.out.println("Introduce la longitud de otro lado del triángulo");
		double n2 = scan.nextDouble();
		System.out.println("Introduce la longitud del tercer lado del triángulo");
		double n3 = scan.nextDouble();
		String igual = n1 == n2 && n2 == n3 ? "El triángulo es equilátero":"El triángulo no es equilátero";
		System.out.println(igual);
		scan.close();

	}

}
