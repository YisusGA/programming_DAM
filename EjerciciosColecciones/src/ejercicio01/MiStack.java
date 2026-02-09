package ejercicio01;

import java.util.ArrayList;
import java.util.List;

public class MiStack<T> {
	private List<T> pila = new ArrayList<>();

	/**
	 * Método que añade un elemento a la parte superior de la pila
	 * @param object El objeto a añadir
	 */
	public void push(T object) {
		pila.addLast(object);
	}
	
	/**
	 * Método que elimina y devuelve el elemento en la parte superior (el último añadido) pero sin eliminarlo
	 * @return el elemento superior del stack
	 */
	public T pop() {
		T object = pila.getLast();
		pila.removeLast();
		return object;
	}

	/**
	 * Método que devuelve el elemento en la parte superior (el último añadido) pero sin eliminarlo
	 * @return el elemento superior del stack
	 */
	public T peek() {
		return pila.getLast();
	}

	public int size() { // Crear este método size() nos puede servir para que en determinado punto,
						// podamos tener control sobre el número de elementos apilados
		return pila.size();
	}

	// Esto está copiado tal cual de la clase java.util.Stack
	/**
	 * Returns the 1-based position where an object is on this stack. If the object
	 * {@code o} occurs as an item in this stack, this method returns the distance
	 * from the top of the stack of the occurrence nearest the top of the stack; the
	 * topmost item on the stack is considered to be at distance {@code 1}. The
	 * {@code equals} method is used to compare {@code o} to the items in this
	 * stack.
	 *
	 * @param o the desired object.
	 * @return the 1-based position from the top of the stack where the object is
	 *         located; the return value {@code -1} indicates that the object is not
	 *         on the stack.
	 */
	public int search(T object) {
		int i = pila.lastIndexOf(object); // Para que funcione correctamente este método lastIndexOf(Object o),
											// realmente habría que incorporar algún método de igualdad entre los
											// objetos que vaya a contener la pila en el Main y que por tanto vayamos a
											// comparar. En este caso concreto, en el main hacemos una pila de String,
											// que ya tienen su método equals implementado, así que no haría falta. Si
											// hiciéramos en el Main, por ejemplo, una pila de obajtos Alumno, en la
											// clase Alumno tendríamos que sobreescribir el método equals(Object c) de
											// Object
		if (i >= 0) {
			return pila.size() - i;
		}
		return -1;
	}

	public boolean isEmpty() {
		if (pila.size() == 0) {
			return true;
		}
		return false;
	}

}
