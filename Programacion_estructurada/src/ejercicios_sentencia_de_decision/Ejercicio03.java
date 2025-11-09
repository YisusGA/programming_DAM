package ejercicios_sentencia_de_decision;

import java.util.Scanner;

public class Ejercicio03 {

	//Realizar un programa que dado un número entero indique si es o no par
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce un número entero");
		int n = scan.nextInt();
		if (n % 2 == 0) {
			System.out.println("El número introducido es par");
		} else {
			System.out.println("El número introducido es impar");
		}
		scan.close();
	}

}
