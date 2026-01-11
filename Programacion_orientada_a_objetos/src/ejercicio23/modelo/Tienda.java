package ejercicio23.modelo;

public class Tienda {
	Cliente[] clientes;
	Item[] items = { new Item(0, "PC", 800), new Item(1, "RAM", 200), };

	public String registerItem(Item item) {
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
}
