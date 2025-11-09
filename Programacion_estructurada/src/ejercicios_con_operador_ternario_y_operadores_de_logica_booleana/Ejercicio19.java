package ejercicios_con_operador_ternario_y_operadores_de_logica_booleana;

import java.util.Scanner;

public class Ejercicio19 {
	//Diseña un programa que lea de teclado tres variables numéricas para representar las notas de
	//tres asignaturas diferentes. Luego, muestra en pantalla un mensaje que indique si el estudiante
	//aprueba el curso o repite.
	//En este caso, voy a considerar como aprobado aprobar al menos 2 asignaturas
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce la nota que sacaste en la asignatura A");
		double asigA = scan.nextDouble();	
		System.out.println("Introduce la nota que sacaste en la asignatura B");
		double asigB = scan.nextDouble();
		System.out.println("Introduce la nota que sacaste en la asignatura C");
		double asigC = scan.nextDouble();
		boolean aprobA = asigA >= 5;
		boolean aprobB = asigB >= 5;
		boolean aprobC = asigC >= 5;
		String aprobCurso = ((aprobA && aprobB) || (aprobA && aprobC) || (aprobB && aprobC))?"Has aprobado el curso":"Has suspendido el curso";
		System.out.println(aprobCurso);
		scan.close();

	}

}
