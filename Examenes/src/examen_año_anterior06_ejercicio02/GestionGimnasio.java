package examen_año_anterior06_ejercicio02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class GestionGimnasio {
	public static List<Abonado> abonados = new ArrayList<>();
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Introduce el máximo de actividades permitidas para un usuario regular");
		AbonadoRegular.maximoActividades = scan.nextInt();
		int opcion;
		do {
			opcion = mostrarMenu();
			scan.nextLine(); // Descartamos línea vacía

			switch (opcion) {
			case 1 -> {
				System.out.println("Introduce el nombre del abonado");
				String nombre = scan.nextLine();
				String nif;
				boolean existe;
				do {
					existe = false;
					System.out.println("Introduce el nif del abonado, no debe existir uno igual");
					nif = scan.nextLine();
					for (Abonado i : abonados) {
						if (i.getNif().equalsIgnoreCase(nif)) {
							existe = true;
						}
					}
				} while (existe);
				TipoAbonado tipo;
				do {
					System.out.println("Introduce el tipo de abonado: REGULAR o VIP");
					tipo = TipoAbonado.devolverTipoAbonado(scan.nextLine());
				} while (tipo == null);

				switch (tipo) {
				case REGULAR -> {
					abonados.add(new AbonadoRegular(nif, nombre, tipo));
				}
				case VIP -> {
					abonados.add(new AbonadoVIP(nif, nombre, tipo));
				}
				}
				System.out.println("Nuevo abonado registrado");

			}
			case 2 -> {
				if (abonados != null && abonados.size() > 0) {
					int index = -1;
					do {
						System.out.println("Introduce el nif del abonado, debe existir");
						String nif = scan.nextLine();
						boolean encontrado = false;
						for (int i = 0; !encontrado && i < abonados.size(); i++) {
							if (abonados.get(i).getNif().equalsIgnoreCase(nif)) {
								index = i;
							}
						}
					} while (index < 0);
					Abonado abonado = abonados.get(index);
					Actividad actividad = new Actividad();
					System.out.println("Introduce el nombre de la actividad");
					actividad.setNombre(scan.nextLine());
					System.out.println("Introduce la cuota mensual de la actividad");
					actividad.setCuota(scan.nextDouble());
					scan.nextLine();
					System.out.println(
							"Introduce, uno por uno, los días de la semana en los que tiene lugar la actividad");
					System.out.println("Valores admitidos: L M X J V S D");
					System.out.println("Introduce STOP cuando quieras parar");
					String input;
					int num = 0;
					do {
						input = scan.nextLine().toUpperCase();
						if (!input.equalsIgnoreCase("STOP")) {
							actividad.getDiasSemana().add(input.charAt(0));
							num++;
						}
					} while (!input.equalsIgnoreCase("STOP") && num < 7);
					if (abonado.registrarActvidad(actividad)) {
						System.out.println("Actividad registrada con éxito");
					} else {
						System.err.println("La actividad no pudo registrarse porque ya existe o porque el abonado regular ha alcanzado el máximo de actividades permitidas");
					}
				} else {
					System.err.println("No existen abonados registrados");
				}

			}
			case 3 -> {
				if (abonados != null && abonados.size() > 0) {
					double result = 0;
					for (Abonado i : abonados) {
						if (i instanceof AbonadoRegular) {
							result += i.getImporteTotalCuotas();
						}
					}
					System.out.printf(
							"El importe total que se ingresa port todos los abonados regulares es %.2f euros%n",
							result);
				} else {
					System.err.println("No existen abonados registrados");
				}

			}
			case 4 -> {
				if (abonados != null && abonados.size() > 0) {
					System.out.println("Introduce el día de la semana. Valores admitidos: L M X J V S D");
					char dia = scan.nextLine().toUpperCase().charAt(0);
					List<Abonado> regulares = new LinkedList<>();
					List<Abonado> vip = new LinkedList<>();
					for (Abonado i : abonados) {
						for (Actividad a : i.getActividades()) {
							if (a.getDiasSemana().contains(dia)) {
								if (i instanceof AbonadoRegular) {
									regulares.add(i);
								} else {
									vip.add(i);
								}
							}
						}
					}
					System.out.println("Los siguientes abonados regulares tienen clases el día " + dia);
					for (Abonado i : regulares) {
						System.out.println(i.getNombre());
					}
					System.out.println("Los siguientes abonados VIP tienen clases el día " + dia);
					for (Abonado i : vip) {
						System.out.println(i.getNombre());
					}
				} else {
					System.err.println("No existen abonados registrados");
				}
			}
			case 0 -> {
				System.out.println("Saliendo del programa...");
			}
			default -> {
				System.err.println("La opción introducida no es válida");
			}
			}

		} while (opcion != 0);

	}

	public static int mostrarMenu() {
		System.out.println();
		System.out.println("""
				Bienvenido al Gimnasio TontoGimnasios S.A.

				Introduce un número con la opción deseada

				1-Registrar nuevo abonado (sin actividades)
				2-Añadir actividad a abonado
				3-Mostrar el dinero generado por las actividades de los abonados regulares
				4-Mostrar los abonados que tienen actividades el día de la semana especificado
				0-Salir del programa
				""");
		return scan.nextInt();
	}

}
