package examen_1ev_24_25;

import java.util.Scanner;

public class Ejercicio01 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce un número entero positivo");
		int num;
		while((num = scan.nextInt()) < 0) {
			System.err.println("El número introducido no es válido, debe ser mayor o igual que 0");
		}
		int suma = 0;
		int contador = 0;
		if (num < 100 && num % 2 == 0) {
			for (int i = ++num; i < 100; i += 2) {
				suma += i;
				contador++;
			}
		} else if (num < 100) {
			for (int i = num; i < 100; i += 2) {
				suma += i;
				contador++;
			}
		} else if (num % 2 == 0) {
			for (int i = 100; i <= num; i += 2) {
				suma += i;
				contador++;
			}
		} else {
			for (int i = 100; i < num; i += 2) {
				suma += i;
				contador++;
			}
		}
		System.out.println("La media da como resultado: " + (double)suma / contador++);
		scan.close();

	}

}
