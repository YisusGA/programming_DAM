package colecciones.linkedList;

class Nodo<T> { // No tiene que ser pública, porque no se va a ofrecer al mundo, y va a estar en
				// el mismo paquete que la LinkedList

	// Las propiedades no tienen que ser públicas, porque no se van a ofrecer al
	// mundo, y van a estar en el mismo paquete que la LinkedList. Por eso mismo, no
	// hace falta crear getters ni setters
	T dato;
	Nodo<T> siguiente;

	Nodo(T dato) { // Esto es el método constructor del nodo
		this.dato = dato;
		siguiente = null;
	}

	Nodo() { // Esto es el método constructor del nodo
		this.dato = dato;
		siguiente = null;
	}

}
