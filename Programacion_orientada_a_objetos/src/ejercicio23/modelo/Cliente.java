package ejercicio23.modelo;

public class Cliente {
	private String nombre;
	private String nif;
	private Pedido[] pedidos;
	
	public Cliente(String nombre, String nif) {
		this.nombre = nombre;
		this.nif = nif;
	}

	//Getters and setters
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
	
	public String mostrarPedidos() {
		if (pedidos == null) {
			return "No existen pedidos asociados al cliente";
		} else { 
			String listaPedidos = "Pedidos: ";
			for (int i = 0; i < pedidos.length; i++) {
				listaPedidos += "PEDIDO[Código: " + pedidos[i].getCodigo() + ", Nombre: " + pedidos[i].getNombre() + ". " + pedidos[i].mostrarItems() + "]";
			}
			return listaPedidos;
		}
	}
	
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
	
	public void eliminarItems (int codigo) {
		if (pedidos != null) {
			for (int i = 0; i < pedidos.length; i++) {
				pedidos[i].eliminarItems(codigo);
			}
		} 
	}
	
	public double gastoTotal () {
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

	
	public String toString() {
		return "Cliente [nombre=" + nombre + ", nif=" + nif + "]";
	}
	
	
	
}
