package ejercicios_sobre_variables_y_lectura_por_teclado;

import java.util.Scanner;

public class Ejercicio12 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Haz click en la consola e introduce el número de unidades vendidas");
		int unidades = scan.nextInt();
		System.out.println("Haz click en la consola e introduce un número decimal con coma indicando el precio por unidad");
		double precio = scan.nextDouble();
		scan.close();
		double montoVentas = unidades * precio;
		System.out.println("El monto total de ventas es: " + montoVentas + " €");

	}

}
