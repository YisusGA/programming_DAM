package ejercicio22;

import ejercicio22.modelo.Cliente;
import ejercicio22.modelo.Pedido;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		// Problema de los arrays: le tenemos que dar un tamaño en el momento en el que
		// lo instanciamos.
		// Le damos en este caso un tamaño de 100, que debería ser lo suficientemente grande por ahora.
		Cliente[] clientes = new Cliente[100];
		int siguientePosicionLibre = 0;
		int codigoPedido = 0;

		int opcion;

		do {
			System.out.println("1. Registrar cliente");
			System.out.println("2. Listado de clientes");
			System.out.println("3. Agregar pedido a cliente");
			System.out.println("4. Generar factura");
			System.out.println("5. Mostrar cliente con más pedidos");
			//6. Mostrar datos del cliente que hizo ese pedido
			System.out.println("6. Localizar pedido dando un código");
			//7. Hay que buscar pedidos por descripción, pues el código de pedido es único
			System.out.println("7. Rebajar 10% el precio de los pedidos que se hayan pedido más de 10 veces (buscar por descripción)");
			System.out.println("0. Salir");
			/*
			 * Nombre cliente
			 * Listado pedidos
			 * Total a pagar
			 */
			opcion = scan.nextInt();
			scan.nextLine();

			switch (opcion) {

			case 1 -> {
				System.out.println("nif");
				String nif = scan.nextLine();
				System.out.println("nombre de cliente");
				String nombre = scan.nextLine();
				
				// c es una variable local y desaparecerá, pero dejamos almacenado su valor en el array, el cual no
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
				// Hacemos un for con contador y no un for-each, para poder recorrer el array
				// sólo hasta donde esté lleno,
				// así no mostramos las posiciones vacías del array
				for (int i = 0; i < siguientePosicionLibre; i++) {
					// No hace falta poner clientes[i].toString() porque el syso sólo muestra Strings, y asume
					// que queremos usar
					// el método toString de Cliente. Eso sí, hemos tenido que crear el método
					// toString en Cliente. Si no hubiéramos creado el método toString en cliente, se haría un 
					//toString por defecto, pero nos mostraría cosas muy raras ese toString por defecto
					System.out.println(clientes[i]);
				}
			}

			case 3 -> {
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
			}
			case 4 -> {
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
			}
			case 5 -> {
				int max = Integer.MIN_VALUE;
				Cliente clienteMasPedidos = new Cliente("1", "1");
				for (int i = 0; i < siguientePosicionLibre; i++) {
					if (clientes[i].getPedidos() != null && clientes[i].getPedidos().length > max) {
						max = clientes[i].getPedidos().length;
						clienteMasPedidos = clientes[i];
					}
				}
				System.out.println("El cliente con más pedidos es: " + clienteMasPedidos);
			}
			case 6 -> {
				boolean encontradoPedido = false;
				Cliente clientePedidoEncontrado = new Cliente("1", "1");
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
			case 0 -> {
				// Aquí volcaríamos los datos en una base de datos
				System.out.println("Cerrando programa...");
			}
			}
		} while (opcion != 0);

	}

}
