package ejercicio23.modelo;

public class Tienda {
	Cliente[] clientes;
	Item[] items = { new Item(0, "PC", 800), new Item(1, "RAM", 200), };
	private String password = "12345";
	private int codigoItem = 2;

	public boolean passwordValida(String password) {
		if (password.equals(this.password)) {
			return true;
		} else {
			return false;
		}
	}

	public int generarCodigoItem() {
		return codigoItem++;
	}

	public String registrarItem(Item item) {
		Item[] aux = new Item[items.length + 1];
		for (int i = 0; i < items.length; i++) {
			aux[i] = items[i];
		}
		aux[aux.length - 1] = item;
		items = aux;
		return "Item registrado correctamente en la tienda";
	}

	public String mostrarListaItems() {
		String listaItems = "La lista de items disponibles en la tienda es: ";
		for (int i = 0; i < items.length; i++) {
			listaItems += "[" + items[i].getCodigo() + ", " + items[i].getNombre() + ", " + items[i].getPrecio()
					+ "€], ";
		}
		return listaItems;
	}

	public boolean comprobarSiExiste(int codigo) {
		boolean existe = false;
		for (int i = 0; i < items.length; i++) {
			if (items[i].getCodigo() == codigo) {
				existe = true;
			}
		}
		return existe;
	}

	public Item pasarItem(int codigo) {
		boolean encontrado = false;
		Item item = new Item(0, null, 0);
		for (int i = 0; !encontrado && i < items.length; i++) {
			if (items[i].getCodigo() == codigo) {
				encontrado = true;
				item = items[i];
			}
		}
		return item;
	}

	public String registrarCliente(Cliente c) {
		if (clientes == null) {
			clientes = new Cliente[1];
			clientes[0] = c;
			return "test";
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

	public int buscarCliente(String nif) {
		if (clientes == null) {
			return 0;
		} else {
			boolean encontrado = false;
			int posicionCliente = 0;
			for (int i = 0; !encontrado && i < clientes.length; i++) {
				if (clientes[i].getNif().equals(nif)) {
					encontrado = true;
					posicionCliente = i;
				}
			}
			return posicionCliente;
		}

	}
	
	public String añadirPedido(int posicionCliente, Pedido p) {
		if (clientes == null) {
			return "No hay clientes registrados en la tienda";
		} else {
			clientes[posicionCliente].añadirPedido(p);
			return "Pedido asignado correctamente al cliente";
		}
	}
	
	public boolean comprobarSiHayClientes() {
		if (clientes == null) {
			return false;
		} else {
			return true;
		}
	}

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

	public String eliminarItemsTienda(int codigo) {
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
			return "El cliente que más ha gastado es" + clientes[clienteMayorGasto].toString() + ". Ha gastado: "
					+ mayorGasto + "€";
		}
	}
}
