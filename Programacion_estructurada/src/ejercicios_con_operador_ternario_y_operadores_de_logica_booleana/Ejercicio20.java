package ejercicios_con_operador_ternario_y_operadores_de_logica_booleana;

import java.util.Scanner;

public class Ejercicio20 {
	//Escribe un programa que lea por teclado dos variables de tipo double para representar las
	//calificaciones de un estudiante en dos asignaturas. Muestra en pantalla un mensaje que indique
	//si el estudiante aprobó al menos una de ellas

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce la nota que sacaste en la asignatura A");
		double asigA = scan.nextDouble();	
		System.out.println("Introduce la nota que sacaste en la asignatura B");
		double asigB = scan.nextDouble();
		String aprob = ((asigA >= 5) || (asigB >= 5))?"Has aprobado al menos una asignatura":"No has aprobado ninguna asignatura";
		System.out.println(aprob);
		scan.close();
	}

}
