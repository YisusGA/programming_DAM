package ejercicios_sentencia_de_decision;

import java.util.Scanner;

public class Ejercicio07_3 {
	
	//Realizar un programa que lea tres números enteros e indique cuál es el mayor de los tres

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce un número entero");
		int n1 = scan.nextInt();
		System.out.println("Introduce otro número entero");
		int n2 = scan.nextInt();
		System.out.println("Introduce un tercer número entero");
		int n3 = scan.nextInt();
		scan.close();
		//Comenzamos asumiendo que el número mayor de los introducidos es n1
		int mayor = n1;
		//Si n2 > mayor, entonces se hace la asignación de mayor = n2. n2 se convertiría en el nuevo valor de mayor
		if (n2 > mayor) {
			mayor = n2;	
		} 
		//Si n3 > mayor, entonces se hace la asignación de mayor = n3. n3 se convertiría en el nuevo valor de mayor
		if (n3 > mayor) {
			mayor = n3;	
		}	
		//Si no se cumplen ninguno de las condiciones if anteriores, entonces la asignación de mayor es la que se hizo inicialmente:
		//mayor = n1. Finalmente, imprimimos el valor final con el que se ha quedado la variable mayor
		System.out.println("El número mayor es: " + mayor);
	}

}
