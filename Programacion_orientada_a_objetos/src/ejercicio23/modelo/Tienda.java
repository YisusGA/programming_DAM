package ejercicio23.modelo;

public class Tienda {
	Cliente[] clientes;
	Item[] items = { new Item(0, "PC", 800), new Item(1, "RAM", 200), };

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
			listaItems += "[" + items[i].getNombre() + ", " + items[i].getPrecio() + "€], ";
		}
		return listaItems;
	}

	public boolean comprobarSiExiste(String item) {
		boolean existe = false;
		for (int i = 0; i < items.length; i++) {
			if (items[i].getNombre().equals(item)) {
				existe = true;
			}
		}
		return existe;
	}
	
	public String registrarCliente (Cliente c) {
		if (clientes == null) {
			Cliente[] clientes = new Cliente[1];
			clientes[0] = c;
		} else {
			Cliente[] aux = new Cliente[clientes.length + 1];
			for (int i = 0; i < clientes.length; i++) {
				aux[i] = clientes[i];
			}
			aux[aux.length - 1] = c;
			clientes = aux;
		}
		return "Cliente registrado correctamente";
	}
	
	public int buscarCliente(String nif) {
		boolean encontrado = false;
		int cliente = 0;
		for (int i = 0; !encontrado && i < clientes.length; i++) {
			if (clientes[i].getNif().equals(nif)) {
				encontrado = true;
				cliente = i;
			}
		}
		return cliente;
		
	}
	
	public String eliminarItems (int codigo) {
		if (clientes == null) {
			return "No existen clientes registrados en la tienda";
		} else {		
			for (int i = 0; i < clientes.length; i++) {
				clientes[i].eliminarItems(codigo);
			}
			return "Items eliminados correctamente de todos los clientes";
		} 
	}
	
	public String clienteMayorGasto () {
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
			return "El cliente que más ha gastado es" + clientes[clienteMayorGasto].toString() + ". Ha gastado: " + mayorGasto + "€";
		}
	}
}
