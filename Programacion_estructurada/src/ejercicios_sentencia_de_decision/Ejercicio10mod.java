package ejercicios_sentencia_de_decision;

import java.util.Scanner;

public class Ejercicio10mod {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce la longitud de un lado del triángulo");
		double lado1 = scan.nextDouble();
		System.out.println("Introduce la longitud del segundo lado del triángulo");
		double lado2 = scan.nextDouble();
		System.out.println("Introduce la longitud del tercer lado del triángulo");
		double lado3 = scan.nextDouble();
		scan.close();
		if (((lado1 + lado2) < lado3) || ((lado1 + lado3) < lado2) || ((lado2 + lado3) < lado1)) {
			System.out.println("Eso no es un triángulo");
		} else if (lado1 == lado2 && lado2 == lado3) {
		System.out.println("El triángulo es equilátero");
		} else if (lado1 == lado2 || lado1 == lado3 || lado2 == lado3) {
		System.out.println("El triángulo es isósceles");
		} else if (lado1 != lado2 && lado1!= lado3 && lado2!= lado3) {
			System.out.println("El triángulo es escaleno");
		}

	}

}
