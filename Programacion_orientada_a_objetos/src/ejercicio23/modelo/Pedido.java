package ejercicio23.modelo;

public class Pedido {
	private int codigo;
	private String nombre;
	private Item[] items;
	private static double IVA;
	
	//Método constructor
	public Pedido(int codigo, String nombre, Item[] items) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.items = items;
	}

	//Getter and setters
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Item[] getItems() {
		return items;
	}

	public void setItems(Item[] items) {
		this.items = items;
	}

	public static double getIVA() {
		return IVA;
	}

	public static void setIVA(double iva) {
		IVA = iva;
	}
	
	public String addItems (Item item) {
		if (items == null) {
			Item items [] = new Item[1];
			items[0] = item;
		} else {
			Item[] aux = new Item[items.length + 1];
			for (int i = 0; i < items.length; i++) {
				aux[i] = items[i];
			}
			aux[aux.length - 1] = item;
			items = aux;
		}
		return "Item añadido correctamente";
	}
	
	public String removeItem(int codigo) {
		if (items == null) {
			return "No existe ningún item aún";
		} else {
			int contadorEliminados = 0;
			for (int i = 0; i < items.length; i++) {
				if (items[i].getCodigo() == codigo) {
					items[i] = null;
					contadorEliminados++;
				}
			}
			Item[] aux = new Item[items.length - contadorEliminados];
			for (int i = 0, j = 0; i < items.length; i++) {
				if (items[i] != null) {
					aux[j++] = items[i];
				}
			}
			return "Item eliminado correctamente";
		}
	}
}
