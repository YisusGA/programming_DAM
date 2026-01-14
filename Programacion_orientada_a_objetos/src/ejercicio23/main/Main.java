package ejercicio23.main;

import java.util.Scanner;

import ejercicio23.modelo.Item;
import ejercicio23.modelo.Pedido;
import ejercicio23.modelo.Cliente;
import ejercicio23.modelo.Tienda;

public class Main {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		Tienda yisusStore = new Tienda();

		// Inicializamos el IVA de Pedido
		System.out.println("Introduce el IVA (%) que aplica");
		double IVA = 0;
		;
		while ((scan.nextDouble()) <= 0) {
			System.out.println("El valor de IVA introducido debe ser mayor que 0");
		}
		Pedido.setIVA(IVA);

		int opcion;
		do {
			opcion = mostrarMenu();
			scan.nextLine();

			switch (opcion) {

			case 1 -> {
				System.out.println("Introduce el IVA (%) que aplica");
				while ((scan.nextDouble()) <= 0) {
					System.out.println("El valor de IVA introducido debe ser mayor que 0");
				}
				Pedido.setIVA(IVA);
			}

			case 2 -> {
				System.out.println("Introduce el nombre");
				String nombre = scan.nextLine();
				System.out.println("Introduce el nif");
				String nif = scan.nextLine();
				Cliente c = new Cliente(nombre, nif);
				System.out.println(yisusStore.registrarCliente(c));
			}

			case 3 -> {
				if (yisusStore.comprobarSiHayClientes()) {
					System.out.println("Estos son los items disponibles en la tienda");
					System.out.println(yisusStore.mostrarListaItems());
					Pedido p = new Pedido();
					System.out.println("Introduce el nombre del pedido");
					String nombre = scan.nextLine();
					p.setCodigo(p.generarCodigoPedido());
					p.setNombre(nombre);
					String codigo;
					do {
						System.out.println(
								"Introduce el código del item que quieres añadir a tu pedido. Introduce stop cuando quieras parar");
						codigo = scan.nextLine();
						if (!codigo.equals("stop") && yisusStore.comprobarSiExiste(Integer.parseInt(codigo))) {
							p.addItems(yisusStore.pasarItem(Integer.parseInt(codigo)));
						} else if (!codigo.equals("stop")) {
							System.err.println("El código de item introducido no es correcto");
						} else {
							System.out.println("Items añadidos correctamente al pedido");
						}
					} while (!(codigo.equals("stop")));
					// Comprobar si existe cliente con nif
					System.out.println("Introduce tu nif");
					String nif = scan.nextLine();
					if (yisusStore.buscarCliente(nif) >= 0) {
						System.out.println(yisusStore.añadirPedido(yisusStore.buscarCliente(nif), p));
					} else {
						System.out.println("No hay ningún cliente registrado con ese nif");
					}
				} else {
					System.err.println("No hay clientes registrados en la tienda");
				}
			}

			case 4 -> { // Me he quedado aquí
				if (yisusStore.comprobarSiHayClientes()) {
					System.out.println("Introduce tu nif");
					String nif = scan.nextLine();
					if (yisusStore.buscarCliente(nif) >= 0) {
						System.out.println(yisusStore.mostrarPedidos(yisusStore.buscarCliente(nif)));
					} else {
						System.out.println("No hay ningún cliente registrado con ese nif");
					}
				} else {
					System.err.println("No hay clientes registrados en la tienda");
				}
			}

			case 7 -> {
				boolean acceso = false;
				System.out.println("Introduce contraseña");
				if (yisusStore.passwordValida(scan.nextLine())) {

					int opcionAdmin;
					do {
						opcionAdmin = mostrarMenuAdmin();
						scan.nextLine();

						switch (opcionAdmin) {

						case 1 -> {
							int codigo = yisusStore.generarCodigoItem();
							System.out.println("Introduce el nombre del producto");
							String nombre = scan.nextLine();
							System.out.println("Introduce el precio del producto");
							double precio = scan.nextDouble();
							Item item = new Item(codigo, nombre, precio);
							System.out.println(yisusStore.registrarItem(item));
						}

						case 2 -> {
							System.out.println("Lista de items disponibles en la tienda");
							System.out.println(yisusStore.mostrarListaItems());
							System.out.println("Introduce el código del producto a eliminar");
							System.out.println(yisusStore.eliminarItemsTienda(scan.nextInt()));
						}

						case 3 -> {
							System.out.println("Lista de items disponibles en la tienda");
							System.out.println(yisusStore.mostrarListaItems());
						}

						case 0 -> {
							System.out.println("Saliendo del menu de admin...");
						}

						default -> {
							System.err.println("La opción introducida no es válida");
						}
						}
					} while (opcionAdmin != 0);
				} else {
					System.err.println("La contraseña no es correcta");
				}

			}

			case 0 -> {
				System.out.println("Finalizando programa...");
			}

			default -> {
				System.err.println("La opción introducida no es válida");
			}

			}
		} while (opcion != 0);

	}

	/**
	 * Método auxiliar para mostrar el menú al usuario
	 * 
	 * @return Escanea un int para escoger la opción
	 */
	private static int mostrarMenu() {
		System.out.println("""
				1. Modificar IVA
				2. Insertar nuevo cliente (sin pedidos)
				3. Generar pedido y asignar a cliente
				4. Mostrar pedidos de un cliente
				5. Eliminar item de todos los clientes que lo hayan pedido en alguno de sus pedidos
				6. Mostrar el cliente que más dinero ha gastado en la tienda
				7. Menu de administrador
				0. Salir del programa
				""");
		return scan.nextInt();
	}

	/**
	 * Método auxiliar para mostrar el menú al administrador
	 * 
	 * @return Escanea un int para escoger la opción
	 */
	private static int mostrarMenuAdmin() {
		System.out.println("""
				1. Registrar nuevo item en la tienda
				2. Eliminar item de la tienda
				3. Mostrar lista de items de la tienda
				0. Salir del menu de admin
				""");
		return scan.nextInt();
	}

}
