package main;

import empresa.CentralEnvios;
import model.Envio;
import model.EnvioEstandar;
import model.EnvioRefrigerado;
import model.EnvioUrgente;
import model.EstadoEnvio;
import model.TipoEnvio;
import teclado.Teclado2;

public class Main {

	public static void main(String[] args) {
		CentralEnvios central = new CentralEnvios();
		int opcion;

		do {
			opcion = mostrarMenu();

			switch (opcion) {
			case 1 -> {
				System.out.println(central.registrarEnvio());
			}
			case 2 -> {
				if (central.hayEnvios()) {
					central.listarEnvios();
				} else {
					System.err.println("No hay pedidos registrados");
				}

			}
			case 3 -> {
				System.out.printf("El coste total de todos los pedidos es: %.2f %n", central.costeTotal());
			}
			case 4 -> {
				System.out.printf("El coste total de todos los seguros es: %.2f %n", central.costeTotalSeguros());
			}
			case 5 -> {
				if (central.hayEnvios()) {
					System.out.println("¿Introduce el código de pedido?");
					int codigo = Teclado2.leerEntero();
					EstadoEnvio estado;
					do {
						System.out.println(
								"Introduce un nuevo estado de envío válido: CREADO, ENVIADO, RECIBIDO, DEVUELTO");
						estado = EstadoEnvio.leerTeclado();
					} while (estado == null);
					System.out.println(central.actualizarEstadoEnvio(estado, codigo));
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
				0. Salir del programa
				""");
		return Teclado2.leerEntero();
	}

}
