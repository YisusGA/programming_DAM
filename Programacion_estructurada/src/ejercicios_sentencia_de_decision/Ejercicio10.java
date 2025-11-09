package ejercicios_sentencia_de_decision;

import java.util.Scanner;

public class Ejercicio10 {

	//Realizar un programa que lea tres longitudes y determine si forman o no un triángulo. Si es un triángulo, 
	//determinar de qué tipo de triángulo se trata entre: equilátero (si tiene tres lados iguales), isósceles 
	//(si tiene dos lados iguales) o escaleno (si tiene tres lados desiguales). Considerar que para formar un 
	//triángulo se requiere que: "el lado mayor sea menor que la suma de los otros dos lados"
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce la longitud de un lado del triángulo");
		double lado1 = scan.nextDouble();
		System.out.println("Introduce la longitud del segundo lado del triángulo");
		double lado2 = scan.nextDouble();
		System.out.println("Introduce la longitud del tercer lado del triángulo");
		double lado3 = scan.nextDouble();
		scan.close();
		double ladoMayor;
		double sumaMenores;
		if (lado1 >= lado2 && lado1 >= lado3) {
			ladoMayor = lado1;
			sumaMenores = lado2 + lado3;
		} else if (lado2 >= lado1 && lado2 >= lado3) {
			ladoMayor = lado2;
			sumaMenores = lado1 + lado3;
		} else {
			ladoMayor = lado3;
			sumaMenores = lado1 + lado2;
		}
		if (ladoMayor < sumaMenores) {
			if (lado1 == lado2 && lado2 == lado3) {
				System.out.println("El triángulo es equilátero");
			} else if (lado1 == lado2 || lado1 == lado3 || lado2 == lado3) {
				System.out.println("El triángulo es isósceles");
			} else {
				System.out.println("El triángulo es escaleno");
			}
		} else {
			System.out.println("No se puede formar un triángulo con lados de esas longitudes");
		}
	}

}
