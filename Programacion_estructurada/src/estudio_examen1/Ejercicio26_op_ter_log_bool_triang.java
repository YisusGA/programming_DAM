package estudio_examen1;

/*
 * Escribe un programa que lea de teclado tres variables de tipo double para representar las
 * longitudes de los lados de un triángulo. Muestra en pantalla si el triángulo es equilátero,
 * isósceles o escaleno, o si no es un triángulo. Para que sea un triángulo, la suma de cada par de sus lados 
 * tiene que ser mayor que el otro lado. Se tienen que dar las 3 condiciones simultáneamente.
 */

import java.util.Scanner;

public class Ejercicio26_op_ter_log_bool_triang {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce el lado 1 del triángulo");
		double lado1 = scan.nextDouble();
		System.out.println("Introduce el lado 2 del triángulo");
		double lado2 = scan.nextDouble();
		System.out.println("Introduce el lado 3 del triángulo");
		double lado3 = scan.nextDouble();
		scan.close();
		if ((lado1 + lado2) < lado3 || (lado1 + lado3) < lado2 || (lado2 + lado3) < lado1) {
			System.out.println("Eso no es un triángulo, picha");
			System.exit(0);
		}
		if (lado1 == lado2 && lado2 == lado3) {
			System.out.println("El triángulo es equilátero");
		} else if (lado1 == lado2 || lado1 == lado3 || lado2 == lado3) {
			System.out.println("El triángulo es isósceles");
		} else {
			System.out.println("El triángulo es escaleno");
		}

	}

}
