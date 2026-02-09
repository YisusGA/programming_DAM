package ejercicio01;

import java.util.ArrayList;
import java.util.List;

public class MiStack<T> {
	private List<T> pila = new ArrayList<>();

	public void push(T object) {
		pila.addLast(object);
	}

	public T pop() {
		T object = pila.getLast();
		pila.removeLast();
		return object;
	}

	public int size() { // Crear este método size() nos puede servir para que en determinado punto,
						// podamos tener control sobre el número de elementos apilados
		return pila.size();
	}

	public boolean isEmpty() {
		if (pila.size() == 0) {
			return true;
		}
		return false;
	}

}
