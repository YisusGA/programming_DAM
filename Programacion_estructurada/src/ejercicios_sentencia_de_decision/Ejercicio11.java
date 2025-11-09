package ejercicios_sentencia_de_decision;

import java.util.Scanner;

public class Ejercicio11 {

	//Recibir 4 números enteros e indicar el más pequeño y el más grande
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
		int maximo = n1;
		int minimo = n1;
		if (n2 > n1) {
			maximo = n2;
		}
		if (n3 > n1) {
			maximo = n3;
		}
		if (n4 > n1) {
			maximo = n4;
		}
		if (n2 < n1) {
			minimo = n2;
		}
		if (n3 < n1) {
			minimo = n3;
		}
		if (n4 < n1) {
			minimo = n4;
		}
		System.out.println("El menor número es: " + minimo);
		System.out.println("El mayor número es: " + maximo);
	}
}

