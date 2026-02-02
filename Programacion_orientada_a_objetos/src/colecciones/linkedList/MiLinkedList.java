package colecciones.linkedList;

public class MiLinkedList<T> {
	private Nodo<T> inicio;
	
	public void addFirst (T dato) {
		Nodo<T> nodo = new Nodo<>(dato);
		nodo.ste = inicio;
		inicio = nodo;
	}

}
