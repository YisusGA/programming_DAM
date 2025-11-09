package ejercicios_sentencia_de_decision;

import java.util.Scanner;

public class Ejercicio12 {

	//Recibir 4 números enteros e indicar si son todos el mismo número
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce un número");
		int n1 = scan.nextInt();
		System.out.println("Introduce un segundo número");
		int n2 = scan.nextInt();
		System.out.println("Introduce un tercer número");
		int n3 = scan.nextInt();
		System.out.println("Introduce un cuarto número");
		int n4 = scan.nextInt();
		scan.close();
		if (n1 == n2 && n2 == n3 && n3 == n4) {
			System.out.println("Los 4 números son iguales");
		} else {
			System.out.println("No todos los números son el mismo número");
		}

	}

}
