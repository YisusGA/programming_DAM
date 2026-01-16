package ejercicio23.modelo;

public class Cliente {
	private String nombre;
	private String nif;
	private Pedido[] pedidos;

	public Cliente(String nombre, String nif) {
		this.nombre = nombre;
		this.nif = nif;
	}

	// Constructor vacío
	public Cliente() {
	}

	// Getters and setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	// Métodos

	/**
	 * Método para añadir un objeto Pedido a un Cliente
	 * 
	 * @param pedido
	 */
	public void añadirPedido(Pedido pedido) {
		if (pedidos == null) {
			pedidos = new Pedido[1];
			pedidos[0] = pedido;
		} else {
			Pedido[] aux = new Pedido[pedidos.length + 1];
			for (int i = 0; i < pedidos.length; i++) {
				aux[i] = pedidos[i];
			}
			aux[aux.length - 1] = pedido;
			pedidos = aux;
		}
	}

	/**
	 * Método para buscar un Pedido dentro de un Cliente
	 * 
	 * @param codigo de Pedido
	 * @return boolean indicando si se ha encontrado el Pedido (true) o no (false)
	 */
	public boolean buscarPedido(int codigo) {
		boolean encontrado = false;
		if (pedidos != null) {
			int posicion = 0;
			for (int i = 0; !encontrado && i < pedidos.length; i++) {
				if (pedidos[i].getCodigo() == codigo) {
					encontrado = true;
				}
			}
		}
		return encontrado;
	}

	/**
	 * Método para eliminar un Pedido de un Cliente
	 * 
	 * @param codigo de Pedido
	 */
	public void eliminarPedido(int codigo) {
		if (pedidos != null) {
			boolean encontrado = false;
			int posicion = 0;
			for (int i = 0; !encontrado && i < pedidos.length; i++) {
				if (pedidos[i].getCodigo() == codigo) {
					encontrado = true;
					posicion = i;
				}
			}
			if (encontrado) {
				Pedido[] aux = new Pedido[pedidos.length - 1];
				for (int i = 0, j = 0; i < pedidos.length; i++) {
					if (i != posicion) {
						aux[j++] = pedidos[i];
					}
				}
				pedidos = aux;
			}
		}
	}

	/**
	 * Método para mostrar todos los objetos Pedido de un Cliente
	 * 
	 * @return Un String con los datos de todos los objetos Pedido de un Cliente
	 */
	public String mostrarPedidos() {
		if (pedidos == null) {
			return "No existen pedidos asociados al cliente";
		} else {
			String listaPedidos = "Pedidos: ";
			for (int i = 0; i < pedidos.length; i++) {
				listaPedidos += "PEDIDO[Código: " + pedidos[i].getCodigo() + ", Nombre: " + pedidos[i].getNombre()
						+ ". " + pedidos[i].mostrarItems() + "]";
			}
			return listaPedidos;
		}
	}

	/**
	 * Método para buscar un objeto Item dentro de todos los objetos Pedido de un
	 * Cliente
	 * 
	 * @param codigo del Item
	 * @return boolean indicando si se ha encontrado el Item (true) o no (false)
	 */
	public boolean buscarItem(int codigo) {
		if (pedidos == null) {
			return false;
		} else {
			boolean encontrado = false;
			for (int i = 0; !encontrado && i < pedidos.length; i++) {
				if (pedidos[i].buscarItem(codigo)) {
					encontrado = true;
				}
			}
			return encontrado;
		}
	}

	/**
	 * Método para eliminar objetos Item de todos los objetos Pedido de un Cliente
	 * 
	 * @param codigo de Item
	 */
	public void eliminarItems(int codigo) {
		if (pedidos != null) {
			for (int i = 0; i < pedidos.length; i++) {
				pedidos[i].eliminarItems(codigo);
			}
		}
	}

	/**
	 * Método para calcular el gasto total de un Cliente, sumando el precio de todos
	 * sus objetos Pedido (ya calculados con IVA)
	 * 
	 * @return double con el gasto total del Cliente (con el IVA ya aplicado)
	 */
	public double gastoTotal() {
		if (pedidos == null) {
			return 0;
		} else {
			double gastoTotal = 0;
			for (int i = 0; i < pedidos.length; i++) {
				gastoTotal += pedidos[i].gastoPedido();
			}
			return gastoTotal;
		}
	}

	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", nif=" + nif + "]";
	}

}
