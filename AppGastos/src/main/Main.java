package main;

import java.io.IOException;
import java.util.InputMismatchException;
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
					4. Eliminar día
					5. Mes con mayor gasto
					6. Listar gastos de un mes
					0. Salir
					""");
			op = Integer.parseInt(scan.nextLine()); // parseInt para que no nos den problemas los saltos de línea
			switch (op) {
			case 1 -> {
				System.out.println("Mes: ");
				String mes = scan.nextLine();
				boolean diaValido = false;
				int dia = 0;
				while (!diaValido) {
					try {
						System.out.println("Día a añadir el gasto");
						dia = Integer.parseInt(scan.nextLine());
						diaValido = true;
					} catch (NumberFormatException e) {
						System.err.println("Día no válido, prueba de nuevo");
//						e.printStackTrace();
					}
				}
				boolean gastoValido = false;
				double gasto = 0;
				while (!gastoValido) {
					try {
						System.out.println("Gasto a añadir");
						gasto = Double.parseDouble(scan.nextLine());
						gastoValido = true;
					} catch (NumberFormatException e) {
						System.err.println("Gasto no válido, prueba de nuevo");
//						e.printStackTrace();
					}
				}
				try {
					Datos.addGasto(mes, dia, gasto);
					System.out.println("Gasto añadido");
				} catch (IOException e) {
					System.err.println("No pudo añadirse el gasto");
//					e.printStackTrace();
				}

			}
			case 2 -> {
				System.out.println("Mes a consultar");
				String mes = scan.nextLine();
				try {
					System.out.printf("%n%nLos gastos del mes de %s fueron %.2f%n%n", mes, Datos.gastosMes(mes));
				} catch (IOException e) {
					System.err.println("No pudo hacerse la consulta");
//					e.printStackTrace();
				}
			}
			case 3 -> {
				System.out.println("Mes a consultar");
				String mes = scan.nextLine();
				try {
					int dia = Datos.diaMayorGasto(mes);
					if (dia != 0) {
						System.out.printf("%n%nEl día de mayor gasto del mes de %s fue el %d%n%n", mes, dia);
					} else {
						System.err.println("No pudo hacerse la consulta");
					}
				} catch (IOException e) {
					System.err.println("No pudo hacerse la consulta");
//					e.printStackTrace();
				}
			}
			case 4 -> {
				System.out.println("Mes a consultar");
				String mes = scan.nextLine();
				boolean diaValido = false;
				int dia = 0;
				while (!diaValido) {
					try {
						System.out.println("Día a eliminar");
						dia = Integer.parseInt(scan.nextLine());
						diaValido = true;
					} catch (NumberFormatException e) {
						System.err.println("Día no válido, prueba de nuevo");
//						e.printStackTrace();
					}
				}
				boolean eliminado = false;
				try {
					eliminado = Datos.eliminarDia(mes, dia);
				} catch (IOException e) {
					System.err.println("No se pudo eliminar ese día");
//					e.printStackTrace();
				}
				if (eliminado) {
					System.out.println("Día eliminado con éxito");
				} else {
					System.out.println("No se pudo eliminar ese día");
				}
			}
			case 5 -> {
				try {
					System.out.println(Datos.mesMayorGasto());
				} catch (IOException e) {
					System.err.println("No pudo hacerse la consulta");
//					e.printStackTrace();
				}
			}
			case 6 -> {
				System.out.println("Mes a consultar");
				String mes = scan.nextLine();
				try {
					String result = Datos.listadoGastosMes(mes);
					if (result != null) {
						System.out.println(result);
					} else {
						System.err.println("No se pudo hacer la consulta");
					}
				} catch (IOException e) {
					System.err.println("No pudo hacerse la consulta");
//					e.printStackTrace();
				}
			}
			case 0 -> {
				System.out.println("Cerrando programa...");
			}
			default -> {
				System.err.println("Opción no válida");
			}
			}
		} while (op != 0);
		scan.close();

	}

}
