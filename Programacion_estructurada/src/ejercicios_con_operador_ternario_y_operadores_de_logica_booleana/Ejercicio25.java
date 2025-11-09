package ejercicios_con_operador_ternario_y_operadores_de_logica_booleana;

import java.util.Scanner;

public class Ejercicio25 {

	//Escribe un programa que lea por teclado dos variables de tipo double para representar las notas
	//de un estudiante en dos asignaturas. Muestra en pantalla el mensaje “Muy bien” si el alumno
	//ha aprobado las dos asignaturas y la suma de las dos notas es al menos 14.
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("¿Qué nota sacaste en la asignatura A?");
		double asigA = scan.nextDouble();
		System.out.println("¿Qué nota sacaste en la asignatura B?");
		double asigB = scan.nextDouble();
		String congrats = ((asigA >= 5 && asigB >= 5) && (asigA + asigB >= 14)) ? "Muy bien" : "Puedes hacerlo mejor";
		System.out.println(congrats);
		scan.close();

	}

}
