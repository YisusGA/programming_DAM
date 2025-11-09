package ejercicios_sentencia_de_decision;

import java.util.Scanner;

public class Ejercicio05 {

	//Realizar un programa que lea un número entero de tres cifras e 
	//indique si se lee igual de izquierda a derecha que de derecha a izquierda
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce un número entero de 3 cifras");
		int n = scan.nextInt();
		int nPos1 = n / 100;
		int nPos3 = n % 10;
		if (n < 100 || n >999) {
			System.out.println("El número introducido no es válido");
		} else {
			String print = nPos1 == nPos3 ? "El número es capicúa" : "El número no es capicúa";
			System.out.println(print);		
		}
		scan.close();
	}

}
