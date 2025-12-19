package ejercicio22;

import ejercicio22.modelo.Cliente;
import ejercicio22.modelo.Pedido;
import java.util.Scanner;

public class Main {

	static Scanner scan = new Scanner(System.in); // Como lo usamos varias veces, podemos declararlo como propiedad de
													// la clase.
													// Como lo usamos en el método main, que es static, la variable
													// tiene que ser static.
													// Como no necesitamos varios objetos de tipo Scanner en la clase,
													// sino sólo 1, tiene sentido que sea static

	public static void main(String[] args) {

		System.out.println("Introduzca el IVA que aplica");
		Pedido.IVA = scan.nextDouble(); // Asi inicializamos una variable estática

		// Problema de los arrays: le tenemos que dar un tamaño en el momento en el que
		// lo instanciamos.
		// Le damos en este caso un tamaño de 100, que debería ser lo suficientemente
		// grande por ahora.
		Cliente[] clientes = new Cliente[100];
		int siguientePosicionLibre = 0; // Esta variable me contabiliza cuántos clientes tengo siempre, para evitar los
										// null
		int codigoPedido = 0;

		int opcion;

		do {

			opcion = Main.mostrarMenu();
			scan.nextLine();

			switch (opcion) {

			case 1 -> {
				System.out.println("nif");
				String nif = scan.nextLine();
				System.out.println("nombre de cliente");
				String nombre = scan.nextLine();

				// c es una variable local y desaparecerá, pero dejamos almacenado su valor en
				// el array, el cual no
				// es local
				Cliente c = new Cliente(nif, nombre); // Usamos el constructor que sólo tiene nif y nombre, para no
														// tener que meter pedidos aún
														// Si usáramos el constructor que tiene pedidos, podríamos poner
														// Cliente c = new Cliente(nif, nombre, null)

				// Almaceno el cliente c en el array y luego incremento la
				// siguientePosicionLibre
				clientes[siguientePosicionLibre++] = c;
				System.out.println("Cliente registrado");
			}

			case 2 -> {
				if (siguientePosicionLibre > 0) {
					// Hacemos un for con contador y no un for-each, para poder recorrer el array
					// sólo hasta donde esté lleno,
					// así no mostramos las posiciones vacías del array
					for (int i = 0; i < siguientePosicionLibre; i++) {
						// No hace falta poner clientes[i].toString() porque el syso sólo muestra
						// Strings, y asume
						// que queremos usar
						// el método toString de Cliente. Eso sí, hemos tenido que crear el método
						// toString en Cliente. Si no hubiéramos creado el método toString en cliente,
						// se haría un
						// toString por defecto, pero nos mostraría cosas muy raras ese toString por
						// defecto
						System.out.println(clientes[i]);
					}
				} else {
					System.err.println("No hay ningún cliente registrado");
				}
			}

			case 3 -> {
				if (siguientePosicionLibre > 0) {
					System.out.println("Descripción del pedido");
					String descripcion = scan.nextLine();
					System.out.println("Precio");
					double precio = scan.nextDouble();
					scan.nextLine();
					// Generar código internamente para que sea único. Inicializamos una variable en
					// 0 (ver más arriba)
					// y la vamos post-incrementando
					Pedido p = new Pedido(codigoPedido++, descripcion, precio);
					System.out.println("nif del cliente");
					String nifC = scan.nextLine();
					boolean encontradoCliente = false;
					// Agregar un pedido p a un cliente
					// Mucho mejor crear un método en Cliente y usarlo que meter muchas líneas en el
					// main
					for (int i = 0; i < siguientePosicionLibre && !encontradoCliente; i++) {
						if (clientes[i].getNif().equals(nifC)) {
							clientes[i].agregarPedido(p);
							encontradoCliente = true;
						}
					}
					if (encontradoCliente) {
						System.out.println("Pedido agregado");
					} else {
						System.err.println("No se ha encontrado cliente");
					}
				} else {
					System.err.println("No hay ningún cliente registrado");
				}
			}
			case 4 -> {
				if (siguientePosicionLibre > 0) {
					System.out.println("Introduce el nif del cliente para generar la factura");
					String nifC = scan.nextLine();
					Cliente c;
					boolean encontradoCliente = false;
					for (int i = 0; i < siguientePosicionLibre && !encontradoCliente; i++) {
						if (clientes[i].getNif().equals(nifC)) {
							encontradoCliente = true;
							clientes[i].mostrarFactura();
						}
					}
					if (!encontradoCliente) {
						System.out.println("Cliente no encontrado");
					}
				} else {
					System.err.println("No hay ningún cliente registrado");
				}
			}
			case 5 -> {
				if (siguientePosicionLibre > 0) {
					int max = 0;
					Cliente clienteMasPedidos = null; // Puedes inicializar un objeto de tipo Cliente con un null, mejor
														// que
														// darle valores ficticios,
														// que sería básicamente hacer Cliente clienteMasPedidos = new
														// Cliente("1", "1")
					for (int i = 0; i < siguientePosicionLibre; i++) {
						if (clientes[i].getPedidos() != null && clientes[i].getPedidos().length > max) { // Importante
																											// el
																											// diferente
																											// de
																											// null, y
																											// que
																											// vaya al
																											// principio
																											// y
																											// con el
																											// doble
																											// &
							max = clientes[i].getPedidos().length;
							clienteMasPedidos = clientes[i];
						}
					}
					System.out.println("El cliente con más pedidos es: " + clienteMasPedidos);

//				Esta es la forma cómo lo hizo Raquel, que en principio es mejor
//				Cliente clienteMax = clientes[0];
//				for (int i = 1; i < siguientePosicionLibre; i++) {
//					if (clientes[i].getPedidos() != null && clientes[i].getPedidos().length > clienteMax.getPedidos().length) {
//						clienteMax = clientes[i];
//					}
//				}
//				System.out.println("El cliente con más pedidos es: " + clienteMax);
				} else {
					System.err.println("No hay ningún cliente registrado");
				}
			}
			case 6 -> {
				if (siguientePosicionLibre > 0) {
				Cliente clienteMax = clientes[0];
				for (int i = 1; i < siguientePosicionLibre; i++) {
					if (clientes[i].getPedidos() != null && clientes[i].gastoTotal() > clienteMax.gastoTotal()) {
						clienteMax = clientes[i];
					}
				}
				System.out.println("El cliente que más ha gastado es: " + clienteMax);
				
				} else {
					System.err.println("No hay ningún cliente registrado");
				}
			}
			case 7 -> {
				boolean encontradoPedido = false;
				Cliente clientePedidoEncontrado = null;
				System.out.println("Introduce el código de pedido a buscar");
				int codigoBuscar = scan.nextInt();
				for (int i = 0; !encontradoPedido && i < siguientePosicionLibre; i++) {
					encontradoPedido = clientes[i].encontrarCodigoPedido(codigoBuscar);
					clientePedidoEncontrado = clientes[i];
				}
				if (encontradoPedido) {
					System.out.println("El pedido se ha encontrado. Lo ha hecho el cliente " + clientePedidoEncontrado);
				} else {
					System.err.println("No se ha encontrado el pedido solicitado");
				}
			}
			case 8 -> {
				for (int i = 0; i < siguientePosicionLibre; i++) {
					System.out.println(
							clientes[i].toString() + " Pedidos realizados: " + clientes[i].mostrarPedidosCliente());
				}
			}
			case 9 -> {
				int numeroPedidosTienda = 0;
				if (siguientePosicionLibre > 0) {
					for (int i = 0; i < siguientePosicionLibre; i++) {
						numeroPedidosTienda += clientes[i].numeroPedidos();
					}
					System.out.println(numeroPedidosTienda);
					if (numeroPedidosTienda != 0) {
						int contador = 0;
						Pedido[] pedidosTienda = new Pedido[numeroPedidosTienda];
						for (int i = 0; i < siguientePosicionLibre; i++) {
							Pedido[] aux = new Pedido[clientes[i].numeroPedidos()];
							for (int j = 0; j < aux.length; j++) {
								aux = clientes[i].getPedidos();
							}
							for (int k = 0; k < aux.length; k++) {
								pedidosTienda[contador++] = aux[k];
							}
						}
						for (Pedido p : pedidosTienda) {
							System.out.println(p.toString());
						}
					} else {
						System.err.println("Aún no se ha realizado ningún pedido en la tienda");
					}
				} else {
					System.err.println("No existe ningún cliente registrado");
				}
			}
			case 10 -> {
				System.out.println("Introduce el nuevo valor de IVA");
				double iva = scan.nextDouble();
				// Con esta línea de debajo valdría, pero vamos a hacer más cosas para practicar
				// con métodos estáticos
//				Pedido.IVA = iva;
				Pedido.modificaIVA(iva); // Podemos llamar al método estático directamente con el nombre de la clase,
											// sin necesidad de instanciar la clase
			}
			case 11 -> {
				System.out.println("Introduce número de cliente");
				int i = scan.nextInt();
				System.out.println(clientes[i].getPedidos());
			}
			case 0 -> {
				// Aquí volcaríamos los datos en una base de datos
				System.out.println("Cerrando programa...");
			}
			}
		} while (opcion != 0);

	} // Aquí termina mi main

	// Esté método también es static, porque no depende de propiedades de la clase.
	// Al ser static, lo puedo llamar con el nombre de la clase donde yo quiera
	private static int mostrarMenu() {
		Scanner scan = new Scanner(System.in);
		System.out.println("1. Registrar cliente");
		System.out.println("2. Listado de clientes");
		System.out.println("3. Agregar pedido a cliente");
		System.out.println("4. Generar factura");
		System.out.println("5. Mostrar cliente con más pedidos");
		System.out.println("6. Mostrar cliente que más ha gastado");
		// 7. Mostrar datos del cliente que hizo ese pedido
		System.out.println("7. Localizar pedido dando un código");
		System.out.println("8. Consultar la lista de pedidos hecha por todos los clientes");
		// 9. Hay que buscar pedidos por descripción, pues el código de pedido es único
		System.out.println("9. Rebajar 10% el precio de los pedidos que se hayan pedido más de 10 veces (buscar por descripción)");
		System.out.println("10. Cambiar IVA");
		System.out.println("0. Salir");
		/*
		 * Nombre cliente Listado pedidos Total a pagar
		 */
		return scan.nextInt();
	}

}
