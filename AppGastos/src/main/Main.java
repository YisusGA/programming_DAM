package main;

import java.io.IOException;
import java.util.Scanner;

import dataAccess.Datos;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int op;
		do {
			System.out.println("""
					1. Añadir gasto para día y mes
					2. Ver gastos de un mes
					3. Día de más gasto en un mes
					0. Salir
					""");
			op = Integer.parseInt(scan.nextLine()); // parseInt para que no nos den problemas los saltos de línea
			switch(op) {
			case 1 -> {
				System.out.println("Mes: ");
				String mes = scan.nextLine();
				System.out.println("Día: ");
				int dia = Integer.parseInt(scan.nextLine());
				System.out.println("Gasto: ");
				double gasto = Double.parseDouble(scan.nextLine());
				try {
					Datos.addGasto(mes, dia, gasto);
					System.out.println("Gasto añadido");
				} catch (IOException e) {
					System.err.println("No pudo añadirse el gasto");
					e.printStackTrace();
				}
				
			}
			case 2 -> {
				System.out.println("Mes a consultar");
				String mes = scan.nextLine();
				System.out.println(Datos.gastosMes(mes));
			}
			case 3 -> {
				System.out.println("Mes a consultar");
				String mes = scan.nextLine();
				System.out.println(Datos.diaMayorGasto(mes));
			}
			case 0 -> {
				System.out.println("Cerrando programa...");
			}
			default -> {
				System.err.println("Opción no válida");
			}
			}
		} while(op != 0);

	}

}
