package ejercicios_arrays;

/**
 * Leer por teclado una serie de 6 números. Una vez insertados todos, leer un nuevo número e indicar cuántos elementos del array son mayores al valor dado
 */
import java.util.Scanner;

public class Ejercicio11 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] numeros = new int[6];
		for (int i = 0; i < 6; i++) {
			System.out.println("Introduce un número entero");
			numeros[i] = scan.nextInt();
		}
		System.out.println("Introduce el número comprobador");
		int comprobador = scan.nextInt();
		int contadorMayores = 0;
		for (int i = 0; i < 6; i++) {
			if (numeros[i] > comprobador) {
				contadorMayores++;
			}
		}
		System.out.println(contadorMayores + " números del array son mayores que " + comprobador);
	}

}
