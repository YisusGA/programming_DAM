package ejercicio22.modelo;

public class Cliente {

	private String nif, nombre;
	private Pedido[] pedidos; // Aquí no se instancia nada, estamos declarando una variable array de tipo
								// Pedido

	public Cliente(String nif, String nombre, Pedido[] pedidos) {
		this.nif = nif;
		this.nombre = nombre;
		this.pedidos = pedidos;
	}

	public Cliente(String nif, String nombre) {
		this.nif = nif;
		this.nombre = nombre;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Pedido[] getPedidos() {
		return pedidos;
	}

	public void setPedidos(Pedido[] pedidos) {
		this.pedidos = pedidos;
	}

	public String toString() { // Es necesario meter este ternario porque si el num pedidos es 0, nos daría
								// error NullPointer si no metemos este ternario
		return "Cliente [nif=" + nif + ", nombre=" + nombre + ", num pedidos="
				+ ((pedidos == null) ? 0 : pedidos.length) + "]";
	}

	public void agregarPedido(Pedido p) {
		// Si aún no hay pedidos, añadimos una posición al array y la rellenamos
		if (pedidos == null) {
			pedidos = new Pedido[1];
			pedidos[0] = p;
			// Si ya hay pedidos, hacemos el array más grande en 1 posición y agregamos el
			// pedido a la nueva posición
		} else {
			Pedido[] aux = new Pedido[pedidos.length + 1]; // Creamos un array aux
			for (int i = 0; i < pedidos.length; i++) {
				aux[i] = pedidos[i];
			}
			aux[aux.length - 1] = p;
			pedidos = aux;
		}
	}

	public void mostrarFactura() {
		if (pedidos == null) {
			System.err.println("Este cliente aún no ha realizado pedidos");
			System.out.println();
		} else {
			System.out.println("Nombre: " + nombre);
			System.out.println("**********************");
			double suma = 0;
			for (Pedido p : pedidos) {
				System.out.println(p.getDescripcion() + "-" + p.getPrecio());
				suma += p.getPrecio();
			}
			System.out.println("***********************");
			System.out.println("Total a pagar: " + suma);
			System.out.println("***********************");
			System.out.println();
		}
	}

	public boolean encontrarCodigoPedido(int codigoPedido) {
		boolean encontradoPedido = false;
		if (pedidos != null) {
			for (Pedido p : pedidos) {
				if (codigoPedido == p.getCodigo()) {
					encontradoPedido = true;
				}
			}
		}
		return encontradoPedido;
	}

	public String mostrarPedidosCliente() {
		String listaPedidos = "";
		if (pedidos != null) {
			for (Pedido p : pedidos) {
				listaPedidos += p.getDescripcion() + " - ";
			}
		} else {
			listaPedidos = "Este cliente no ha realizado pedidos aún";
		}
		return listaPedidos;
	}

	public double gastoTotal() {
		if (pedidos == null) {
			return 0; // Un return devuelve un valor y además termina el método automáticamente. Por
						// tanto, no hace falta meter un else aquí
		}
		double suma = 0;
		for (Pedido p : pedidos) {
			suma += p.getPrecio();
		}
		suma += suma * Pedido.IVA / 100;
		return suma;
	}

	public int numeroPedidos() {
		int numeroPedidos = 0;
		if (pedidos != null) {
			for (int i = 0; i < pedidos.length; i++) {
				if (pedidos[i] != null) {
					numeroPedidos++;
				}
			}
		}
		return numeroPedidos;
	}

	public void modificarPrecioPedido(int posicion, double nuevoPrecio) {
		pedidos[posicion].setPrecio(nuevoPrecio);
	}

}
