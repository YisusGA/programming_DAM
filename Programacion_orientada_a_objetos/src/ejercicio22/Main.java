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

	//Sacamos el array de clientes fuera del método main para que el método auxiliar mostrarClientes() pueda acceder a él. Debemos hacer que sea static
	//para que el main pueda usarlo. No hay problema en que sea static, pues sólo vamos a usar un array de clientes común para toda la clase
	// Problema de los arrays: le tenemos que dar un tamaño en el momento en el que lo instanciamos.
	// Le damos en este caso un tamaño de 100, que debería ser lo suficientemente
	// grande por ahora.
	static Cliente[] clientes = new Cliente[100];
	
	static int siguientePosicionLibreCliente = 0; // Esta variable me contabiliza cuántos clientes tengo siempre, para evitar los
	                                      // null
	
	public static void main(String[] args) {

		System.out.println("Introduzca el IVA que aplica");
		Pedido.IVA = scan.nextDouble(); // Asi inicializamos una variable estática

		
		int codigoPedido = 0;

		int opcion;

		do {

			opcion = Main.mostrarMenu(); //Como el método mostrarMenu() está dentro de esta misma clase, 
			                             //podría omitir el nombre de la clase (Main) al llamarlo
			scan.nextLine();

			switch (opcion) {

			case 1 -> {
				

				// Almaceno el cliente c en el array y luego incremento la
				// siguientePosicionLibre
				clientes[siguientePosicionLibreCliente++] = leerCliente();
				System.out.println("Cliente registrado");
			}

			case 2 -> {
				if (siguientePosicionLibreCliente > 0) {
					mostrarClientes();
				} else {
					System.err.println("No hay ningún cliente registrado");
				}
			}

			case 3 -> {
				if (siguientePosicionLibreCliente > 0) {
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
					for (int i = 0; i < siguientePosicionLibreCliente && !encontradoCliente; i++) {
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
				if (siguientePosicionLibreCliente > 0) {
					System.out.println("Introduce el nif del cliente para generar la factura");
					String nifC = scan.nextLine();
					Cliente c;
					boolean encontradoCliente = false;
					for (int i = 0; i < siguientePosicionLibreCliente && !encontradoCliente; i++) {
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
				if (siguientePosicionLibreCliente > 0) {
					int max = 0;
					Cliente clienteMasPedidos = null; // Puedes inicializar un objeto de tipo Cliente con un null, mejor
														// que
														// darle valores ficticios,
														// que sería básicamente hacer Cliente clienteMasPedidos = new
														// Cliente("1", "1")
					for (int i = 0; i < siguientePosicionLibreCliente; i++) {
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
				if (siguientePosicionLibreCliente > 0) {
				Cliente clienteMax = clientes[0];
				for (int i = 1; i < siguientePosicionLibreCliente; i++) {
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
				for (int i = 0; !encontradoPedido && i < siguientePosicionLibreCliente; i++) {
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
				for (int i = 0; i < siguientePosicionLibreCliente; i++) {
					System.out.println(
							clientes[i].toString() + " Pedidos realizados: " + clientes[i].mostrarPedidosCliente());
				}
			}
			case 9 -> {
				
				//Contamos el número de pedidos que hay en total en la tienda
				int numeroPedidosTienda = 0;
				if (siguientePosicionLibreCliente > 0) {
					for (int i = 0; i < siguientePosicionLibreCliente; i++) {
						numeroPedidosTienda += clientes[i].numeroPedidos();
					}
					
					//Si hay algún pedido en la tienda, añadimos todos los pedidos de todos los clientes a un array común para toda la tienda
					if (numeroPedidosTienda != 0) {
						int contador = 0;
						Pedido[] pedidosTienda = new Pedido[numeroPedidosTienda];
						for (int i = 0; i < siguientePosicionLibreCliente; i++) {
							Pedido[] aux = new Pedido[clientes[i].numeroPedidos()];
							for (int j = 0; j < aux.length; j++) {
								aux = clientes[i].getPedidos();
							}
							for (int k = 0; k < aux.length; k++) {
								pedidosTienda[contador++] = aux[k];
							}
						}
						
						
//						Comprobar que se han añadido correctamente todos los pedidos de los clientes a un array común de toda la tienda
//						for (Pedido p : pedidosTienda) {
//							System.out.println(p.toString());
//						}
						
						
						//Iteramos sobre el array que hemos creado antes para buscar aquellos pedidos cuya descripción aparezca más de 10 veces.
						//De haber un pedido cuya descripción aparezca más de 10 veces, añadimos dicho pedido a un array de objetos Pedido
						Pedido[] pedidosMasDe10 = new Pedido[numeroPedidosTienda];
						int posicionPedidosMasDe10 = 0;
						boolean existePedidoMasDe10 = false;
						for (int i = 0; i < pedidosTienda.length; i++) {
							int contador2 = 0;
							for (int j = 0; j < pedidosTienda.length; j++) {
								if (pedidosTienda[i] != null && pedidosTienda[j] != null && pedidosTienda[i].getDescripcion().equals(pedidosTienda[j].getDescripcion())) {
									contador2++;
									if (j != i) {
										pedidosTienda[j] = null;
									}
								}
							}
							if (contador2 > 10) {
								pedidosMasDe10[posicionPedidosMasDe10++] = pedidosTienda[i];
								existePedidoMasDe10 = true;
							}
						}
						
						
						if (existePedidoMasDe10) {
							for (int i = 0; pedidosMasDe10[i] != null && i < pedidosMasDe10.length; i++) {
								for (int j = 0; j < siguientePosicionLibreCliente; j++) {
									Pedido[] aux = new Pedido[clientes[j].numeroPedidos()];
									aux = clientes[j].getPedidos();
									for (int k = 0; k < aux.length; k++) {
										if (pedidosMasDe10[i].getDescripcion().equals(aux[k].getDescripcion())) {
											clientes[j].modificarPrecioPedido(k, aux[k].getPrecio() * 0.9);
										}
									}
								}
							}
							System.out.println("Precio(s) modificados con un descuento del 10%");
						} else {
							System.err.println("No se ha pedido nada más de 10 veces, no se ofrece descuento");
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

	//Lo de debajo son métodos auxiliares dentro de la clase Main
	
	// Esté método también es static, porque no depende de propiedades de la clase.
	// Al ser static, lo puedo llamar con el nombre de la clase donde yo quiera
	private static int mostrarMenu() {
//		Scanner scan = new Scanner(System.in); CUIDADO: No hay que poner esto, porque ya hemos creado una variable estática de Scanner (scan), que podemos usar
//		cuando queramos dentro de la clase Main, llamando al método que haga falta tras el nombre de la variable (scan.nextInt(), scan.nextLine(), etc.).
//		Si ponemos un nuevo Scanner scan = new Scanner(System.in), va a dar problemas al hacer el escaneo.
		System.out.println("1. Registrar cliente");
		System.out.println("2. Listado de clientes");
		System.out.println("3. Agregar pedido a cliente");
		System.out.println("4. Generar factura");
		System.out.println("5. Mostrar cliente con más pedidos");
		System.out.println("6. Mostrar cliente que más ha gastado");
		System.out.println("7. Localizar pedido dando un código");
		System.out.println("8. Consultar la lista de pedidos hecha por todos los clientes");
		System.out.println("9. Rebajar 10% el precio de los pedidos que se hayan pedido más de 10 veces (buscar por descripción)");
		System.out.println("10. Cambiar IVA");
		System.out.println("0. Salir");
		return scan.nextInt();
	}
	
	private static Cliente leerCliente() {
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
		return c;
	}
	
	//
	private static void mostrarClientes() {
		// Hacemos un for con contador y no un for-each, para poder recorrer el array
		// sólo hasta donde esté lleno,
		// así no mostramos las posiciones vacías del array
		for (int i = 0; i < siguientePosicionLibreCliente; i++) {
			System.out.println(clientes[i]); //Le pasamos un objeto complejo al print. Como la clase Cliente tiene un método toString, porque lo hicimos, el print
			                       //va a llamar a ese método toString de Cliente automáticamente para hacer el print. Si no hubiéramos creado el método
			                       //toString en Cliente, mostraría direcciones de memoria
		}
	}

}
