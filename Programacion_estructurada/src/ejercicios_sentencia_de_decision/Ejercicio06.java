package ejercicios_sentencia_de_decision;

import java.util.Scanner;

public class Ejercicio06 {
	//Realizar un programa que lea dos números y los muestre ordenados de menor a mayor

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce un número entero");
		int n1 = scan.nextInt();
		System.out.println("Introduce otro número entero");
		int n2 = scan.nextInt();
		if (n1 > n2) {
			System.out.println("n1: " + n1 + " > " + "n2: " + n2);	
		} else {
			System.out.println("n2: " + n2 + " > " + "n1: " + n1);
		}
		scan.close();

	}

}
