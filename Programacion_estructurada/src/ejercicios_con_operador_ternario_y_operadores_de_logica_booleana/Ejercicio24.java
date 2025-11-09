package ejercicios_con_operador_ternario_y_operadores_de_logica_booleana;

import java.util.Scanner;

public class Ejercicio24 {

	//Crea un programa que lea por teclado dos variables enteras para representar las edades de dos
	//personas. Muestra en pantalla un mensaje que indique si el grupo de 2 personas “Pueden acceder” o no. El acceso es
	//permitido a personas de mayor de 18 o a personas mayores de 21 que acompañen a un menor
	//de edad.
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce la edad de la primera persona");
		int edad1 = scan.nextInt();
		System.out.println("Introduce la edad de la segunda persona");
		int edad2 = scan.nextInt();
		String pasar = ((edad1 >= 18) && (edad2 >= 18)) || (((edad1 >= 21) || (edad2 >= 21))) ? "Podéis pasar" : "No podéis pasar";
		System.out.println(pasar);
		scan.close();

	}

}
