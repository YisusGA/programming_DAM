package estudio_examen1;

/**
 * Diseña un programa que lea de teclado tres variables numéricas para representar las notas de
 * tres asignaturas diferentes. Luego, muestra en pantalla si se pasa limpio, se pasa con una pendiente 
 * o se repite. En este caso, voy a considerar como pasar aprobar al menos 2 asignaturas
 */

import java.util.Scanner;

public class Ejercicio19mod_op_tern_op_log_bool {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce la nota de la asigatura 1");
		double nota1 = scan.nextDouble();
		System.out.println("Introduce la nota de la asigatura 2");
		double nota2 = scan.nextDouble();
		System.out.println("Introduce la nota de la asigatura 3");
		double nota3 = scan.nextDouble();
		scan.close();
		if (nota1 >= 5 && nota2 >= 5 && nota3 >= 5) {
			System.out.println("Pasas limpio");
		} else if ((nota1 >= 5 && nota2 >= 5) || (nota1 >= 5 && nota3 >= 5) || (nota2 >= 5 && nota3 >= 5)) {
			System.out.println("Pasas con una pendiente");
		} else {
			System.out.println("Repites curso");
		}
	}

}
