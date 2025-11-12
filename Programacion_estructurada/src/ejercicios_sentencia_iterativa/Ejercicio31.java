package ejercicios_sentencia_iterativa;

import java.util.Scanner;

public class Ejercicio31 {

	public static void main(String[] args) {
		Scanner scan =  new Scanner(System.in);
		System.out.println("Introduce un número de líneas");
		int N = scan.nextInt();
		String linea = "X ";
		for (int i = 1; i <= N; i++) {
			linea += i + "  ";
		}	
		System.out.println(linea);
		for (int i = 1; i <= N; i++) {
			linea = "";
			linea += i + " ";
			for (int j = i; j < i + N * i; j += i) {
				linea += j + "  ";
			}
			System.out.println(linea);
		}
	}

}
