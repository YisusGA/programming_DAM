package ejercicios_con_operador_ternario_y_operadores_de_logica_booleana;

import java.util.Scanner;

public class Ejercicio21 {

	//Crea un programa que lea por teclado tres variables enteras para representar las edades de tres
	//personas. Muestra en pantalla un mensaje que indique si al menos dos de ellas son mayores de
	//21 años
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce la edad de la personsa A");
		int edadA = scan.nextInt();	
		System.out.println("Introduce la edad de la personsa B");
		int edadB = scan.nextInt();
		System.out.println("Introduce la edad de la personsa C");
		int edadC = scan.nextInt();
		String edades = (((edadA >= 21) && (edadB >= 21)) || ((edadA >= 21) && (edadC >= 21)) || ((edadB >= 21) && (edadC >= 21)))?"Al menos 2 personas tienen 21 años":"Menos de 2 personas tienen menos de 21 años";
		System.out.println(edades);
		scan.close();

	}

}
