package ejercicio23.modelo;

public class Tienda {
	Cliente[] clientes;
	Item[] items = { new Item(0, "PC", 800), new Item(1, "RAM", 200), };
	private String password = "12345";
	private int codigoItem; // Aquí no haría falta que fuera static como en el caso de Pedido, pues sólo
							// vamos a tener un objeto tienda

	// Métodos

	/**
	 * Método para comprobar si la contraseña de administrador introducida es
	 * correcta
	 * 
	 * @param String con la password
	 * @return boolean indicando si la contraseña introducida es correcta (true) o
	 *         no (false)
	 */
	public boolean passwordValida(String password) {
		if (password.equals(this.password)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Este método genera un código de Item (incrementando desde el máximo valor de
	 * entre los objetos Item que haya en el catálogo) para cada Item nuevo que se
	 * añada al catálogo de la Tienda
	 * 
	 * @return Un int que identifica a cada Item del catálogo de la Tienda de forma
	 *         única
	 */
	public int generarCodigoItem() {
		if (items == null) {
			return -1;
		} else {
			codigoItem = 0;
			for (int i = 0; i < items.length; i++) {
				if (items[i].getCodigo() > codigoItem) {
					codigoItem = items[i].getCodigo();
				}
			}
			return codigoItem;
		}
	}

	/**
	 * Método para registrar un nuevo Item en el catálogo de la Tienda
	 * 
	 * @param Objeto Item
	 * @return Mensaje indicando que se ha añadido correctamente el Item
	 */
	public String registrarItem(Item item) {
		Item[] aux = new Item[items.length + 1];
		for (int i = 0; i < items.length; i++) {
			aux[i] = items[i];
		}
		aux[aux.length - 1] = item;
		items = aux;
		return "Item registrado correctamente en la tienda";
	}

	/**
	 * Método para mostrar los objetos Item disponibles en el catálogo de la Tienda
	 * 
	 * @return String con los datos de los Item disponibles en el catálogo de la
	 *         Tienda
	 */
	public String mostrarListaItems() {
		String listaItems = "La lista de items disponibles en la tienda es: ";
		for (int i = 0; i < items.length; i++) {
			listaItems += "[" + items[i].getCodigo() + ", " + items[i].getNombre() + ", " + items[i].getPrecio()
					+ "€], ";
		}
		return listaItems;
	}

	/**
	 * Método para comprobar si un Item existe en el catálogo de la Tienda
	 * 
	 * @param codigo del Item a buscar
	 * @return boolean indicando si se ha encontrado el Item (true) o no (false)
	 */
	public boolean comprobarSiExiste(int codigo) {
		boolean existe = false;
		for (int i = 0; i < items.length; i++) {
			if (items[i].getCodigo() == codigo) {
				existe = true;
			}
		}
		return existe;
	}

	/**
	 * Método para pasar un objeto Item dado un código de Item
	 * 
	 * @param codigo de Item
	 * @return Objeto Item
	 */
	public Item pasarItem(int codigo) {
		boolean encontrado = false;
		Item item = new Item();
		for (int i = 0; !encontrado && i < items.length; i++) {
			if (items[i].getCodigo() == codigo) {
				encontrado = true;
				item = items[i];
			}
		}
		return item;
	}

	/**
	 * Método para registrar un nuevo Cliente en la Tienda
	 * 
	 * @param Objeto Cliente
	 * @return String indicando que el Cliente ha sido registrado
	 */
	public String registrarCliente(Cliente c) {
		if (clientes == null) {
			clientes = new Cliente[1];
			clientes[0] = c;
		} else {
			Cliente[] aux = new Cliente[clientes.length + 1];
			for (int i = 0; i < clientes.length; i++) {
				aux[i] = clientes[i];
			}
			aux[aux.length - 1] = c;
			this.clientes = aux;
		}
		return "Cliente registrado correctamente";
	}

	/**
	 * Método para buscar un Cliente dado su nif
	 * 
	 * @param String con el nif
	 * @return La posición del Cliente dentro del array de clientes
	 */
	public int buscarCliente(String nif) {
		if (clientes == null) {
			return -1;
		} else {
			boolean encontrado = false;
			int posicionCliente = -1;
			for (int i = 0; !encontrado && i < clientes.length; i++) {
				if (clientes[i].getNif().equals(nif)) {
					encontrado = true;
					posicionCliente = i;
				}
			}
			return posicionCliente;
		}

	}

	/**
	 * Método para eliminar un Pedido de un Cliente
	 * 
	 * @param nif    del Cliente
	 * @param codigo de Pedido
	 * @return String indicando lo que ha ocurrido tras ejecutar el método
	 */
	public String eliminarPedidoCliente(String nif, int codigo) {
		if (clientes == null) {
			return "No hay clientes registrados en la tienda";
		} else {
			boolean encontrado = false;
			int posicionCliente = -1;
			for (int i = 0; !encontrado && i < clientes.length; i++) {
				if (clientes[i].getNif().equals(nif)) {
					encontrado = true;
					posicionCliente = i;
				}
			}
			if (encontrado) {
				if (clientes[posicionCliente].buscarPedido(codigo)) {
					clientes[posicionCliente].eliminarPedido(codigo);
					return "Pedido eliminado correctamente";
				} else {
					return "El pedido con ese código no se encuentra en este cliente";
				}
			} else {
				return "Cliente no encontrado";
			}
		}

	}

	/**
	 * Método para añadir un pedido a un Cliente
	 * 
	 * @param posicionCliente dentro del array clientes. Esta posición debería venir
	 *                        tras ejecutar el método de Tienda buscarCliente(String
	 *                        nif)
	 * @param Objeto          Pedido
	 * @return String indicando lo que ha hecho el método
	 */
	public String añadirPedido(int posicionCliente, Pedido p) {
		if (clientes == null) {
			return "No hay clientes registrados en la tienda";
		} else {
			clientes[posicionCliente].añadirPedido(p);
			return "Pedido asignado correctamente al cliente";
		}
	}

	/**
	 * Método para los datos de todos los objetos Pedido de un Cliente
	 * 
	 * @param posicionCliente dentro del array clientes. Esta posición debería venir
	 *                        tras ejecutar el método de Tienda buscarCliente(String
	 *                        nif)
	 * @return String con los datos de todos los objetos Pedido del Cliente
	 */
	public String mostrarPedidos(int posicionCliente) {
		if (clientes == null) {
			return "No hay clientes registrados en la tienda";
		} else {
			return clientes[posicionCliente].mostrarPedidos();
		}
	}

	/**
	 * Método para comprobar si hay clientes registrados en la Tienda
	 * 
	 * @return boolean con valor true si hay clientes o false si no los hay
	 */
	public boolean comprobarSiHayClientes() {
		if (clientes == null) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Método para eliminar un Item de todos los objetos Pedido de todos los objetos
	 * Cliente
	 * 
	 * @param codigo de Item
	 * @return String con lo que ha hecho el método
	 */
	public String eliminarItems(int codigo) {
		if (clientes == null) {
			return "No existen clientes registrados en la tienda";
		} else {
			for (int i = 0; i < clientes.length; i++) {
				clientes[i].eliminarItems(codigo);
			}
			return "Items eliminados correctamente de todos los clientes";
		}
	}

	/**
	 * Método para eliminar un Item del catálogo de la Tienda
	 * 
	 * @param codigo del Item a eliminar
	 * @return String con lo que ha sucedido tras ejecutar el método
	 */
	public String eliminarItemTienda(int codigo) {
		if (items != null) {
			boolean encontrado = false;
			int posicion = 0;
			for (int i = 0; !encontrado && i < items.length; i++) {
				if (items[i].getCodigo() == codigo) {
					encontrado = true;
					posicion = i;
				}
			}
			if (encontrado) {
				Item[] aux = new Item[items.length - 1];
				for (int i = 0, j = 0; i < items.length; i++) {
					if (i != posicion) {
						aux[j++] = items[i];
					}
				}
				items = aux;
				return "Item eliminado correctamente de la tienda";
			} else {
				return "El item no se encuentra en la tienda";
			}
		} else {
			return "No hay items en la tienda";
		}
	}

	/**
	 * Método para calcular y mostrar los datos del Cliente que más ha gastado en la
	 * Tienda
	 * 
	 * @return String con los datos del Cliente que más ha gastado en la Tienda
	 */
	public String clienteMayorGasto() {
		if (clientes == null) {
			return "No hay clientes registrados en la tienda";
		} else {
			double mayorGasto = clientes[0].gastoTotal();
			int clienteMayorGasto = 0;
			for (int i = 0; i < clientes.length; i++) {
				if (clientes[i].gastoTotal() > mayorGasto) {
					mayorGasto = clientes[i].gastoTotal();
					clienteMayorGasto = i;
				}
			}
			return "El cliente que más ha gastado es " + clientes[clienteMayorGasto].toString() + ". Ha gastado: "
					+ mayorGasto + "€";
		}
	}
}
