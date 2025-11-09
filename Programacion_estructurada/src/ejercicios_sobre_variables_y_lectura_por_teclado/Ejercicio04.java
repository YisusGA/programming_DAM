package ejercicios_sobre_variables_y_lectura_por_teclado;

import java.util.Scanner;

public class Ejercicio04 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("¿Eres mayor de edad?");
		System.out.println("Haz click en la consola e introduce tu edad para descubrirlo");
		int edad = scan.nextInt();
		scan.close();
		boolean mayorDeEdad = edad >= 18;
		System.out.println("Eres mayor de edad: " + mayorDeEdad);

	}

}
