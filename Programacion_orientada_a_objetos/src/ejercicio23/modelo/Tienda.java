package ejercicio23.modelo;

public class Tienda {
	Cliente[] clientes;
	Item[] items = {
			new Item(0, "PC", 800),
			new Item(1, "RAM", 200),
	};
	
	public String registerItem (Item item) {
		Item[] aux = new Item[items.length + 1];
		for (int i = 0; i < items.length; i++) {
			aux[i] = items[i];
		}
		aux[aux.length - 1] = item;
		items = aux;
		return "Item registrado correctamente en la tienda";
	}
}
