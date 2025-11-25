package examen2_25112025;

import java.util.Scanner;

public class Ejercicio02 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce una cadena del tipo aaaabbbcc. No puedes repetir un caracter que ya se ha usado en un grupo de caracteres previamente");
		String cadena = scan.nextLine();
		String cadenaNueva = ""; 
		int i = 0;
		while (i < cadena.length()) {
			int contador = 0;
			for (int j = 0; j < cadena.length(); j++) {
				if (cadena.charAt(i) == cadena.charAt(j)) {
					contador++;
				}
			}
			cadenaNueva += "" + cadena.charAt(i) + contador;
			i += contador;
		}
		System.out.print("El resultado a mostrar es: ");
		if (cadenaNueva.length() > cadena.length()) {
			System.out.println(cadena);
		} else {
			System.out.println(cadenaNueva);
		}
		scan.close();
	}

}
