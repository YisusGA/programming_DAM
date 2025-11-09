package ejercicios_con_operador_ternario_y_operadores_de_logica_booleana;

import java.util.Scanner;

public class Ejercicio18 {
	//Diseña un programa que lea de teclado dos variables booleanas para representar si un
	//estudiante aprobó dos asignaturas diferentes. Luego, muestra en pantalla un mensaje que
	//indique si el estudiante aprueba el curso o repite.
	//He decidido que para aprobar el curso, hay que aprobar ambas asignaturas
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("¿Aprobaste la asignatura A?. Introduce true si la aprobaste o false si la suspendiste");
		boolean asigA = scan.nextBoolean();	
		System.out.println("¿Aprobaste la asignatura B?. Introduce true si la aprobaste o false si la suspendiste");
		boolean asigB = scan.nextBoolean();
		String aprobCurso = (asigA && asigB)?"Has aprobado el curso":"Has suspendido el curso";
		System.out.println(aprobCurso);
		scan.close();
		

	}

}
