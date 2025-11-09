package ejercicios_sentencia_de_decision;

import java.util.Scanner;

public class Ejercicio07_2 {

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
		
		int mayor = n1;
		if (n2 > mayor)
		
		if (n1 > n3 && n1 > n2) {
			System.out.println("El número mayor es: " + n1);
		} else if (n2 > n3) {
			System.out.println("El número mayor es: " + n2); 
		}
		else {
			System.out.println("El número mayor es: " + n3);
		}
	}

}
