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
	
	public String añadirPedido(Pedido pedido) {
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
		return "Pedido añadido correctamente";
	}
	
	public String eliminarPedido(int codigo) {
		if (pedidos == null) {
			return "Este cliente aún no tiene pedidos";
		} else {
			boolean encontrado = false;
			int posicion = 0;
			while (!encontrado && posicion < pedidos.length) {
				if (pedidos[posicion].getCodigo() == codigo) {
					encontrado = true;
				}
			}
			if (encontrado) {
				//Me he quedado aquí
				return "Pedido eliminado correctamente";
			} else {
				return "El código de pedido no existe para este cliente";
			}
		}
	}
	
}
