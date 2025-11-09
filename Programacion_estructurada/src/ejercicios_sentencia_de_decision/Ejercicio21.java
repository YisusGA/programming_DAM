package ejercicios_sentencia_de_decision;

/**
 * Pedir los coeficientes de una ecuación de 2° grado, y muestre sus soluciones reales. Si no existen debe indicarlo
 */

import java.util.Scanner;

public class Ejercicio21 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce un número entero para el valor de a");
		double a = scan.nextDouble();
		System.out.println("Introduce un número entero para el valor de b");
		double b = scan.nextDouble();
		System.out.println("Introduce un número entero para el valor de c");
		double c = scan.nextDouble();
		scan.close();
		double determinant = Math.pow(b, 2) - 4 * a * c;
		if (determinant < 0) {
			System.err.print("ERROR: No existen soluciones reales para x con los números introducidos");
			return;
		} else {
			/*
			 * Muchísimo cuidado aquí con la precedencia de los operadores. Si no ponemos los paréntesis en el 2 * a,
			 * primero se dividirá la parte de (-b + Math.sqrt(determinant)) entre 2 y luego se multiplicará por a
			 */
			double x1 = (-b + Math.sqrt(determinant)) / (2 * a);
			double x2 = (-b - Math.sqrt(determinant)) / (2 * a);
			System.out.println("Los dos valores de x son:");
			System.out.println("x1 = " + x1);
			System.out.println("x2 = " + x2);
		}

	}

}
