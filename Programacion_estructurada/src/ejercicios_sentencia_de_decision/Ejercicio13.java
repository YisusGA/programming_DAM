package ejercicios_sentencia_de_decision;

import java.util.Scanner;

public class Ejercicio13 {

	//Recibir un número entre 1 y 7 e indicar a qué día de la semana corresponde
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce un número entero comprendido entre 1 y 7");
		int n = scan.nextInt();
		scan.close();
		if (n < 1 || n > 7) {
			System.out.println("El número introducido no es válido");
		} else {
			if (n == 1) {
				System.out.println("El número se corresponde al Lunes");
			} else if (n == 2) {
				System.out.println("El número se corresponde al Martes");
			} else if (n == 3) {
				System.out.println("El número se corresponde al Miércoles");
			} else if (n == 4) {
				System.out.println("El número se corresponde al Jueves");
			} else if (n == 5) {
				System.out.println("El número se corresponde al Viernes");
			} else if (n == 6) {
				System.out.println("El número se corresponde al Sábado");
			} else {
				System.out.println("El número se corresponde al Domingo");
			}
		}	

	}

}
