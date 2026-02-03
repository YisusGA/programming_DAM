package colecciones.linkedList;

public class MiLinkedList<T> {
	private Nodo<T> inicio;

	public void addFirst(T dato) { // Método para añadir un nuevo nodo al inicio de la lista. Fijarse en que usamos
									// el constructor de Nodo para crear ese nuevo nodo, con el parámetro T dato
									// pasado entre paréntesis
		Nodo<T> nodo = new Nodo<>(dato);
		nodo.siguiente = inicio; // No hace falta que creemos un método setter para esto, porque nuestro nodo
									// sólo va a servir para acceder a él desde la LinkedList, no es algo que se
									// vaya a ofrecer al mundo, como sí sucede cuando creo una clase entidad
		inicio = nodo;
	}

	public void addLast(T dato) {
		Nodo<T> aux = inicio;
		Nodo<T> nuevo = new Nodo<>(dato);
		while (aux.siguiente != null) { // Ciudado: aquí lo que buscamos es iterar hasta llegar al elemento que apunte a
										// un null, para decirle a ese elemento que apunte al nuevo nodo que
										// incorporamos
			aux = aux.siguiente;
		}
		aux.siguiente = nuevo;
	}

	public int size() {
		int size = 0;
		Nodo<T> aux = inicio;
		while (aux != null) { // Cuidado: aquí lo que buscamos es iterar hasta que el último elemento sea
								// null, no hasta llegar al elemento que apunte a un null
			aux = aux.siguiente;
			size++;
		}
		return size;
	}

	public T get(int posicion) { // Queremos que nos devuelva un dato (T), no el Nodo donde está el dato
		Nodo<T> aux = inicio;
		for (int i = 0; i < posicion; i++) {
			aux = aux.siguiente;
		}
		return aux.dato;
	}

	// Error de funcionamiento: cuando le damos la posición 0, borra la 1. Con el
	// resto de posiciones, borra la que toca. Arreglarlo
	public void remove(int posicion) {
		if (posicion == 0) {
			//ToDo
			inicio = inicio.siguiente;
		} else {
			Nodo<T> aux = inicio;
			for (int i = 0; i < posicion; i++) {
				aux = aux.siguiente;
			}
			aux.siguiente = aux.siguiente.siguiente;
		}

	}

}
