package colecciones.linkedList;

public class Nodo<T> {

	private T dato;
	private Nodo<T> siguiente;

	Nodo(T dato) { // Esto es el método constructor del nodo
		this.dato = dato;
		siguiente = null;
	}
	
	Nodo() { // Esto es el método constructor del nodo
		this.dato = dato;
		siguiente = null;
	}
	
	public Nodo<T> getSiguiente() {
		return this.siguiente;
	}

	//Método para cambiar a dónde apunta el nuevo nodo que se inserte en la LinkedList
	public void setSiguiente(Nodo<T> siguiente) {
		this.siguiente = siguiente;
	}

}
