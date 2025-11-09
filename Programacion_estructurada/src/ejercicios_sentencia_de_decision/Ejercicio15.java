package ejercicios_sentencia_de_decision;

import java.util.Scanner;

public class Ejercicio15 {

	//Recibir un numero entre 1 y 99 e indicar si su decena es un número par o impar
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce un número entero entre 1 y 99");
		int n = scan.nextInt();
		scan.close();
		if (n < 1 || n > 99) {
			System.out.println("El número introducido no es válido");
		} else {
			if (n > 1 && n < 10) {
				if (n % 2 == 0) {
					System.out.println("El número está comprendido entre 1 y 9 y es par");
				} else {
					System.out.println("El número está comprendido entre 1 y 9 y es impar");
				}
			} else {
				int nDecena = n / 10;
				if (nDecena % 2 == 0) {
					System.out.println("La decena del número introducido es par");
				} else {
					System.out.println("La decena del número introducido es impar");
				}
			}
		}
		

	}

}
