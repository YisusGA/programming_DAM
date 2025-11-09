package ejercicios_sentencia_de_decision;

import java.util.Scanner;

/**
 * Pedir una nota numérica entera entre 0 y 10, y mostrar suspenso para [0-4], bien para [5-6], notable para [7-8], y sobresaliente para [9-10]
 */
public class Ejercicio24 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce un número entero comprendido entre 0 y 10");
		int nota = scan.nextInt();
		scan.close();
		if (nota<0 || nota > 10) {
			System.err.print("ERROR: El número introducido no es válido");
			return;
		} else {
			switch (nota) {
			/*
			 * Como se observa en este caso, en las nuevas versiones de JAVA, se pueden agrupar valores en un case si se separan con comas.
			 * Esto no va a funcionar en versiones más antiguas de JAVA. Es algo a tener en cuenta, dado que la versión más usada de JAVA es
			 * la 1.8, porque es la más estable, y no admite este tipo de uso moderno del case.
			 */
			case 0, 1, 2, 3, 4:
				System.out.println("Suspenso");
				break;
			case 5, 6:
				System.out.println("Bien");
				break;
			case 7, 8:
				System.out.println("Notable");
				break;
			case 9, 10:
				System.out.println("Sobresaliente");
				break;
			}
		}
	}

}
