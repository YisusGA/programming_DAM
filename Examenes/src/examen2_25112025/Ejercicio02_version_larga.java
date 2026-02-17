package examen2_25112025;

import java.util.Scanner;

public class Ejercicio02_version_larga {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce una cadena del tipo aaaabbbcc. No puedes repetir un caracter que ya se ha usado en un grupo de caracteres previamente");
		String cadena = scan.nextLine(); //La cadena que introduce el usuario
		String cadenaNueva = ""; //La cadena nueva que vamos a generar
		char[] caracteres = new char[cadena.length()];
		for (int i = 0; i < caracteres.length; i++) {
			caracteres[i] = cadena.charAt(i);
		}
		for (int i = 0; i < caracteres.length; i++) {
			int contador = 0;
			for (int j = i; j < caracteres.length; j++) { //La j se puede inicializar en i o en 0. Hacer lo primero, ahorra iteraciones
				if (caracteres[i] == caracteres[j]) {
					contador++;
				}
			}
			cadenaNueva += caracteres[i] + "" + contador;
			i += contador - 1; //Restamos 1 porque la i se nos incrementa 1 como salida del bucle, y no queremos eso. Yo solucioné esto con un while
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
