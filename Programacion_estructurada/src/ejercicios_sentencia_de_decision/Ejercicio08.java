package ejercicios_sentencia_de_decision;

import java.util.Scanner;

public class Ejercicio08 {
	
	//Realizar un programa que lea un número entero de 3 cifras, y forme el mayor número posible 
	//con las cifras del número ingresado. El número formado debe tener el mismo signo que el número ingresado

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce un número entero de 3 cifras");
		int n = scan.nextInt();
		int nPos1 = n / 100;
		int nPos2 = n / 10 - nPos1 * 10;
		//Otras 2 formas de sacar las decenas
		//int nPos2 = n % 100 / 10;
		//int nPos2 = n / 10 % 10;
		int nPos3 = n % 10;
		int nFinal = 1;
		if (n < 100 || n >999) {
			System.out.println("El número introducido no es válido");
		} else if (nPos1 > nPos2 && nPos1 > nPos3 && nPos2 > nPos3) {
			nFinal = nPos1 * 100 + nPos2 * 10 + nPos3;	
		} else if (nPos1 > nPos2 && nPos1 > nPos3 && nPos3 > nPos2) {
			nFinal = nPos1 * 100 + nPos3 * 10 + nPos2;
		} else {
			nFinal = nPos2 > nPos3 ? nPos2 * 100 + nPos3 * 10 + nPos1 : nPos3 * 100 + nPos2 * 10 + nPos1;
		}
		System.out.println("El mayor número posible que puede formarse con las cifras del número que has ingresado es: " + nFinal);
	}

}
