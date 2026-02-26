package examen02_25112025;

import java.util.Scanner;

public class Ejercicio01 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num; //El número que vamos a leer por teclado
		System.out.println("Introduce un número positivo mayor que 1");
		while ((num = scan.nextInt()) <= 1) {
			System.out.println("Número no válido, debería ser mayor que 1");
		}
		int max = 0; //El máximo de nuestra secuencia. Lo inicializamos en 0, pues todos los números van a ser mayores que 1
		int i; //El contador de valores que va a tener nuestra secuencia
		System.out.print("Secuencia: ");
		for (i = 1; num > 1; i++) { //Quizá sería más adecuado usar un while, porque un for se asocia más a un recorrido de datos. Pero no estaría mal
			System.out.print(num + ", ");
			if (num % 2 == 0) {
				num /= 2;
			} else {
				num = num * 3 + 1;
			}
			if (num > max) {
				max = num;
			}
		}
		System.out.println();
		System.out.println("La longitud de la secuencia es: " + i++);
		System.out.println("El valor pico (máximo) ha sido: " + max);
		scan.close();

	}

}
