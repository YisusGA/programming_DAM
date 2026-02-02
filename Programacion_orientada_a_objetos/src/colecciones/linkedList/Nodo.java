package colecciones.linkedList;

public class Nodo<T> {
	
	private T dato;
	private Nodo<T> ste; //ste = siguiente
	
	Nodo(T dato) {
		this.dato = dato;
		ste = null;
	}

}
