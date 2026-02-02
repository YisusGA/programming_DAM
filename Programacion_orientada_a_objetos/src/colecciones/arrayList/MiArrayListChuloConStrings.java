package colecciones.arrayList;

public class MiArrayListChuloConStrings {
	private String[] datos = new String[0];

	public void add(String dato) {
		String[] aux = new String[datos.length + 1];
		for (int i = 0; i < datos.length; i++) {
			aux[i] = datos[i];
		}
		aux[aux.length - 1] = dato;
		datos = aux;
	}

	public String get(int posicion) {
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
		if (posicion > 0 && posicion < datos.length - 1) {
			String[] aux = new String[datos.length - 1];
			for (int i = 0, j = 0; i < datos.length; i++) {
				if (i != posicion) {
					aux[j++] = datos[i];
				}
			}
			datos = aux;
		}

	}

}
