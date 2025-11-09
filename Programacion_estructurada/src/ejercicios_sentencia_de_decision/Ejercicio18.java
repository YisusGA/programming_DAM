package ejercicios_sentencia_de_decision;

import java.util.Scanner;

public class Ejercicio18 {
	//Realizar un programa que lea dos números y los muestre ordenados de menor a mayor, 
	//usa un algoritmo diferente que en el ejercicio 6

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce un número entero");
		int n1 = scan.nextInt();
		System.out.println("Introduce otro número entero");
		int n2 = scan.nextInt();
		scan.close();
		if ((n1 / n2) > 0) {
			System.out.println("n1: " + n1 + " > " + "n2: " + n2);	
		} else {
			System.out.println("n2: " + n2 + " > " + "n1: " + n1);
		}
	}

}

