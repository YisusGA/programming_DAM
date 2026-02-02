package colecciones.linkedList;

public class MiLinkedList<T> {
	private Nodo<T> inicio;

	public void addFirst(T dato) { // Método para añadir un nuevo nodo al inicio de la lista. Fijarse en que usamos
									// el constructor de Nodo para crear ese nuevo nodo, con el parámetro T dato
									// pasado entre paréntesis
		Nodo<T> nodo = new Nodo<>(dato);
		nodo.setSiguiente(inicio);
		inicio = nodo;
	}

	public int size() { // No sé si esto está bien
		// ToDo
		int size = 0;
		Nodo<T> nodo = new Nodo<>();
		nodo.setSiguiente(inicio);
		do {
			nodo.setSiguiente(nodo);
			size++;
		} while (nodo.getSiguiente() != null);
		return size;
	}

	public Nodo<T> get() {
		// ToDo
	}

}
