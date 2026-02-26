package examen02_25112025;

import java.util.Scanner;

public class Ejercicio02 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce una cadena del tipo aaaabbbcc. No puedes repetir un caracter que ya se ha usado en un grupo de caracteres previamente");
		String cadena = scan.nextLine(); //La cadena que introduce el usuario
		String cadenaNueva = ""; //La cadena nueva que vamos a generar
		int i = 0;
		while (i < cadena.length()) { //Recorremos la cadena inicial
			int contador = 0; //El contador de cada caracter se inicializa a 0 para cada grupo de caracteres, por eso se mete dentro del bucle
			for (int j = 0; j < cadena.length(); j++) { //Para cada carcter de la cadena inicial,´iteramos sobre la cadena par contar cuántas veces aparece
				if (cadena.charAt(i) == cadena.charAt(j)) { //Fijarse que el caracter siempre empieza comparándose consigo mismo, por eso el contador
					                                        //siempre inicializa en 0, para contarse a sí mismo
					contador++;
				}
			}
			cadenaNueva += "" + cadena.charAt(i) + contador; //Concatenamos lo que tenemos de la nueva cadena en cada momento con el carácter que estamos
			                                                 //mirando en ese momento y con el número de veces que ha aparecido
			i += contador; //Avanzamos las posiciones en la cadena inicial hasta cambiar a un caracter diferente
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
