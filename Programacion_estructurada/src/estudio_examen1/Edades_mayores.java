package estudio_examen1;

/**
 * Programa que solicite dos nombres de persona y sus edades, a continuación debe mostrar:
 * "El mayor de los dos es: nombre”. Si ambos tienen la misma edad, mostrarlo.
 */

import java.util.Scanner;

public class Edades_mayores {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce el nombre de la primera persona");
		String nombre1 = scan.nextLine();
		System.out.println("Introduce el nombre de la segunda persona");
		String nombre2 = scan.nextLine();
		System.out.println("Introduce la edad de la primera persona");
		int edad1 = scan.nextInt();
		System.out.println("Introduce la edad de la segunda persona");
		int edad2 = scan.nextInt();
		scan.close();
		String mayor = edad1 == edad2 ? "Ambos tienen la misma edad" : edad1 > edad2 ? nombre1 : nombre2;
		System.out.println("El mayor de los dos es: " + mayor);

	}

}
