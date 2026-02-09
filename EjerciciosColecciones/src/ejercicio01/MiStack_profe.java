package ejercicio01;

public class MiStack_profe<T> {
	private T[] pila = (T[]) new Object[0];

	public void push(T dato) {
		T[] aux = (T[]) new Object[pila.length + 1];
		for (int i = 0; i < pila.length; i++) {
			aux[i] = pila[i];
		}
		aux[aux.length - 1] = dato;
		pila = aux;
	}

	public T pop() {
		T[] pilaAux = (T[]) new Object[pila.length - 1];
		T result = pila[pila.length - 1];
		for (int i = 0; i < pila.length; i++) {
			pilaAux[i] = pila[i];
		}
		pila = pilaAux;
		return result;
	}

}
