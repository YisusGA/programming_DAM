package ejercicios_sentencia_de_decision;

import java.util.Scanner;

public class Ejercicio16 {

	//Recibir un numero entre 1 y 99 e indicar si su decena es un número primo o no. 
	//(pero con un algoritmo diverso del que has usado en el ejercicio 4)
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce un número entero entre 1 y 99");
		int n = scan.nextInt();
		scan.close();
		if (n < 1 || n > 99) {
			System.out.println("El número introducido no es válido");
		} else {
			if (n > 1 && n < 10) {
                //CUIDADO: EL 1 NO ES PRIMO, ESTO ES UN AXIOMA DE LAS MATEMÁTICAS				
				if (n == 2 || n == 3 || n == 5 || n == 7) {
					System.out.println("El número está comprendido entre 1 y 9 y es primo");
				} else {
					System.out.println("El número está comprendido entre 1 y 9 y no es primo");
				}
			} else {
				int nDecena = n / 10;
				if (nDecena == 1 || nDecena == 2 || nDecena == 3 || nDecena == 5 || nDecena == 7 || nDecena == 9) {
					System.out.println("La decena del número introducido es primo");
				} else {
					System.out.println("La decena del número introducido no es primo");
				}
			}
		}

	}

}
