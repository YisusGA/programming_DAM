package colecciones.arrayList;

public class MiArrayChulo<T> {
	private T[] datos = (T[]) new Object[0]; // Hay que instanciar como Object y hacer el casting a T

	public void add(T dato) {
		T[] aux = (T[]) new Object[datos.length + 1]; // Hay que instanciar como Object y hacer el casting a T
		for (int i = 0; i < datos.length; i++) {
			aux[i] = datos[i];
		}
		aux[aux.length - 1] = dato;
		datos = aux;
	}

	public T get(int posicion) {
		if (posicion > datos.length - 1 || posicion < 0) {
			return null;
		} else {
			return datos[posicion];
		}
	}

	public int size() {
		return datos.length;
	}

	public void delete(int posicion) {
		// ToDo
	}

}
