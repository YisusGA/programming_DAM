package ejercicio23.modelo;

public class Pedido {
	private int codigo;
	private String nombre;
	private Item[] items;
	private static double IVA;
	private static int codigoPedidoNuevo = 0; // Esto es necesario para que funcione el método generarCodigoPedido(),
												// porque si no, cada vez que
												// se instancie un objeto Pedido, si usamos this.codigo, tendrá valor 0
												// y el método
												// generarCodigoPedido() no hará nada

	// Método constructor
	public Pedido(int codigo, String nombre) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.items = items;
	}

	// Método constructor vacío
	public Pedido() {
	}

	// Getters and setters
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

	// Métodos

	/**
	 * Este método genera un código de Pedido nuevo (incrementando desde 0) para
	 * cada Pedido nuevo que se haga en la tienda
	 * 
	 * @return Un int que identifica a cada pedido de forma única
	 */
	public static int generarCodigoPedido() { // Para que esto funcione, tenemos que usar un método estático que use una
												// variable estática para
												// el código de pedido
		return codigoPedidoNuevo++;
	}

	/**
	 * Método para añadir items a un objeto Pedido
	 * 
	 * @param Objeto Item
	 */
	public void addItems(Item item) {
		if (items == null) {
			items = new Item[1];
			items[0] = item;
		} else {
			Item[] aux = new Item[items.length + 1];
			for (int i = 0; i < items.length; i++) {
				aux[i] = items[i];
			}
			aux[aux.length - 1] = item;
			items = aux;
		}
	}

	/**
	 * Método para eliminar objetos Item de un objeto Pedido
	 * 
	 * @param codigo de Item
	 */
	public void eliminarItems(int codigo) {
		if (items != null) {
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
			items = aux;
		}
	}

	/**
	 * Método para mostrar los items que tiene un pedido
	 * 
	 * @return Lista de objetos Item que contiene el Pedido
	 */
	public String mostrarItems() {
		if (items == null) {
			return "No existe ningún item aún";
		} else {
			String listaItems = "Items: ";
			for (int i = 0; i < items.length; i++) {
				listaItems += "ITEM[Código: " + items[i].getCodigo() + ", Nombre: " + items[i].getNombre()
						+ ", Precio: " + items[i].getPrecio() + "€]";
			}
			return listaItems;
		}
	}

	/**
	 * Método para buscar un item dentro de un pedido
	 * 
	 * @param codigo del Item
	 * @return boolean indicando si se ha encontrado el Item (true) o no (false)
	 */
	public boolean buscarItem(int codigo) {
		boolean encontrado = false;
		if (items != null) {
			for (int i = 0; !encontrado && i < items.length; i++) {
				if (items[i].getCodigo() == codigo) {
					encontrado = true;
				}
			}
		}
		return encontrado;
	}

	/**
	 * Método para calcular el gasto (con IVA) de un Pedido, sumando el precio de
	 * todos sus objetos Item
	 * 
	 * @return double con el gasto total del pedido aplicando el IVA
	 */
	public double gastoPedido() {
		if (items == null) {
			return 0;
		} else {
			double gastoPedido = 0;
			for (int i = 0; i < items.length; i++) {
				gastoPedido += items[i].getPrecio();
			}
			return gastoPedido += gastoPedido * IVA / 100;
		}
	}
}
