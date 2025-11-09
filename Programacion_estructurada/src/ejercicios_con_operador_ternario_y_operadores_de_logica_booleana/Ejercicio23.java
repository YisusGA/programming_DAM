package ejercicios_con_operador_ternario_y_operadores_de_logica_booleana;

import java.util.Scanner;

public class Ejercicio23 {

	//Escribe un programa que lea por teclado tres variables enteras para representar las horas
	//trabajadas en tres días diferentes. Muestra en pantalla un mensaje que indique si la persona
	//trabajó entre 8 y 20 horas en los tres días o no.
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("¿Cuántas  horas has trabajado el lunes?");
		int h1 = scan.nextInt();
		System.out.println("¿Cuántas  horas has trabajado el martes?");
		int h2 = scan.nextInt();
		System.out.println("¿Cuántas  horas has trabajado el miércoles?");
		int h3 = scan.nextInt();
		String print = (((h1 + h2 + h3) > 8) && ((h1 +h2 + h3) < 20)) ? "Has trabajado entre 8 y 20 horas":"No has trabajado entre 8 y 20 horas";
		System.out.println(print);
		scan.close();

	}

}
