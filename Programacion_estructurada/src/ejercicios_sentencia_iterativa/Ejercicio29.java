package ejercicios_sentencia_iterativa;

import java.util.Scanner;

public class Ejercicio29 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce un número positivo mayor que 0");
		int n = scan.nextInt();
		while (n <= 0) {
			System.out.println("Número no válido, prueba de nuevo");
			n = scan.nextInt();
		}
		scan.close();
		int num = 0;
		for (int i = 0; i < n + 2; i++) {
			for (int j = 1; j < i; j++) { 
				System.out.print(j + " ");
			}
			System.out.println();
		}
		
	}

}
