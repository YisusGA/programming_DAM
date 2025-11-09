package estudio_examen1;

/**
 * Programa para dejar pasar a alguien sólo si es mayor de edad o si tiene al menos 16 años y tiene un permiso paterno
 */

import java.util.Scanner;

public class Entrar_discoteca {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce tu edad");
		int edad = scan.nextInt();
		String trash = scan.nextLine();
		if (edad >= 18) {
			System.out.println("Puedes pasar");
		} else if (edad >= 16) {
			System.out.println("Tienes permiso paterno");
			String permiso = scan.nextLine();
			String pasarPermiso = permiso.equals("Sí") || permiso.equals("Si") || permiso.equals("sí") || permiso.equals("si") ? "Puedes pasar" : "No puedes pasar";
			System.out.println(pasarPermiso);
		} else {
			System.out.println("No puedes pasar");
		}
		scan.close();
	}

}
