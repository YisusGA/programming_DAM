package main;

import empresa.CentralEnvios;
import model.EstadoEnvio;
import repositorio.RepositorioEnvios;
import teclado.TecladoOK;

public class Main {

	public static void main(String[] args) {
		int opcion;

		do {
			opcion = mostrarMenu();

			switch (opcion) {
			case 1 -> {
				System.out.println(CentralEnvios.registrarEnvio());
			}
			case 2 -> {
				if (RepositorioEnvios.hayEnvios()) {
					CentralEnvios.listarEnvios();
				} else {
					System.err.println("No hay pedidos registrados");
				}

			}
			case 3 -> {
				System.out.printf("El coste total de todos los pedidos es: %.2f %n", CentralEnvios.costeTotal());
			}
			case 4 -> {
				System.out.printf("El coste total de todos los seguros es: %.2f %n", CentralEnvios.costeTotalSeguros());
			}
			case 5 -> {
				if (RepositorioEnvios.hayEnvios()) {
					System.out.println("¿Introduce el código de pedido?");
					int codigo = TecladoOK.leerEntero();
					EstadoEnvio estado;
					do {
						System.out.println(
								"Introduce un nuevo estado de envío válido: CREADO, ENVIADO, RECIBIDO, DEVUELTO");
						estado = EstadoEnvio.leerTeclado();
					} while (estado == null);
					System.out.println(CentralEnvios.actualizarEstadoEnvio(estado, codigo));
				} else {
					System.err.println("No hay pedidos registrados");
				}
			}
			case 6 -> {
				if (RepositorioEnvios.hayEnvios()) {
					System.out.println("Introduce el código del envío a eliminar");
					int codigo = TecladoOK.leerEntero();
					if (RepositorioEnvios.eliminarEnvio(codigo)) {
						System.out.println("Pedido eliminado correctamente");
					} else {
						System.err.println("No se ha encontrado el pedido con el código introducido");
					}
				} else {
					System.err.println("No hay pedidos registrados");
				}
			}
			case 0 -> {
				System.out.println("Finalizando el programa...");
			}
			default -> {
				System.err.println("La opción introducida no es válida");
			}
			}
		} while (opcion != 0);

	}

	public static int mostrarMenu() {
		System.out.println("""
				Bienvendido a Yisus Logistics S.L.
				¿Qué opción desea realizar?
				1. Registrar pedido
				2. Listar pedidos
				3. Calcular el coste total de todos los pedidos
				4. Calcular el coste total de todos los seguros contratados
				5. Actualizar el estado de un envío rastreable
				6. Eliminar pedido
				0. Salir del programa
				""");
		return TecladoOK.leerEntero();
	}

}
