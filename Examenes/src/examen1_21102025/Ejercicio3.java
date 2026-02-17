package examen1_21102025;

import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Introduce el peso del paquete que quieres enviar");
		double peso = scan.nextDouble();
		System.out.println("Introduce el código de la zona de destino: 1, 2, 3 o 4");
		int zona = scan.nextInt();
		scan.close();
		if (zona != 1 && zona != 2 && zona != 3 && zona != 4) {
			System.err.print("Error: el código de zona introducido no es válido");
			System.exit(0);
		}
		double precioBase = 5.5 * peso;
		double suplemento = 0;
		switch (zona) {
		case 2:
			suplemento = precioBase * 0.1;
			break;
		case 3:
			suplemento = precioBase * 0.25;
			break;
		case 4:
			suplemento = precioBase * 0.4;
			break;
		}
		double precioFinal = precioBase + suplemento;
		System.out.println("El precio base es: " + precioBase + "€");
		System.out.println("El suplemento aplicado es: " + suplemento + "€");
		System.out.println("El precio final es: " + precioFinal + "€");

	}

}

