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
		Nodo<T> nodo = new Nodo<>(dato);
		while (aux.siguiente != null) { // Ciudado: aquí lo que buscamos es iterar hasta llegar al elemento que apunte a
										// un null, para decirle a ese elemento que apunte al nuevo nodo que
										// incorporamos
			aux = aux.siguiente;
		}
		aux.siguiente = nodo;
	}

	public int size() {
		int size = 0;
		Nodo<T> aux = inicio;
		while (aux != null) { // Cuidado: aquí lo que buscamos es iterar hasta que el último elemento sea
								// null, no hasta llegar al elemento que apunte a un null. Esto es así porque el
								// size comienza en 0, y si no llegáramos hasta el elemento null, no contaríamos
								// el primer elemento de la LinkedList, pues la primera vez que entramos en el
								// bucle, ya pasamos al elemento con la segunda posición, pues antes de entrar
								// en el bucle, ya hemos asignado a aux la dirección de memoria del primer nodo
			aux = aux.siguiente;
			size++;
		}
		return size;
	}

	public T get(int posicion) { // Queremos que nos devuelva un dato (T), no el Nodo donde está el dato

		Nodo<T> aux = inicio; // Aquí, aux se convierte en el primer nodo de la lista (posicion 0), pues
								// inicializamos a inicio, que apunta a la dirección de memoria del primer nodo
								// (y es por tanto, el primer nodo)

		for (int i = 0; i < posicion; i++) { // Nos paramos antes de que i == posicion. Si la posición es, por ejemplo,
												// 2, nos paramos cuando i vale 1. En la primera iteración, aux pasa a
												// ser el segundo elemento (posicion 1), e i pasa a valer 1. En la
												// segunda iteración, aux pasa a ser el tercer elemento (posicion 2, la
												// buscada), e i pasa a valer 2. Ya no se vuelve a entrar en el bucle. Y
												// como aux ya es el elemento que queremos, devolvemos aux.dato
			aux = aux.siguiente;
		}
		return aux.dato;
	}

	public void remove(int posicion) {
		if (posicion == 0) { // Tenemos que meter este caso, porque si no lo hacemos, si queremos eliminar la
								// posición 0, siempre va a eliminar la posición 1. El resto de posiciones no
								// tienen ese problema
			inicio = inicio.siguiente;
		} else {
			Nodo<T> aux = inicio;
			for (int i = 0; i < posicion - 1; i++) { // Super importante: la i nunca debe alcanzar el valor de posición,
														// pues si lo alcanzará, aux se convertiría en el último
														// elemento de la lista, y en la línea después del for,
														// estaríamos haciendo que aux.siguiente apuntara a un elemento
														// que no existe, pues no hay aux.siguiente.siguiente. Si nos
														// quedamos una posición antes del elemento que queremos
														// eliminar, no tenemos este problema. Si se quiere eliminar la
														// última posición de la lista, aux.siguiente terminará
														// apuntando a un null, que es lo que debe hacer el último
														// elemento de una LinkedList; si no se elimina el último
														// elemento, entonces aux.siguiente acabará apuntando al
														// elemento que está después del que queremos eliminar, dejando
														// así abandonado y descolgado al elemento que queremos
														// eliminar. Y eventualmente, este elemento será eliminado por
														// el recolector de basura
				aux = aux.siguiente;
			}
			aux.siguiente = aux.siguiente.siguiente;
		}

	}

}
