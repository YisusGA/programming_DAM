package ejercicios_sentencia_de_decision;

import java.util.Scanner;

public class Ejercicio01 {
	//Realizar un programa que dados dos números enteros leídos 
	//por teclado, diga si alguno de los dos es múltiplo de otro
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce un número entero");
		int n1 = scan.nextInt();
		System.out.println("Introduce otro número entero");
		int n2 = scan.nextInt();
		if (n1 % n2 == 0 || n2 % n1 == 0) {
			System.out.println("Un número es múltiplo del otro");	
		} else {
			System.out.println("Ningun número es múltiplo del otro");
		}
		System.out.println("Adiós");
		scan.close();
	}

}
