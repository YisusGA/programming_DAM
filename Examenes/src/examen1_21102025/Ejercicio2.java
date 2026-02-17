package examen1_21102025;

import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce tu edad");
		int edad = scan.nextInt();
		String trash = scan.nextLine();
		System.out.println("¿Qué tipo de entrada tienes: VIP, Prensa o General?");
		String tipoEntrada = scan.nextLine();
		scan.close();
		boolean permisoEntrada = true;
		boolean entradaValida = tipoEntrada.equals("VIP") || tipoEntrada.equals("Vip") || tipoEntrada.equals("vip") || tipoEntrada.equals("Prensa") || tipoEntrada.equals("prensa") || tipoEntrada.equals("General") || tipoEntrada.equals("general");
		if (!entradaValida) {
			System.out.println("Tipo de entrada no válido");
			System.exit(0);
		}
		if (tipoEntrada.equals("VIP") || tipoEntrada.equals("Vip") || tipoEntrada.equals("vip")) {
			permisoEntrada = true;
		} else if (tipoEntrada.equals("Prensa") || tipoEntrada.equals("prensa")) {
			permisoEntrada = edad >= 18 ? true : false;
		} else {
			permisoEntrada = false;
		}
		if (permisoEntrada) {
			System.out.println("Puedes acceder a la zona VIP");
		} else {
			System.out.println("No puedes acceder a la zona VIP");
		}

	}

}

