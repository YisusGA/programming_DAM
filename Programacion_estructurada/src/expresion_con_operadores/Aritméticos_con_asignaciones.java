package expresion_con_operadores;
import java.util.Scanner;

public class Aritméticos_con_asignaciones {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduzca número de usuarios");
		int numUsers = scan.nextInt();
		
		System.out.println("¿Cuántos usuarios nuevos han llegado?");
		int numNuevos = scan.nextInt();
		
		numUsers = numUsers + numNuevos;
		//Otra forma de escribirlo sería:
		//numUsers += numNuevos;
		//Si queremos una resta:
		//numUsers -= numNuevos;
		//Funciona con * y / también
		//El caso de debajo da error porque es obligatorio que en el lado izquierdo de la expresión += tiene que 
		//haber una variable, no un número suelto
		//int num3 = 2 += 3;
		
		System.out.println("El número de usuarios es: " + numUsers);
		scan.close();

	}

}
